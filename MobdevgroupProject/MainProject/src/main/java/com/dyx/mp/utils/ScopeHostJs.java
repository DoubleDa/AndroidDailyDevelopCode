package com.dyx.mp.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.webkit.WebView;
import android.widget.Toast;

import com.dyx.lw.JsCallback;
import com.dyx.mp.R;
import com.dyx.mp.task.TaskExecutor;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-04-05
 * Time      : 16:47
 * Summary   : js脚本所能执行的函数空间
 * Copyright : Copyright (c) 2016
 */
public class ScopeHostJs {
    /**
     * js调用Toast
     *
     * @param webView
     * @param msg
     */
    public static void jsToast(WebView webView, String msg) {
        Toast.makeText(webView.getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * 记录js调用Java耗费时间
     *
     * @param webView
     * @param startTime
     */
    public static void jsCallJavaTime(WebView webView, long startTime) {
        startTime = System.currentTimeMillis() - startTime;
        alert(webView, String.valueOf(startTime));
    }

    /**
     * 弹出系统提示框
     *
     * @param webView
     * @param s
     */
    public static void alert(WebView webView, String s) {
        AlertDialog.Builder builder = new AlertDialog.Builder(webView.getContext());
        builder.setTitle(webView.getContext().getString(R.string.app_name));
        builder.setMessage(s);
        builder.setPositiveButton(webView.getContext().getString(R.string.app_name), new AlertDialog.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setCancelable(false);
        builder.create();
        builder.show();
    }

    /**
     * 获取设备IMSI
     *
     * @param webview
     * @return
     */
    public static String getIMSI(WebView webview) {
        return ((TelephonyManager) webview.getContext().getSystemService(Context.TELEPHONY_SERVICE)).getSubscriberId();
    }

    /**
     * 获取系统版本
     *
     * @param webview
     * @return
     */
    public static int getOsVersion(WebView webview) {
        return Build.VERSION.SDK_INT;
    }

    /**
     * 退出当前界面
     *
     * @param webview
     */
    public static void finishMe(WebView webview) {
        if (webview.getContext() instanceof Activity) {
            ((Activity) webview.getContext()).finish();
        }
    }

    /**
     * 获取对象键值对根据json对象
     *
     * @param webview
     * @param object
     * @return
     */
    public static String getObjKeyValByJsonObj(WebView webview, JSONObject object) {
        Iterator it = object.keys();
        String result = null;
        if (it.hasNext()) {
            String key = (String) it.next();
            try {
                result = key + ":" + object.getString(key);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 直接返回传入的JSONObject
     *
     * @param webview
     * @param object
     * @return
     */
    public static JSONObject getJsonObjByJsonObj(WebView webview, JSONObject object) {
        return object;
    }

    public static class ResultJavaObj {
        public int intField;
        public String stringField;
        public boolean booleanField;
    }

    /**
     * 获取Java Object
     *
     * @param webview
     * @return
     */
    public static List<ResultJavaObj> getJavaObj(WebView webview) {
        ResultJavaObj obj = new ResultJavaObj();
        obj.intField = 5;
        obj.stringField = "test";
        obj.booleanField = true;
        List<ResultJavaObj> mList = new ArrayList<ResultJavaObj>();
        mList.add(obj);
        return mList;
    }

    public static void delayJsCallBack(WebView webview, int time, final String msg, final JsCallback jsCallback) {
        TaskExecutor.scheduleTask(time * 1000, new Runnable() {
            @Override
            public void run() {
                try {
                    jsCallback.apply(msg);
                } catch (JsCallback.JsCallbackException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static int overloadMethod(WebView webView, int value) {
        return value;
    }

    public static String overloadMethod(WebView webView, String value) {
        return value;
    }

    public static long getLongType(WebView webView, long value) {
        return value;
    }
}  