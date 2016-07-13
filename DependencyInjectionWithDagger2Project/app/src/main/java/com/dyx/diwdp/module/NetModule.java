package com.dyx.diwdp.module;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * project name：DependencyInjectionWithDagger2Project
 * class describe：
 * create person：dayongxin
 * create time：16/7/13 下午4:47
 * alter person：dayongxin
 * alter time：16/7/13 下午4:47
 * alter remark：
 */
@Module
public class NetModule {
    /**
     * 主机地址
     */
    String mBaseUrl;

    /**
     * 构造方法
     *
     * @param mBaseUrl
     */
    public NetModule(String mBaseUrl) {
        this.mBaseUrl = mBaseUrl;
    }

    /**
     * 获取SharedPreferences对象
     *
     * @param application
     * @return
     */
    @Provides
    @Singleton
    SharedPreferences providesSharedPreferences(Application application) {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

    /**
     * 获取Cache对象
     *
     * @param application
     * @return
     */
    @Provides
    @Singleton
    Cache provideOkHttpCache(Application application) {
        int cacheSize = 10 * 1024 * 1024;
        Cache cache = new Cache(application.getCacheDir(), cacheSize);
        return cache;
    }

    /**
     * 获取GSON对象
     *
     * @return
     */
    @Provides
    @Singleton
    Gson provideGson() {
        GsonBuilder builder = new GsonBuilder();
        builder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return builder.create();
    }

    /**
     * 获取OkHttpClient对象
     *
     * @param cache
     * @return
     */
    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(Cache cache) {
        OkHttpClient client = new OkHttpClient();
        client.setCache(cache);
        return client;
    }

    /**
     * 获取Retrofit对象
     *
     * @param gson
     * @param client
     * @return
     */
    @Provides
    @Singleton
    Retrofit provideRetrofit(Gson gson, OkHttpClient client) {
        Retrofit retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create(gson)).baseUrl(mBaseUrl).client(client).build();
        return retrofit;
    }
}
