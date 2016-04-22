package com.dyx.abp.ui;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

import com.dyx.abp.R;
import com.dyx.abp.base.BaseActivity;
import com.dyx.abp.config.picasso.CropSquareTransformation;

import java.io.File;

import butterknife.Bind;
import butterknife.ButterKnife;
import it.sephiroth.android.library.picasso.Picasso;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-04-22
 * Time      : 15:35
 * Summary   :
 * Copyright : Copyright (c) 2016
 */
public class PicassoAct extends BaseActivity {
    private String imgUrl = "http://square.github.io/picasso/static/sample.png";
    @Bind(R.id.iv_show)
    ImageView ivShow;

    @Override
    protected void initView() {
        setContentView(R.layout.act_picasso_layout);
    }

    @Override
    protected void initParam() {

    }

    @Override
    protected void initData() {
        //简单使用
        Picasso.with(this).load(imgUrl).into(ivShow);

        //更好的适配ImageView
        Picasso.with(this).load(imgUrl).resize(50, 50).centerCrop().into(ivShow);

        //使用自定义配置
        Picasso.with(this).load(imgUrl).transform(new CropSquareTransformation()).into(ivShow);

        //设置错误图片
        Picasso.with(this).load(imgUrl).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(ivShow);

        //加载Resources
        Picasso.with(this).load(R.mipmap.ic_launcher).into(ivShow);

        //加载assets
        Picasso.with(this).load("file:///android_assets/test_img.png").into(ivShow);

        //加载file
        Picasso.with(this).load(new File("")).into(ivShow);

        //加载Uri
        Picasso.with(this).load(String.valueOf(new Uri.Builder())).into(ivShow);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}