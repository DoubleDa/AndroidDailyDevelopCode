package com.dyx.jpt.base;

import android.app.Application;

import cn.jpush.android.api.JPushInterface;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-04-13
 * Time      : 16:48
 * Summary   :
 * Copyright : Copyright (c) 2016
 */
public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //开启调试模式，正式发布要关闭
        JPushInterface.setDebugMode(true);
        //初始化
        JPushInterface.init(this);
    }
}