package com.dyx.lcd;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * project name：LeakCanaryDemo
 * class describe：
 * create person：dayongxin
 * create time：2016/11/1 上午10:30
 * alter person：dayongxin
 * alter time：2016/11/1 上午10:30
 * alter remark：
 */
public class XApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }
}
