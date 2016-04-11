package com.dyx.aop.utils;

import android.content.Context;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-04-11
 * Time      : 11:30
 * Summary   : 单例类（简单）
 * Copyright : Copyright (c) 2016
 */
public class SingletonUtil {
    private static SingletonUtil mSingletonUtil;
    private Context mContext;

    private SingletonUtil() {
        //不确定的Context
        this.mContext = mContext;
        //Application的Context
        //this.mContext=mContext.getApplicationContext();
        //直接使用Application的Context（推荐做法）
        //this.mContext= BaseApplication.getContext();
    }

    public static SingletonUtil getInstance(Context context) {
        if (mSingletonUtil == null) {
            mSingletonUtil = new SingletonUtil();
        }
        return mSingletonUtil;
    }
}