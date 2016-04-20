package com.dyx.abp.http;

import com.dyx.abp.constants.ApiConstant;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-04-20
 * Time      : 16:01
 * Summary   :
 * Copyright : Copyright (c) 2016
 */
public class OkHttpHelper {
    private OkHttpClient client = new OkHttpClient();

    /**
     * get synchronous
     *
     * @param url
     * @return
     * @throws IOException
     */
    public String getSync(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    //get asynchronous
    public void getAsyn() {
        Request request = new Request.Builder().url("").build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {

            }
        });
    }

    /**
     * post
     */
    public String postTest(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(ApiConstant.JSON, json);
        Request request = new Request.Builder().url(url).post(body).build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }
}  