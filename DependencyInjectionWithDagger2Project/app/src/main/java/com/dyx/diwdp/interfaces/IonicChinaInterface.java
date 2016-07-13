package com.dyx.diwdp.interfaces;

import com.dyx.diwdp.models.Article;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * project name：DependencyInjectionWithDagger2Project
 * class describe：
 * create person：dayongxin
 * create time：16/7/13 下午5:17
 * alter person：dayongxin
 * alter time：16/7/13 下午5:17
 * alter remark：
 */
public interface IonicChinaInterface {
    @GET("/api/v1/topic/{id}")
    Call<Article> getArticle(@Path("id") String articleId);
}
