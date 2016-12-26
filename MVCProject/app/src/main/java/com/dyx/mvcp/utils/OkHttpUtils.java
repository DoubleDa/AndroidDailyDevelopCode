package com.dyx.mvcp.utils;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * project name：MVCProject
 * class describe：
 * create person：dayongxin
 * create time：2016/12/21 下午5:46
 * alter person：dayongxin
 * alter time：2016/12/21 下午5:46
 * alter remark：
 */
public class OkHttpUtils {

    OkHttpClient okHttpClient = new OkHttpClient();

    public void getData(String url) {
        Request request = new Request.Builder().url(url).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });
    }
}
