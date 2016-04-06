package com.dyx.lw;

import android.text.TextUtils;
import android.webkit.WebView;

import com.dyx.lw.constants.AppConstants;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-04-05
 * Time      : 13:44
 * Summary   : JavaScript访问Java
 * Copyright : Copyright (c) 2016
 */
public class JsCallJava {
    private final static String TAG = "JsCallJava";
    private final static String RETURN_RESULT_FORMATT = "{\"code\":%d,\"result\":%s}";
    private HashMap<String, Method> mMethodHashMap;
    //注入名称
    private String mInjectName;
    //预加载JavaScript接口
    private String mPreloadInterfaceJs;
    private Gson mGson;

    public JsCallJava(String mInjectName, Class injectCla) {
        try {
            if (!TextUtils.isEmpty(mInjectName)) {
                throw new Exception("InjectName is not null!");
            }
            this.mInjectName = mInjectName;
            mMethodHashMap = new HashMap<String, Method>();
            //获取class的所有方法
            Method[] methods = injectCla.getDeclaredMethods();
            //拼接字符串
            StringBuilder sb = new StringBuilder("javascript:(function(b){console.log(\"");
            sb.append(mInjectName);
            sb.append("initialization begin\");var a={queue:[],callback:function(){var d=Array.prototype.slice.call(arguments,0);var c=d.shift();var e=d.shift();this.queue[c].apply(this,d);if(!e){delete this.queue[c]}}};");
            for (Method method : methods) {
                String sign;
                if (method.getModifiers() != (Modifier.PUBLIC | Modifier.STATIC) || (sign = getJavaMethodSign(method)) == null) {
                    continue;
                }
                mMethodHashMap.put(sign, method);
                sb.append(String.format("a.%s=", method.getName()));
            }

            sb.append("function(){var f=Array.prototype.slice.call(arguments,0);if(f.length<1){throw\"");
            sb.append(mInjectName);
            sb.append("call error, message:miss method name\"}var e=[];for(var h=1;h<f.length;h++){var c=f[h];var j=typeof c;e[e.length]=j;if(j==\"function\"){var d=a.queue.length;a.queue[d]=c;f[h]=d}}var g=JSON.parse(prompt(JSON.stringify({method:f.shift(),types:e,args:f})));if(g.code!=200){throw\"");
            sb.append(mInjectName);
            sb.append("call error, code:\"+g.code+\", message:\"+g.result}return g.result};Object.getOwnPropertyNames(a).forEach(function(d){var c=a[d];if(typeof c===\"function\"&&d!==\"callback\"){a[d]=function(){return c.apply(a,[d].concat(Array.prototype.slice.call(arguments,0)))}}});b.");
            sb.append(mInjectName);
            sb.append("=a;console.log(\"");
            sb.append(mInjectName);
            sb.append("initialization end\")})(window);");
            mPreloadInterfaceJs = sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getJavaMethodSign(Method method) {
        String sign = method.getName();
        Class[] clas = method.getParameterTypes();
        int len = clas.length;
        if (len < 1 || clas[0] != WebView.class) {
            return null;
        }
        for (int k = 1; k < len; k++) {
            Class cla = clas[k];
            if (cla == String.class) {
                sign += "_S";
            } else if (cla == int.class || cla == long.class || cla == double.class || cla == float.class) {
                sign += "_N";
            } else if (cla == boolean.class) {
                sign += "_B";
            } else if (cla == JSONObject.class) {
                sign += "_O";
            } else if (cla == JsCallJava.class) {
                sign += "_F";
            } else {
                sign += "_P";
            }
        }
        return sign;
    }

    public String getmPreloadInterfaceJs() {
        return mPreloadInterfaceJs;
    }

    public String call(WebView webView, String jsonStr) {
        if (!TextUtils.isEmpty(jsonStr)) {
            try {
                JSONObject jsonObject = new JSONObject(jsonStr);
                //获取方法名称
                String methodName = jsonObject.getString("method");
                //获取类型
                JSONArray typeArray = jsonObject.getJSONArray("types");
                //获取变量
                JSONArray argsArray = jsonObject.getJSONArray("args");
                String sign = methodName;
                int argsLen = argsArray.length();
                Object[] objects = new Object[argsLen + 1];
                int numIndex = 0;
                String currentType;

                objects[0] = webView;
                for (int k = 0; k < argsLen; k++) {
                    currentType = typeArray.optString(k);
                    if ("string".equals(currentType)) {
                        sign += "_S";
                        objects[k + 1] = argsArray.isNull(k) ? null : argsArray.getString(k);
                    } else if ("number".equals(currentType)) {
                        sign += "_N";
                        numIndex = numIndex * 10 + k + 1;
                    } else if ("boolean".equals(currentType)) {
                        sign += "_B";
                        objects[k + 1] = argsArray.isNull(k) ? null : argsArray.getBoolean(k);
                    } else if ("Object".equals(currentType)) {
                        sign += "_O";
                        objects[k + 1] = argsArray.isNull(k) ? null : argsArray.getJSONObject(k);
                    } else if ("function".equals(currentType)) {
                        sign += "_F";
                        objects[k + 1] = new JsCallback(webView, mInjectName, argsArray.getInt(k));
                    } else {
                        sign += "_P";
                    }
                }

                Method currentMethod = mMethodHashMap.get(sign);
                //匹配失败
                if (currentMethod == null) {
                    return getReturn(jsonStr, 500, "Not find the method" + "(" + sign + ")");
                }

                //类型匹配
                if (numIndex > 0) {
                    Class[] clas = currentMethod.getParameterTypes();
                    int currentIndex;
                    Class currentCla;
                    while (numIndex > 0) {
                        currentIndex = numIndex - numIndex / 10 * 10;
                        currentCla = clas[currentIndex];
                        if (currentCla == int.class) {
                            objects[currentIndex] = argsArray.getInt(currentIndex - 1);
                        } else if (currentCla == long.class) {
                            objects[currentIndex] = Long.parseLong(argsArray.getString(currentIndex - 1));
                        } else {
                            objects[currentIndex] = argsArray.getDouble(currentIndex - 1);
                        }
                        numIndex /= 10;
                    }
                }
                return getReturn(jsonStr, AppConstants.NETWORK_STATE_200, currentMethod.invoke(null, objects));
            } catch (Exception e) {
                if (e.getCause() != null) {
                    return getReturn(jsonStr, AppConstants.NETWORK_STATE_500, "method execute error:" + e.getCause().getMessage());
                }
                return getReturn(jsonStr, AppConstants.NETWORK_STATE_500, "method execute error:" + e.getMessage());
            }
        } else {
            return getReturn(jsonStr, AppConstants.NETWORK_STATE_500, "call data empty");
        }
    }

    private String getReturn(String jsonStr, int i, Object s) {
        String injectStr;
        if (s == null) {
            injectStr = "null";
        } else if (s instanceof String) {
            s = ((String) s).replace("\"", "\\\"");
            injectStr = "\"" + s + "\"";
        } else if (!(s instanceof Integer) && !(s instanceof Double) && !(s instanceof Long) && !(s instanceof Float) && !(s instanceof Boolean) && !(s instanceof JSONObject)) {
            if (mGson == null) {
                mGson = new Gson();
            }
            injectStr = mGson.toJson(s);
        } else {
            injectStr = String.valueOf(s);
        }
        String resultStr = String.format(RETURN_RESULT_FORMATT, i, injectStr);
        return resultStr;
    }
}