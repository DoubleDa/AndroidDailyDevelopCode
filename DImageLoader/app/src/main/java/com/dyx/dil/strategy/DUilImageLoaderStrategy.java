package com.dyx.dil.strategy;

import android.content.Context;
import android.widget.ImageView;

import com.dyx.dil.base.DBaseImageLoaderStrategy;
import com.dyx.dil.listener.DProgressLoadListener;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * project name：DImageLoader
 * class describe：
 * create person：dayongxin
 * create time：2016/12/30 下午1:34
 * alter person：dayongxin
 * alter time：2016/12/30 下午1:34
 * alter remark：
 */
public class DUilImageLoaderStrategy implements DBaseImageLoaderStrategy {
    @Override
    public void loadImage(String imgUrl, ImageView imageView) {
        ImageLoader.getInstance().displayImage(imgUrl, imageView);
    }

    @Override
    public void loadImage(String imgUrl, int placeHolder, ImageView imageView) {

    }

    @Override
    public void loadImage(Context context, String imgUrl, ImageView imageView) {

    }

    @Override
    public void loadImage(Context context, String imgUrl, int placeHolder, ImageView imageView) {

    }

    @Override
    public void loadBigImage(String imgUrl, ImageView imageView) {

    }

    @Override
    public void loadBigImage(String imgUrl, int placeHolder, ImageView imageView) {

    }

    @Override
    public void loadImageWithProgress(String imgUrl, ImageView imageView, DProgressLoadListener listener) {

    }

    @Override
    public void loadImageWithProgress(String imgUrl, int placeHolder, ImageView imageView, DProgressLoadListener listener) {

    }

    @Override
    public void loadImageWithProgress(Context context, String imgUrl, ImageView imageView, DProgressLoadListener listener) {

    }

    @Override
    public void loadImageWithProgress(Context context, String imgUrl, int placeHolder, ImageView imageView, DProgressLoadListener listener) {

    }

    @Override
    public void loadBigImageWithProgress(String imgUrl, ImageView imageView, DProgressLoadListener listener) {

    }

    @Override
    public void loadBigImageWithProgress(String imgUrl, int placeHolder, ImageView imageView, DProgressLoadListener listener) {

    }

    @Override
    public void clearDiskImageCache(Context context) {

    }

    @Override
    public void clearMemoryImageCache(Context context) {

    }

    @Override
    public void trimMemory(Context context, int level) {

    }

    @Override
    public String getCacheSize(Context context) {
        return null;
    }
}
