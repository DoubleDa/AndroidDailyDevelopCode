package com.dyx.mp.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;

import java.util.Stack;

/**
 * Created by Da on 2016/3/29.
 */
public class AppManager {
    private static Stack<Activity> activityStack;
    private static AppManager mAppManager;

    private AppManager() {
    }

    public static AppManager getAppManager() {
        if (mAppManager == null) {
            mAppManager = new AppManager();
        }
        return mAppManager;
    }

    public void addActivity(Activity activity) {
        if (activityStack == null) {
            activityStack = new Stack<Activity>();
        }
        activityStack.add(activity);
    }

    public boolean isContainActivity(Activity activity) {
        if (activityStack != null && activityStack.contains(activity)) {
            return true;
        }
        return false;
    }

    public Activity getCurrentActivity() {
        return activityStack.lastElement();
    }

    public void destoryCurrentActivity() {
        destoryActivity(activityStack.lastElement());
    }

    public void destoryActivity(Activity activity) {
        if (activityStack != null) {
            activityStack.remove(activity);
            activity.finish();
            activity = null;
        }
    }

    public void destoryClassActivity(Class<?> cla) {
        for (Activity activity : activityStack) {
            if (activity.getClass().equals(cla)) {
                destoryActivity(activity);
            }
        }
    }

    public void destoryAllActivity() {
        for (int i = 0; i < activityStack.size(); i++) {
            if (null != activityStack.get(i)) {
                activityStack.get(i).finish();
            }
        }
        activityStack.clear();
    }

    public void exitApp(Context context) {
        destoryAllActivity();
        ActivityManager mActivityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        mActivityManager.restartPackage(context.getPackageName());
        System.exit(0);
    }
}
