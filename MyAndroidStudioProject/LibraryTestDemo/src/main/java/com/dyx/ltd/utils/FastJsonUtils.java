package com.dyx.ltd.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Da on 2016/3/30.
 * fast json util
 */
public class FastJsonUtils {
    /**
     * json-->JavaBean
     */
    public static <T> T getBeanByJsonStr(String jsonStr, Class<T> cla) {
        T t = null;
        try {
            t = JSON.parseObject(jsonStr, cla);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    /**
     * json-->List<JavaBean>
     */
    public static <T> List<T> getListByJsonStr(String jsonStr, Class<T> cla) {
        List<T> list = new ArrayList<T>();
        try {
            list = JSON.parseArray(jsonStr, cla);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * json-->List<String>
     */
    public static <T> List<T> getListByJsonStr(String jsonStr) {
        List<T> list = new ArrayList<T>();
        try {
            list = (List<T>) JSON.parseArray(jsonStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * json-->List<Map<String,Object>>
     */
    public static List<Map<String, Object>> getListMapByJsonStr(String jsonStr) {
        List<Map<String, Object>> lists = new ArrayList<Map<String, Object>>();
        try {
            lists = JSON.parseObject(jsonStr, new TypeReference<List<Map<String, Object>>>() {
            }.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lists;
    }
}
