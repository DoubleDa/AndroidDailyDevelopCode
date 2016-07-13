package com.dyx.diwdp.component;

import android.content.SharedPreferences;

import com.dyx.diwdp.module.AppModule;
import com.dyx.diwdp.module.NetModule;
import com.squareup.okhttp.OkHttpClient;

import javax.inject.Singleton;

import dagger.Component;
import retrofit.Retrofit;

/**
 * project name：DependencyInjectionWithDagger2Project
 * class describe：
 * create person：dayongxin
 * create time：16/7/13 下午5:24
 * alter person：dayongxin
 * alter time：16/7/13 下午5:24
 * alter remark：
 */
@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    Retrofit retrofit();

    OkHttpClient okHttpClient();

    SharedPreferences sharedPreferences();
}
