package com.dyx.dil.progress.glide;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.BufferedSource;

/**
 * project name：DImageLoader
 * class describe：
 * create person：dayongxin
 * create time：2016/12/30 下午7:53
 * alter person：dayongxin
 * alter time：2016/12/30 下午7:53
 * alter remark：
 */
public class DProgressResponseBody extends ResponseBody {
    private ResponseBody responseBody;
    private DProgressListener listener;

    public DProgressResponseBody(ResponseBody responseBody, DProgressListener listener) {
        this.responseBody = responseBody;
        this.listener = listener;
    }

    @Override
    public MediaType contentType() {
        return null;
    }

    @Override
    public long contentLength() {
        return 0;
    }

    @Override
    public BufferedSource source() {
        return null;
    }
}
