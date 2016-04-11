package com.dyx.aop.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.dyx.aop.R;

import java.lang.ref.WeakReference;


/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-04-07
 * Time      : 17:06
 * Summary   : Android中Handler引起的内存泄露(http://droidyue.com/blog/2014/12/28/in-android-handler-classes-should-be-static-or-leaks-might-occur/)
 * Copyright : Copyright (c) 2016
 */
public class HandlerActivity extends Activity {
    private static class MyHandler extends Handler {
        private final WeakReference<HandlerActivity> activity;

        private MyHandler(HandlerActivity activity) {
            this.activity = new WeakReference<HandlerActivity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            HandlerActivity mActivity = activity.get();
            if (mActivity != null) {

            }
        }
    }

    private final MyHandler myHandler = new MyHandler(this);
    private final static Runnable mRunnable = new Runnable() {
        @Override
        public void run() {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_handler_layout);
        myHandler.postDelayed(mRunnable, 1000 * 60 * 10);
        finish();
    }

    @Override
    protected void onStop() {
        super.onStop();
        removeHandlerMsg();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        removeHandlerMsg();
    }

    /**
     * 创建一个静态Handler内部类，然后对 Handler 持有的对象使用弱引用，这样在回收时也可以回收 Handler
     * 持有的对象，但是这样做虽然避免了 Activity 泄漏，不过 Looper 线程的消息队列中还是可能会有待处理的消息，
     * 所以我们在 Activity 的 Destroy 时或者 Stop 时应该移除消息队列 MessageQueue 中的消息
     */
    private void removeHandlerMsg() {
        myHandler.removeCallbacks(mRunnable);
        //myHandler.removeCallbacks(r,token);
        //myHandler.removeCallbacksAndMessages(token);
        //myHandler.removeMessages(what);
        //myHandler.removeMessages(what,token);
    }
}