package com.dyx.op.base;

import android.app.Application;

import com.apkfuns.logutils.LogUtils;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-04-27
 * Time      : 15:59
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