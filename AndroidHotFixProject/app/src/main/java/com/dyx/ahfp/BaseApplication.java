package com.dyx.ahfp;

import android.app.Application;
import android.content.Context;

import com.dyx.ahfp.utils.Utils;
import com.dyx.hl.HotFix;

import java.io.File;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-04-06
 * Time      : 16:30
 * Summary   : 自定义Application
 * Copyright : Copyright (c) 2016
 */
public class BaseApplication extends Application {
    public final static String HOT_FIX_FILE_NAME = "class_dex.jar";
    public final static String HOT_FIX_CLASS_NAME = "com.dyx.hc.AutoLazyLoad";

    @Override
    public void onCreate() {
        super.onCreate();
        //TODO 方式1：在App启动时自动进行bug修复（依赖）
        File dexPath = new File(getDir("dex", Context.MODE_PRIVATE), HOT_FIX_FILE_NAME);
        Utils.prepareDex(this, dexPath, HOT_FIX_FILE_NAME);
        HotFix.patch(this, dexPath.getAbsolutePath(), HOT_FIX_CLASS_NAME);

        try {
            this.getClassLoader().loadClass(HOT_FIX_CLASS_NAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}