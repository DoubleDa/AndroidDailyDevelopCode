package com.dyx.mlp.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

import com.dyx.mlp.R;
import com.dyx.mlp.utils.SingletonAnonInner;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-04-19
 * Time      : 14:43
 * Summary   :
 * Copyright : Copyright (c) 2016
 */
public class AnonInnerClassAct extends Activity implements SingletonAnonInner.SingletonListener {
    @Bind(R.id.but_test)
    Button butTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        ButterKnife.bind(this);
//        setListener();
        addListener();
//        removeListener();
    }

    /**
     * 移除监听
     */
    private void removeListener() {
        SingletonAnonInner.getInstance().removemSingletonListener(new SingletonAnonInner.SingletonListener() {
            @Override
            public void doTask() {

            }
        });
    }

    /**
     * 添加监听
     */
    private void addListener() {
        SingletonAnonInner.getInstance().addSingletonListener(new SingletonAnonInner.SingletonListener() {
            @Override
            public void doTask() {

            }
        });
    }

    /**
     * 设置监听
     */
    private void setListener() {
        SingletonAnonInner.getInstance().setSingletonListener(this);
    }

    /**
     * 释放内存
     */
    private void releaseMemory() {
        SingletonAnonInner.getInstance().release();
    }

    @Override
    public void doTask() {

    }

    @OnClick(R.id.but_test)
    public void onClick() {
        releaseMemory();
    }
}