package com.dyx.abp.ui;

import android.os.Bundle;
import android.widget.Button;

import com.apkfuns.logutils.LogUtils;
import com.dyx.abp.R;
import com.dyx.abp.base.BaseActivity;
import com.dyx.abp.constants.ApiConstant;
import com.dyx.abp.http.OkHttpHelper;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-04-19
 * Time      : 17:50
 * Summary   :
 * Copyright : Copyright (c) 2016
 */
public class OkhttpAct extends BaseActivity {
    @Bind(R.id.but_ok_http)
    Button butOkHttp;

    @Override
    protected void initView() {
        setContentView(R.layout.act_ok_http_layout);
    }

    @Override
    protected void initParam() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.but_ok_http)
    public void onClick() {
        OkHttpHelper helper = new OkHttpHelper();
        try {
            //同步方式
            String result = helper.getSync(ApiConstant.URL_GET_TOPICS);
            LogUtils.i(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}