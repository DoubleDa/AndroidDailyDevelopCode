package com.dyx.hlirp.utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;

/**
 * project name：Heterogenous-Layouts-inside-RecyclerView-Project
 * class describe：
 * create person：dayongxin
 * create time：16/7/18 下午9:58
 * alter person：dayongxin
 * alter time：16/7/18 下午9:58
 * alter remark：
 */
public class JsonHelper {
    public static String toJson(Object src) {
        return new Gson().toJson(src);
    }

    public static <T> T fromJson(String json, Class<T> clazz) throws Exception {
        return new Gson().fromJson(json, clazz);
    }

    public static <T> List<T> fromJsonArray(String json, Class<T> clazz) throws Exception {
        List<T> lst = new ArrayList<T>();

        JsonArray array = new JsonParser().parse(json).getAsJsonArray();
        for (final JsonElement elem : array) {
            lst.add(new Gson().fromJson(elem, clazz));
        }

        return lst;
    }
}
