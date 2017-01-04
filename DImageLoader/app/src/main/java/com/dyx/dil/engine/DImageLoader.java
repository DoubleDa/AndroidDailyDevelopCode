package com.dyx.dil.engine;

import android.content.Context;
import android.widget.ImageView;

import com.dyx.dil.base.DBaseImageLoaderStrategy;
import com.dyx.dil.listener.DProgressLoadListener;
import com.dyx.dil.strategy.DGlideImageLoaderStrategy;

/**
 * project name：DImageLoader
 * class describe：
 * create person：dayongxin
 * create time：2016/12/30 上午11:39
 * alter person：dayongxin
 * alter time：2016/12/30 上午11:39
 * alter remark：
 */
public class DImageLoader {
    /**
     * 默认的图片加载类型
     */
    public static final int IMAGE_LOAD_DEFAULT_TYPE = 0;
    /**
     * 默认的图片加载策略
     */
    public static final int IMAGE_LOAD_DEFAULT_STRATEGY = 0;
    /**
     * 单例DImageLoader对象
     */
    private static DImageLoader mDImageLoader;
    /**
     * DBaseImageLoaderStrategy对象
     */
    private DBaseImageLoaderStrategy strategy;

    /**
     * 无參构造方法
     */
    public DImageLoader() {
        strategy = new DGlideImageLoaderStrategy();
    }

    /**
     * 获取DImageLoader实例
     *
     * @return
     */
    public static DImageLoader getInstance() {
        if (mDImageLoader == null) {
            synchronized (DImageLoader.class) {
                if (mDImageLoader == null) {
                    mDImageLoader = new DImageLoader();
                    return mDImageLoader;
                }
            }
        }
        return mDImageLoader;
    }

    /**
     * 加载不包含有占位图的图片
     *
     * @param imgUrl
     * @param imageView
     */
    public void displayImage(String imgUrl, ImageView imageView) {
        strategy.loadImage(imageView.getContext(), imgUrl, imageView);
    }

    /**
     * 加载包含有占位图的图片
     *
     * @param imgUrl
     * @param placeholder
     * @param imageView
     */
    public void displayImage(String imgUrl, int placeholder, ImageView imageView) {
        strategy.loadImage(imageView.getContext(), imgUrl, placeholder, imageView);
    }

    /**
     * 使用进度条加载不包含有占位图的图片
     *
     * @param imgUrl
     * @param imageView
     * @param listener
     */
    public void displayImageWithProgress(String imgUrl, ImageView imageView, DProgressLoadListener listener) {
        strategy.loadImageWithProgress(imageView.getContext(), imgUrl, imageView, listener);
    }

    /**
     * 使用进度条加载包含有占位图的图片
     *
     * @param imgUrl
     * @param placeholder
     * @param imageView
     * @param listener
     */
    public void displayImageWithProgress(String imgUrl, int placeholder, ImageView imageView, DProgressLoadListener listener) {
        strategy.loadImageWithProgress(imageView.getContext(), imgUrl, placeholder, imageView, listener);
    }

    /**
     * 设置策略模式注入
     *
     * @param mStrategy
     */
    public void setImageLoadStrategy(DBaseImageLoaderStrategy mStrategy) {
        strategy = mStrategy;
    }

    /**
     * 清除磁盘缓存
     *
     * @param context
     */
    public void clearDiskImageCache(Context context) {
        strategy.clearDiskImageCache(context);
    }

    /**
     * 清除内存缓存
     *
     * @param context
     */
    public void clearMemoryImageCache(Context context) {
        strategy.clearMemoryImageCache(context);
    }

    /**
     * 根据内存的使用情况，设置不同的缓存策略
     *
     * @param context
     * @param level
     */
    public void trimMemory(Context context, int level) {
        strategy.trimMemory(context, level);
    }

    /**
     * 清除所有缓存
     *
     * @param context
     */
    public void clearAllCache(Context context) {
        clearDiskImageCache(context.getApplicationContext());
        clearMemoryImageCache(context.getApplicationContext());
    }

    /**
     * 获取缓存大小
     *
     * @param context
     * @return
     */
    public String getCacheSize(Context context) {
        return strategy.getCacheSize(context);
    }
}
