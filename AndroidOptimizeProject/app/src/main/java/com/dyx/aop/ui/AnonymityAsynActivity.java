package com.dyx.aop.ui;

import android.app.Activity;
import android.os.Bundle;

import com.dyx.aop.R;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-04-11
 * Time      : 11:57
 * Summary   : 匿名内部类+异步线程
 * Copyright : Copyright (c) 2016
 */
public class AnonymityAsynActivity extends Activity {

    private MyRunnable run1 = new MyRunnable();
    private Runnable run2 = new Runnable() {
        @Override
        public void run() {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public class MyRunnable implements Runnable {

        @Override
        public void run() {

        }
    }
}