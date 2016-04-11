package com.dyx.aop.base;

import android.app.Application;
import android.content.Context;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-04-11
 * Time      : 11:25
 * Summary   : Application基类
 * Copyright : Copyright (c) 2016
 */
public class BaseApplication extends Application{
    //全局Context
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext=getApplicationContext();
    }
    public static Context getContext(){
        return mContext;
    }
}