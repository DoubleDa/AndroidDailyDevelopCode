package com.dyx.abp.constants;

import com.squareup.okhttp.MediaType;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-04-20
 * Time      : 15:57
 * Summary   :
 * Copyright : Copyright (c) 2016
 */
public class ApiConstant {
    /**
     * base url
     */
    public static final String URL_BASE = "https://cnodejs.org/api/";
    /**
     * api version
     */
    public static final String URL_VERSION = "v1";
    /**
     * media type
     */
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    /**
     * get /topics 主题首页
     */
    public static final String URL_GET_TOPICS = URL_BASE + URL_VERSION + "/topics";
}  