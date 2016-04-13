package com.dyx.sbcd.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;

import com.dyx.sbcd.R;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-04-13
 * Time      : 14:22
 * Summary   :
 * Copyright : Copyright (c) 2016
 */
public class Method1Act extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Method1:为Window设置setSoftInputMode
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        setContentView(R.layout.act_method1_layout);
    }
}