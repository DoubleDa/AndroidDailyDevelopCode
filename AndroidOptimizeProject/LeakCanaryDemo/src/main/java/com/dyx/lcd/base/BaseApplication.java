package com.dyx.lcd.base;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-04-11
 * Time      : 16:13
 * Summary   :
 * Copyright : Copyright (c) 2016
 */
public class BaseApplication extends Application {
    //引用leakcanary
    private RefWatcher mRefWatcher;

    @Override
    public void onCreate() {
        super.onCreate();
        //安装LeakCanary
        mRefWatcher = LeakCanary.install(this);
    }

    public static RefWatcher getRefWatcher(Context context) {
        BaseApplication application = (BaseApplication) context.getApplicationContext();
        return application.mRefWatcher;
    }
}