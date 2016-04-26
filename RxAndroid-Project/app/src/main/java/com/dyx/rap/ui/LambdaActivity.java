package com.dyx.rap.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.dyx.rap.R;

import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-04-26
 * Time      : 14:08
 * Summary   :
 * Copyright : Copyright (c) 2016
 */
public class LambdaActivity extends Activity {

    @Bind(R.id.tv_show_tip)
    TextView tvShowTip;
    private String[] strArray = {"This", "is", "a", "test", "program"};
    private List<String> lists = Arrays.asList(strArray);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_simple_layout);
        ButterKnife.bind(this);

//        //添加字符串
//        Observable<String> mObservable = Observable.just(showTip());
//        //映射
//        mObservable.observeOn(AndroidSchedulers.mainThread()).map(String::toUpperCase).subscribe(tvShowTip::setText);
//        //添加链表
//        Observable<String> mList = Observable.from(lists);
//        //映射
//        mList.observeOn(AndroidSchedulers.mainThread()).map(String::toUpperCase).subscribe(this::showToast);
//
//
//        //优化
//        Observable.just(lists).observeOn(AndroidSchedulers.mainThread()).flatMap(Observable::from).reduce(this::mergeString).subscribe(this::showToast);
    }

    private String showTip() {
        return "Success!";
    }

    private void showToast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    private String mergeString(String s1, String s2) {
        return String.format("%s %s", s1, s2);
    }
}