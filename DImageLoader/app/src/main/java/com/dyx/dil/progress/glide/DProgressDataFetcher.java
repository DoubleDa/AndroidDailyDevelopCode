package com.dyx.dil.progress.glide;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.data.DataFetcher;

import java.io.IOException;
import java.io.InputStream;

import okhttp3.Call;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * project name：DImageLoader
 * class describe：
 * create person：dayongxin
 * create time：2016/12/30 下午7:33
 * alter person：dayongxin
 * alter time：2016/12/30 下午7:33
 * alter remark：
 */
public class DProgressDataFetcher implements DataFetcher<InputStream> {
    /**
     * 图片加载地址
     */
    private String imgUrl;
    /**
     * 输入流
     */
    private InputStream inputStream;
    /**
     * 是否取消
     */
    private volatile boolean isCancelled;
    /**
     * 图片加载进度监听器
     */
    private DProgressUIListener listener;
    /**
     * 访问进度
     */
    private Call progressCall;

    /**
     * 构造方法
     *
     * @param imgUrl
     * @param listener
     */
    public DProgressDataFetcher(String imgUrl, DProgressUIListener listener) {
        this.imgUrl = imgUrl;
        this.listener = listener;
    }

    @Override
    public InputStream loadData(Priority priority) throws Exception {
        //创建Request请求
        final Request request = new Request.Builder().url(imgUrl).build();
        //进度监听器
        final DProgressListener progressListener = new DProgressListener() {
            @Override
            public void update(long readLength, long totalLength, boolean done) {
                if (listener != null) {
                    listener.update((int) readLength, (int) totalLength);
                }
            }
        };
        //创建OkHttpClient对象
        OkHttpClient client = new OkHttpClient.Builder().addNetworkInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                //构建Response对象
                Response response = chain.proceed(chain.request());
                return response.newBuilder().body(new DProgressResponseBody(response.body(), progressListener)).build();
            }
        }).build();
        //获取Call对象
        progressCall = client.newCall(request);
        //获取Response对象
        Response response = progressCall.execute();
        if (isCancelled) {
            return null;
        }
        if (!response.isSuccessful())
            throw new IOException("Unexcepted code:" + response);
        inputStream = response.body().byteStream();
        return inputStream;
    }

    @Override
    public void cleanup() {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (progressCall != null) {
            progressCall.cancel();
        }
    }

    @Override
    public String getId() {
        return imgUrl;
    }

    @Override
    public void cancel() {
        isCancelled = true;
    }
}
