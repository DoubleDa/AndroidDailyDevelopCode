package com.dyx.dil.base;

import android.content.Context;
import android.widget.ImageView;

import com.dyx.dil.listener.DProgressLoadListener;

/**
 * project name：DImageLoader
 * class describe：
 * create person：dayongxin
 * create time：2016/12/30 上午11:45
 * alter person：dayongxin
 * alter time：2016/12/30 上午11:45
 * alter remark：
 */
public interface DBaseImageLoaderStrategy {
    /**
     * 无占位图
     */
    void loadImage(String imgUrl, ImageView imageView);

    /**
     * 有占位图
     */
    void loadImage(String imgUrl, int placeHolder, ImageView imageView);

    /**
     * 无占位图（含有上下文）
     */
    void loadImage(Context context, String imgUrl, ImageView imageView);

    /**
     * 有占位图（含有上下文）
     */
    void loadImage(Context context, String imgUrl, int placeHolder, ImageView imageView);

    /**
     * 无占位图（加载大图）
     */
    void loadBigImage(String imgUrl, ImageView imageView);

    /**
     * 有占位图（加载大图）
     */
    void loadBigImage(String imgUrl, int placeHolder, ImageView imageView);

    /**
     * 无占位图（添加进度条）
     */
    void loadImageWithProgress(String imgUrl, ImageView imageView, DProgressLoadListener listener);

    /**
     * 有占位图（添加进度条）
     */
    void loadImageWithProgress(String imgUrl, int placeHolder, ImageView imageView, DProgressLoadListener listener);

    /**
     * 无占位图（含有上下文、添加进度条）
     */
    void loadImageWithProgress(Context context, String imgUrl, ImageView imageView, DProgressLoadListener listener);

    /**
     * 有占位图（含有上下文、添加进度条）
     */
    void loadImageWithProgress(Context context, String imgUrl, int placeHolder, ImageView imageView, DProgressLoadListener listener);

    /**
     * 无占位图（加载大图、添加进度条）
     */
    void loadBigImageWithProgress(String imgUrl, ImageView imageView, DProgressLoadListener listener);

    /**
     * 有占位图（加载大图、添加进度条）
     */
    void loadBigImageWithProgress(String imgUrl, int placeHolder, ImageView imageView, DProgressLoadListener listener);

    /**
     * 清除磁盘缓存
     */
    void clearDiskImageCache(Context context);

    /**
     * 清除内存缓存
     */
    void clearMemoryImageCache(Context context);

    /**
     * 根据不同的内存状态，来响应不同的内存释放策略
     */
    void trimMemory(Context context, int level);

    /**
     * 获取缓存大小
     */
    String getCacheSize(Context context);
}
