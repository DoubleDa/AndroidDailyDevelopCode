package com.dyx.ltd.utils;

import android.content.Context;
import android.os.Environment;

import java.io.File;

/**
 * Created by Da on 2016/3/29.
 * App data clear
 */
public class AppDataManager {
    /**
     * clear app inner cache(/data/data/com.xxx.xxx/cache)
     */
    public static void clearAppInnerCache(Context context) {
        deleteFilesByDirectory(context.getCacheDir());
    }

    /**
     * clear native database(/data/data/com.xxx.xxx/databases)
     */
    public static void clearDatabase(Context context) {
        deleteFilesByDirectory(new File("/data/data/" + context.getPackageName() + "/databases"));
    }

    /**
     * clear app SharedPreference(/data/data/com.xxx.xxx/shared_prefs)
     */
    public static void clearSharedPreference(Context context) {
        deleteFilesByDirectory(new File("/data/data/" + context.getPackageName() + "/shared_prefs"));
    }

    /**
     * clear app database by name
     */
    public static void clearDbByName(Context context, String name) {
        context.deleteDatabase(name);
    }

    /**
     * clear files(/data/data/com.xxx.xxx/files)
     */
    public static void clearFiles(Context context) {
        deleteFilesByDirectory(context.getFilesDir());
    }

    /**
     * clear outter cache data(/mnt/sdcard/android/data/com.xxx.xxx/cache)
     */
    public static void clearOutterData(Context context) {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            deleteFilesByDirectory(context.getExternalCacheDir());
        }
    }

    /**
     * clear custom dir data
     */
    public static void clearMyDirData(String dirname) {
        deleteFilesByDirectory(new File(dirname));
    }

    /**
     * clear app all data
     */

    public static void clearAppAllData(Context context, String... filePath) {
        clearAppInnerCache(context);
        clearDatabase(context);
        clearSharedPreference(context);
        clearFiles(context);
        clearOutterData(context);
        for (String myFilePat : filePath)
            clearMyDirData(myFilePat);
    }

    /**
     * delete files by directory
     *
     * @param cacheDir
     */
    private static void deleteFilesByDirectory(File cacheDir) {
        if (cacheDir != null && cacheDir.exists() && cacheDir.isDirectory()) {
            for (File item : cacheDir.listFiles()) {
                item.delete();
            }
        }
    }

}
