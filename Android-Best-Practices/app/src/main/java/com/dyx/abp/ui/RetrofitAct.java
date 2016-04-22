package com.dyx.abp.ui;

import com.apkfuns.logutils.LogUtils;
import com.dyx.abp.R;
import com.dyx.abp.base.BaseActivity;
import com.dyx.abp.constants.ApiConstant;
import com.dyx.abp.entity.TopicsEntity;
import com.dyx.abp.service.TopicsService;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-04-22
 * Time      : 15:04
 * Summary   :
 * Copyright : Copyright (c) 2016
 */
public class RetrofitAct extends BaseActivity {
    @Override
    protected void initView() {
        setContentView(R.layout.act_retrofit_layout);
    }

    @Override
    protected void initParam() {

    }

    @Override
    protected void initData() {
        //1、创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder().baseUrl(ApiConstant.URL_GET_TOPICS).addConverterFactory(GsonConverterFactory.create()).build();

        //2、创建访问API的请求
        TopicsService service = retrofit.create(TopicsService.class);
        Call<TopicsEntity> call = service.getResult();

        //3、发送请求
        call.enqueue(new Callback<TopicsEntity>() {
            @Override
            public void onResponse(Response<TopicsEntity> response, Retrofit retrofit) {
                if (response.isSuccess()) {
                    TopicsEntity topicsEntity = response.body();
                    if (topicsEntity != null) {
                        //4、处理结果
                        LogUtils.i(topicsEntity.getData());
                    }
                }
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }
}