package com.dyx.bcd.base;

import android.app.Application;
import android.content.Context;

import com.dyx.bcd.context.AppBlockCanaryContext;
import com.github.moduth.blockcanary.BlockCanary;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-04-12
 * Time      : 11:03
 * Summary   :
 * Copyright : Copyright (c) 2016
 */
public class BaseApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        BlockCanary.install(mContext, new AppBlockCanaryContext()).start();
    }

    public static Context getAppContext() {
        return mContext;
    }
}