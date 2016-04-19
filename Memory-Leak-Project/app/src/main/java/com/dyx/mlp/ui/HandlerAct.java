package com.dyx.mlp.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;

import com.apkfuns.logutils.LogUtils;
import com.dyx.mlp.R;

import java.lang.ref.WeakReference;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-04-19
 * Time      : 13:42
 * Summary   :
 * Copyright : Copyright (c) 2016
 */
public class HandlerAct extends Activity {
    public static final int ONE_HOUR = 60 * 60 * 60 * 1000;
    public static final int MSG_ZERO = 0;
    public static final int MSG_ONE = 1;
    public static final int MSG_TWO = 2;
    public static final int MSG_THREE = 3;
    public static String TEST_STR = "testString";
    @Bind(R.id.but_test)
    Button butTest;
    //普通内部类
    private InnerHandler mInnerHandler;
    //静态内部类
    private InnerStaticHandler mInnerStaticHandler;
    //静态弱应用内部类
    private InnerStaticWeakHandler mInnerStaticWeakHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        ButterKnife.bind(this);
        leakInnerHandler();
        //leakInnerStaticHandler();
        //leakInnerStaticParamHandler();
        //leakInnerWeakStaticHandler();
    }

    private void leakInnerWeakStaticHandler() {
        Message msg = new Message();
        msg.what = MSG_THREE;
        msg.obj = "leakInnerWeakStaticHandler";
        mInnerStaticWeakHandler = new InnerStaticWeakHandler(butTest);
        mInnerStaticWeakHandler.sendMessageDelayed(msg, ONE_HOUR);
    }

    private void leakInnerStaticParamHandler() {
        Message msg = new Message();
        msg.what = MSG_TWO;
        msg.obj = "leakInnerStaticParamHandler";
        mInnerStaticHandler = new InnerStaticHandler(butTest);
        mInnerStaticHandler.sendMessageDelayed(msg, ONE_HOUR);
    }

    private void leakInnerStaticHandler() {
        Message msg = new Message();
        msg.what = MSG_ONE;
        msg.obj = "InnerStaticHandler";
        mInnerStaticHandler = new InnerStaticHandler();
        mInnerStaticHandler.sendMessageDelayed(msg, ONE_HOUR);
    }

    private void leakInnerHandler() {
        Message msg = new Message();
        msg.what = MSG_ZERO;
        msg.obj = "leakInnerHandler";
        mInnerHandler = new InnerHandler();
        mInnerHandler.sendMessageDelayed(msg, ONE_HOUR);
    }

    @OnClick(R.id.but_test)
    public void onClick() {
    }

    private class InnerHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            LogUtils.i(msg.toString());
        }
    }

    private static class InnerStaticHandler extends Handler {
        private View view;
        private String testStr;

        public InnerStaticHandler() {
        }

        public InnerStaticHandler(View view) {
            this.view = view;
        }

        public InnerStaticHandler(String str) {
            this.testStr = str;
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            LogUtils.i(msg.toString());
        }
    }

    private static class InnerStaticWeakHandler extends Handler {
        private WeakReference<View> views;

        public InnerStaticWeakHandler(View view) {
            views = new WeakReference<View>(view);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            LogUtils.i(msg.toString());
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        mInnerHandler.removeMessages(MSG_ZERO);
        mInnerStaticHandler.removeMessages(MSG_ONE);
        mInnerStaticWeakHandler.removeMessages(MSG_THREE);
    }
}