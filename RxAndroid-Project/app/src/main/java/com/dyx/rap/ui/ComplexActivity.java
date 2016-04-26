package com.dyx.rap.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.dyx.rap.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Func2;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-04-26
 * Time      : 14:07
 * Summary   :
 * Copyright : Copyright (c) 2016
 */
public class ComplexActivity extends Activity {

    private String[] strArray = {"This", "is", "a", "test", "Program"};
    private List<String> lists = Arrays.asList(strArray);
    @Bind(R.id.tv_show_tip)
    TextView tvShowTip;

    //Action订阅者
    private Action1<String> tvAction = new Action1<String>() {
        @Override
        public void call(String s) {
            tvShowTip.setText(s);
        }
    };

    //Action订阅者
    private Action1<String> toastAction = new Action1<String>() {
        @Override
        public void call(String s) {
            Toast.makeText(ComplexActivity.this, s, Toast.LENGTH_SHORT).show();
        }
    };

    //设置大写
    private Func1<String, String> mUpperLetterFunc = new Func1<String, String>() {
        @Override
        public String call(String s) {
            return s.toUpperCase();
        }
    };

    //设置映射函数
    private Func1<List<String>, Observable<String>> mOneLetterFunc = new Func1<List<String>, Observable<String>>() {
        @Override
        public Observable<String> call(List<String> strings) {
            return Observable.from(strings);
        }
    };

    //连接字符串
    private Func2<String, String, String> mMergeStringFunc = new Func2<String, String, String>() {
        @Override
        public String call(String s, String s2) {
            return String.format("%s%s", s, s2);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_simple_layout);
        ButterKnife.bind(this);

        //添加字符串
        Observable<String> mObservable = Observable.just(showTip());

        //先映射，再分发
        mObservable.observeOn(AndroidSchedulers.mainThread()).map(mUpperLetterFunc).subscribe(tvAction);

        //单独显示数组中的每个元素
        Observable<String> simpleObservable = Observable.from(strArray);

        //映射之后分发
        simpleObservable.observeOn(AndroidSchedulers.mainThread()).map(mUpperLetterFunc).subscribe(toastAction);

        //优化
        Observable.just(lists).observeOn(AndroidSchedulers.mainThread()).flatMap(mOneLetterFunc).reduce(mMergeStringFunc).subscribe(tvAction);
    }

    private String showTip() {
        return "Success!";
    }
}