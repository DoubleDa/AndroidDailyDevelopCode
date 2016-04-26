package com.dyx.vp.base;

import android.app.Application;

import com.apkfuns.logutils.LogUtils;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-04-26
 * Time      : 11:20
 * Summary   :
 * Copyright : Copyright (c) 2016
 */
public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LogUtils.configTagPrefix = "***dayongxin***";
        LogUtils.configAllowLog = true;
    }
}