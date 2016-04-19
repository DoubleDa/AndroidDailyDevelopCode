package com.dyx.abp.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import butterknife.ButterKnife;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-04-19
 * Time      : 16:52
 * Summary   :
 * Copyright : Copyright (c) 2016
 */
public abstract class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        initView();
        initParam();
        initData();
    }

    protected abstract void initView();

    protected abstract void initParam();

    protected abstract void initData();

    public void intentTo(Context context, Class<?> cla) {
        Intent i = new Intent(context, cla);
        startActivity(i);
    }

}