package com.dyx.ncd.net;

import com.dyx.ncd.model.ClassifyModel;

import retrofit2.http.GET;

/**
 * project name：NewsCacheDemo
 * class describe：
 * create person：dayongxin
 * create time：2016/11/1 下午3:25
 * alter person：dayongxin
 * alter time：2016/11/1 下午3:25
 * alter remark：
 */
public interface ApiService {
    /**
     * 获取分类：http://www.tngou.net/api/info/classify
     */
    @GET("classify")
    ClassifyModel getClassify();
    /**
     * 获取列表信息：http://www.tngou.net/api/info/list?page=1&rows=100&id=5
     */

    /**
     * 新闻详情：http://www.tngou.net/api/info/show?id=6810
     */

}
