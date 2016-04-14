package com.dyx.cdbf.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-04-14
 * Time      : 14:56
 * Summary   :
 * Copyright : Copyright (c) 2016
 */
public class NetworkUtils {
    /**
     * @param context
     * @return 网络是否连接
     */
    public static boolean isNetworkConnected(Context context) {
        if (context != null) {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo ni = cm.getActiveNetworkInfo();
            if (ni != null) {
                return ni.isAvailable();
            }
        }
        return false;
    }

    /**
     * @param context
     * @return 处理wifi连接状态
     */
    public static boolean isWifiConnected(Context context) {
        if (context != null) {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo ni = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            if (ni != null) {
                return ni.isAvailable();
            }
        }
        return false;
    }

    /**
     * @param context
     * @return 处理移动网络
     */
    public static boolean isMobileConnected(Context context) {
        if (context != null) {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo ni = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
            if (ni != null) {
                return ni.isAvailable();
            }
        }
        return false;
    }
}