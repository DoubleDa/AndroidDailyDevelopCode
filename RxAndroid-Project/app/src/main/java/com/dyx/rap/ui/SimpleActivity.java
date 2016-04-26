package com.dyx.rap.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.dyx.rap.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-04-26
 * Time      : 14:06
 * Summary   : 1、观察事件发生；2、注册观察者；3、订阅者；4、发布订阅消息
 * Copyright : Copyright (c) 2016
 */
public class SimpleActivity extends Activity {

    @Bind(R.id.tv_show_tip)
    TextView tvShowTip;
    //1、观察事件发生
    private Observable.OnSubscribe mObservableAction = new Observable.OnSubscribe<String>() {

        @Override
        public void call(Subscriber<? super String> subscriber) {
            //发生事件
            subscriber.onNext(showTip());
            //完成事件
            subscriber.onCompleted();
        }
    };

    private String showTip() {
        return "Success!";
    }

    //3、订阅者，修改控件
    private Subscriber<String> mTvSub = new Subscriber<String>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onNext(String s) {
            tvShowTip.setText(s);
        }
    };

    //3、订阅者，显示tip信息
    private Subscriber<String> mToastSub = new Subscriber<String>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onNext(String s) {
            Toast.makeText(SimpleActivity.this, s, Toast.LENGTH_SHORT).show();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_simple_layout);
        ButterKnife.bind(this);
        //2、注册观察者
        Observable<String> observable = Observable.create(mObservableAction);

        /**
         * 4、发布订阅消息
         */
        //在主线程
        observable.observeOn(AndroidSchedulers.mainThread());
        //发布消息
        observable.subscribe(mTvSub);
        observable.subscribe(mToastSub);
    }
}