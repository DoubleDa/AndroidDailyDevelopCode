package com.dyx.al.base;

import android.os.Bundle;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-04-18
 * Time      : 11:12
 * Summary   :
 * Copyright : Copyright (c) 2016
 */
public abstract class BaseActivity extends com.cocosw.lifecycle.app.Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initVariate();
        initData();
    }

    protected abstract void initView();

    protected abstract void initVariate();

    protected abstract void initData();
}