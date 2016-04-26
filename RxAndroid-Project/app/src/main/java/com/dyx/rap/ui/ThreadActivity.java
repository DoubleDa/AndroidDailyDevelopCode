package com.dyx.rap.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.dyx.rap.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-04-26
 * Time      : 14:08
 * Summary   :
 * Copyright : Copyright (c) 2016
 */
public class ThreadActivity extends Activity {
    @Bind(R.id.tv_show_tip)
    TextView tvShowTip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_simple_layout);
        ButterKnife.bind(this);
    }
}