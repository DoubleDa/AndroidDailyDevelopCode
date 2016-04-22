package com.dyx.abp.service;

import com.dyx.abp.entity.TopicsEntity;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-04-22
 * Time      : 15:23
 * Summary   :
 * Copyright : Copyright (c) 2016
 */
public interface TopicsService {
    @GET("")
    Call<TopicsEntity> getResult();
}  