package com.dyx.lcd.other;

import android.content.Context;

/**
 * project name：LeakCanaryDemo
 * class describe：
 * create person：dayongxin
 * create time：2016/11/1 上午10:56
 * alter person：dayongxin
 * alter time：2016/11/1 上午10:56
 * alter remark：
 */
public class LoginManager {
    private static LoginManager instance;
    private Context mContext;

    private LoginManager(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static LoginManager getInstance(Context context) {
        if (instance == null) {
            synchronized (LoginManager.class) {
                if (instance == null) {
                    instance = new LoginManager(context);
                }
            }
        }
        return instance;
    }

    public String getResult() {
        return "Success!";
    }
}
