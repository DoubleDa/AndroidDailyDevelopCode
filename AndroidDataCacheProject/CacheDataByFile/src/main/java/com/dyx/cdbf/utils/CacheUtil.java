package com.dyx.cdbf.utils;

import android.content.Context;
import android.os.Environment;

import com.dyx.cdbf.constant.Constants;

import java.io.File;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-04-14
 * Time      : 14:15
 * Summary   : cache data by file util
 * Copyright : Copyright (c) 2016
 */
public class CacheUtil {
    private static final String TAG = CacheUtil.class.getName();
    /**
     * set cache expired time
     */
    //short 5 minutes
    public static final int CACHE_TIMEOUT_SHORT = 1000 * 60 * 5;
    //middle 1 hour
    public static final int CACHE_TIMEOUT_MIDDLE = 1000 * 60 * 60;
    //long 1 day
    public static final int CACHE_TIMEOUT_LONG = 1000 * 60 * 60 * 24;
    //special long 1 week
    public static final int CACHE_TIMEOUT_SPECIAL_LONG = 1000 * 60 * 60 * 24 * 7;

    /**
     * enum
     */
    public enum CacheModel {
        CACHE_TIMEOUT_MODEL_SHORT, CACHE_TIMEOUT_MODEL_MIDDLE, CACHE_TIMEOUT_MODEL_LONG, CACHE_TIMEOUT_MODEL_SPECIAL_LONG;
    }

    /**
     * 获取数据从缓存文件
     *
     * @param url
     * @param model
     * @return
     */
    public static String getDataByUrl(String url, CacheModel model, Context context) {
        if (url == null) {
            return null;
        }
        //get cache result
        String result = null;
        //cache path
        String cacheFilePath = Constants.DATA_CACHE_DIR + StringUtils.convertUrl(EncryptUtils.encryptToMD5(url));
        //cache file
        File file = new File(cacheFilePath);
        if (file.exists() && file.isFile()) {
            long expiredTime = System.currentTimeMillis() - file.lastModified();
            if (!NetworkUtils.isNetworkConnected(context)) {
                if (expiredTime < 0) {
                    return null;
                }
                if (model == CacheModel.CACHE_TIMEOUT_MODEL_SHORT) {
                    if (expiredTime > CACHE_TIMEOUT_SHORT) {
                        return null;
                    }
                } else if (model == CacheModel.CACHE_TIMEOUT_MODEL_MIDDLE) {
                    if (expiredTime > CACHE_TIMEOUT_MIDDLE) {
                        return null;
                    }
                } else if (model == CacheModel.CACHE_TIMEOUT_MODEL_LONG) {
                    if (expiredTime > CACHE_TIMEOUT_LONG) {
                        return null;
                    }
                } else {
                    if (expiredTime > CACHE_TIMEOUT_SPECIAL_LONG) {
                        return null;
                    }
                }
            }
        }

        try {
            result = FileUtils.getDataFromFile(file);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 将数据缓存进文件
     *
     * @param data
     * @param url
     */
    public static void putDataToFile(String data, String url) {
        if (Constants.DATA_CACHE_DIR == null) {
            return;
        }
        File dirFile = new File(Constants.DATA_CACHE_DIR);
        if (!dirFile.exists() && Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            dirFile.mkdir();
        }
        File file = new File(Constants.DATA_CACHE_DIR + StringUtils.convertUrl(EncryptUtils.encryptToMD5(url)));
        try {
            FileUtils.putDataToFile(file, data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除缓存记录
     *
     * @param cacheFile
     */
    public static void clearCacheFile(File cacheFile) {
        if (cacheFile == null) {
            //为空
            if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                try {
                    File mFile = new File(Environment.getExternalStorageDirectory().getPath() + "/dyx/cache/");
                    if (mFile.exists()) {
                        clearCacheFile(mFile);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (cacheFile.isFile()) {
            //为文件
            cacheFile.delete();
        } else if (cacheFile.isDirectory()) {
            //为目录
            File[] files = cacheFile.listFiles();
            for (int i = 0; i < files.length; i++) {
                clearCacheFile(files[i]);
            }
        }
    }
}  