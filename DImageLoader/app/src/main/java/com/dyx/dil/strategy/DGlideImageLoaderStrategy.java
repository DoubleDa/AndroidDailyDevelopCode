package com.dyx.dil.strategy;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.dyx.dil.base.DBaseImageLoaderStrategy;
import com.dyx.dil.listener.DProgressLoadListener;
import com.dyx.dil.progress.glide.DProgressModelLoader;
import com.dyx.dil.progress.glide.DProgressUIListener;
import com.dyx.dil.utils.FileUtils;

/**
 * project name：DImageLoader
 * class describe：
 * create person：dayongxin
 * create time：2016/12/30 下午1:29
 * alter person：dayongxin
 * alter time：2016/12/30 下午1:29
 * alter remark：
 */
public class DGlideImageLoaderStrategy implements DBaseImageLoaderStrategy {
    @Override
    public void loadImage(String imgUrl, ImageView imageView) {
        Glide.with(imageView.getContext()).load(imgUrl).dontAnimate().placeholder(imageView.getDrawable()).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
    }

    @Override
    public void loadImage(String imgUrl, int placeHolder, ImageView imageView) {
        loadNormal(imageView.getContext(), imgUrl, placeHolder, imageView);
    }

    @Override
    public void loadImage(Context context, String imgUrl, ImageView imageView) {
        Glide.with(context).load(imgUrl).dontAnimate().placeholder(imageView.getDrawable()).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
    }

    @Override
    public void loadImage(Context context, String imgUrl, int placeHolder, ImageView imageView) {
        loadNormal(context, imgUrl, placeHolder, imageView);
    }

    /**
     * TODO 待开发
     *
     * @param imgUrl
     * @param imageView
     */
    @Override
    public void loadBigImage(String imgUrl, ImageView imageView) {

    }

    /**
     * TODO 待开发
     *
     * @param imgUrl
     * @param placeHolder
     * @param imageView
     */
    @Override
    public void loadBigImage(String imgUrl, int placeHolder, ImageView imageView) {

    }

    @Override
    public void loadImageWithProgress(String imgUrl, ImageView imageView, final DProgressLoadListener listener) {
        loadNormalProgress(imageView.getContext(), imgUrl, imageView, listener);
    }

    private void loadNormalProgress(Context context, String imgUrl, ImageView imageView, final DProgressLoadListener listener) {
        Glide.with(context).using(new DProgressModelLoader(new DProgressUIListener() {
            @Override
            public void update(int readLength, int totalLength) {
                listener.update(readLength, totalLength);
            }
        })).load(imgUrl).asBitmap().dontAnimate().placeholder(imageView.getDrawable()).listener(new RequestListener<String, Bitmap>() {
            @Override
            public boolean onException(Exception e, String model, Target<Bitmap> target, boolean isFirstResource) {
                listener.onException();
                return false;
            }

            @Override
            public boolean onResourceReady(Bitmap resource, String model, Target<Bitmap> target, boolean isFromMemoryCache, boolean isFirstResource) {
                listener.onResourceReady();
                return false;
            }
        }).into(imageView);
    }

    @Override
    public void loadImageWithProgress(String imgUrl, int placeHolder, ImageView imageView, final DProgressLoadListener listener) {
        loadNormalProgress(imageView.getContext(), imgUrl, placeHolder, imageView, listener);
    }

    private void loadNormalProgress(Context context, String imgUrl, int placeHolder, ImageView imageView, final DProgressLoadListener listener) {
        Glide.with(context).using(new DProgressModelLoader(new DProgressUIListener() {
            @Override
            public void update(int readLength, int totalLength) {
                listener.update(readLength, totalLength);
            }
        })).load(imgUrl).asBitmap().dontAnimate().placeholder(placeHolder).listener(new RequestListener<String, Bitmap>() {
            @Override
            public boolean onException(Exception e, String model, Target<Bitmap> target, boolean isFirstResource) {
                listener.onException();
                return false;
            }

            @Override
            public boolean onResourceReady(Bitmap resource, String model, Target<Bitmap> target, boolean isFromMemoryCache, boolean isFirstResource) {
                listener.onResourceReady();
                return false;
            }
        }).into(imageView);
    }

    @Override
    public void loadImageWithProgress(Context context, String imgUrl, ImageView imageView, DProgressLoadListener listener) {
        loadNormalProgress(context, imgUrl, imageView, listener);
    }

    @Override
    public void loadImageWithProgress(Context context, String imgUrl, int placeHolder, ImageView imageView, DProgressLoadListener listener) {
        loadNormalProgress(context, imgUrl, placeHolder, imageView, listener);
    }

    /**
     * TODO 待开发
     *
     * @param imgUrl
     * @param imageView
     * @param listener
     */
    @Override
    public void loadBigImageWithProgress(String imgUrl, ImageView imageView, DProgressLoadListener listener) {

    }

    /**
     * TODO 待开发
     *
     * @param imgUrl
     * @param placeHolder
     * @param imageView
     * @param listener
     */
    @Override
    public void loadBigImageWithProgress(String imgUrl, int placeHolder, ImageView imageView, DProgressLoadListener listener) {

    }

    /**
     * 子线程直接清除数据|主线程开启子线程进行数据清除
     *
     * @param context
     */
    @Override
    public void clearDiskImageCache(final Context context) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //主线程开启子线程进行数据清除
                    Glide.get(context.getApplicationContext()).clearDiskCache();
                }
            }).start();
        } else {
            //子线程直接清除数据
            Glide.get(context.getApplicationContext()).clearDiskCache();
        }
    }

    /**
     * 在主线程清除内存缓存
     *
     * @param context
     */
    @Override
    public void clearMemoryImageCache(final Context context) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Glide.get(context.getApplicationContext()).clearMemory();
                }
            }).start();
        }
    }

    @Override
    public void trimMemory(Context context, int level) {
        Glide.get(context.getApplicationContext()).trimMemory(level);
    }

    @Override
    public String getCacheSize(Context context) {
        return FileUtils.getFormatSize(FileUtils.getFolderSize(Glide.getPhotoCacheDir(context.getApplicationContext())));
    }

    /**
     * @param context
     * @param imgUrl
     * @param placeHolder
     * @param imageView
     */
    private void loadNormal(Context context, String imgUrl, int placeHolder, ImageView imageView) {
        Glide.with(context).load(imgUrl).dontAnimate().placeholder(placeHolder).diskCacheStrategy(DiskCacheStrategy.SOURCE).listener(new RequestListener<String, GlideDrawable>() {
            @Override
            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                return false;
            }

            @Override
            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                return false;
            }
        }).into(imageView);
    }
}
