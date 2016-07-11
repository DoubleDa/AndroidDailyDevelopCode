package com.dyx.library.utils;

import android.content.Context;

import com.dyx.library.R;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * project name：Chulaihai-Sample
 * class describe：资源加载工具类
 * create person：dayongxin
 * create time：16/6/27 下午1:26
 * alter person：dayongxin
 * alter time：16/6/27 下午1:26
 * alter remark：
 */
public class ResourcesUtil {
    /**
     * 状态码映射
     */
    private static Map<String, String> codeToDescriptionMap;

    /**
     * 初始化资源
     */
    public static void init(Context context) {
        loadTipCodeAndDescription(context);
    }

    /**
     * @param context
     * @return 加载状态码及其对应值
     */
    private static Map<String, String> loadTipCodeAndDescription(Context context) {
        try {
            if (codeToDescriptionMap == null) {
                codeToDescriptionMap = new HashMap<String, String>();
                final List<String> codeList = loadStringArrayAsList(context,
                        R.array.servertip_codes);
                final List<String> descriptionList = loadStringArrayAsList(
                        context, R.array.servertip_msgs);
                for (int i = 0; i < codeList.size(); i++) {
                    codeToDescriptionMap.put(codeList.get(i),
                            descriptionList.get(i));
                }
            }
        } catch (Exception e) {
        }
        return codeToDescriptionMap;
    }

    /**
     * @param context
     * @param msgId
     * @return 将资源文件映射为List
     */
    private static List<String> loadStringArrayAsList(Context context, int msgId) {
        String[] types = context.getResources().getStringArray(msgId);
        return Arrays.asList(types);
    }

    /**
     * 获取状态码跟描述映射Map
     *
     * @return
     */
    public static Map<String, String> getCodeToDescriptionMap() {
        return codeToDescriptionMap;
    }
}
