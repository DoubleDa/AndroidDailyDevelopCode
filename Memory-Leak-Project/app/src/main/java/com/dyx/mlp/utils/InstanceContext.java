package com.dyx.mlp.utils;

import android.content.Context;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-04-19
 * Time      : 10:20
 * Summary   :
 * Copyright : Copyright (c) 2016
 */
public class InstanceContext {
    private static InstanceContext instance;
    private Context mContext;

    private InstanceContext(Context context) {
        this.mContext = context;
    }

    public static InstanceContext getInstance(Context context) {
        if (instance == null) {
            instance = new InstanceContext(context);
        }
        return instance;
    }
}  