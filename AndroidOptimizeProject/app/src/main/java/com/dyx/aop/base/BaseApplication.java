package com.dyx.aop.base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.apkfuns.logutils.LogUtils;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-04-11
 * Time      : 11:25
 * Summary   : Application基类
 * Copyright : Copyright (c) 2016
 */
public class BaseApplication extends Application {
    //全局Context
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        init();
        mContext = getApplicationContext();
        //为Activity注册ActivityLifecycleCallbacks
        this.registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                LogUtils.i("***onActivityCreated***", activity);
            }

            @Override
            public void onActivityStarted(Activity activity) {
                LogUtils.i("***onActivityStarted***", activity);
            }

            @Override
            public void onActivityResumed(Activity activity) {
                LogUtils.i("***onActivityResumed***", activity);
            }

            @Override
            public void onActivityPaused(Activity activity) {
                LogUtils.i("***onActivityPaused***", activity);
            }

            @Override
            public void onActivityStopped(Activity activity) {
                LogUtils.i("***onActivityStopped***", activity);
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
                LogUtils.i("***onActivitySaveInstanceState***", activity);
            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                LogUtils.i("***onActivityDestroyed***", activity);
            }
        });
        //为Activity注销ActivityLifecycleCallbacks
        this.unregisterActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                LogUtils.i("***onActivityCreated***", activity);
            }

            @Override
            public void onActivityStarted(Activity activity) {
                LogUtils.i("***onActivityStarted***", activity);
            }

            @Override
            public void onActivityResumed(Activity activity) {
                LogUtils.i("***onActivityResumed***", activity);
            }

            @Override
            public void onActivityPaused(Activity activity) {
                LogUtils.i("***onActivityPaused***", activity);
            }

            @Override
            public void onActivityStopped(Activity activity) {
                LogUtils.i("***onActivityStopped***", activity);
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
                LogUtils.i("***onActivitySaveInstanceState***", activity);
            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                LogUtils.i("***onActivityDestroyed***", activity);
            }
        });
    }

    private void init() {
        LogUtils.configTagPrefix = "***dayongxin***";
        LogUtils.configAllowLog = true;
    }
    public static Context getContext() {
        return mContext;
    }
}