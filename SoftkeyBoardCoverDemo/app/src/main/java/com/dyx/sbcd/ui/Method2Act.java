package com.dyx.sbcd.ui;

import android.app.Activity;
import android.os.Bundle;

import com.dyx.sbcd.R;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-04-13
 * Time      : 15:07
 * Summary   :
 * Copyright : Copyright (c) 2016
 */
public class Method2Act extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_method1_layout);
        //Method2：在AndroidManifest.xml中添加adjustPan属性
    }
}