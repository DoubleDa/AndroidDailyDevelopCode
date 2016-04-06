package com.dyx.mp.base;

import android.app.Application;

/**
 * Created by Da on 2016/4/5.
 */
public class BaseApplication extends Application {
    private static BaseApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static synchronized BaseApplication getInstance() {
        return instance;
    }
}
