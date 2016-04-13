package com.dyx.sbcd.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.dyx.sbcd.R;
import com.dyx.sbcd.listener.KeyboardStateListener;
import com.dyx.sbcd.view.SoftKeyboardView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-04-13
 * Time      : 15:29
 * Summary   :
 * Copyright : Copyright (c) 2016
 */
public class Method4Act extends Activity implements KeyboardStateListener {
    @Bind(R.id.ll1)
    LinearLayout ll1;
    @Bind(R.id.root)
    SoftKeyboardView root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_method4_layout);
        ButterKnife.bind(this);
        root.setKeyboardStateListener((KeyboardStateListener) this);
    }

    @Override
    public void stateChange(int state) {
        switch (state) {
            case SoftKeyboardView.KEYBOARD_HIDE:
                ll1.setVisibility(View.VISIBLE);
                break;
            case SoftKeyboardView.KEYBOARD_SHOW:
                ll1.setVisibility(View.GONE);
                break;
        }
    }

}