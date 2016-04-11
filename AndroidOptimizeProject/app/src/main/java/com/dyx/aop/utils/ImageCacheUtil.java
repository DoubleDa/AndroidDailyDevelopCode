package com.dyx.aop.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-04-11
 * Time      : 14:14
 * Summary   : 图片缓存
 * Copyright : Copyright (c) 2016
 */
public class ImageCacheUtil {
    //保存软引用对象
    private Map<String, SoftReference<Bitmap>> imgMap = new HashMap<String, SoftReference<Bitmap>>();

    /**
     * 保存Bitmap到Map
     */
    public void putBitmapToCache(String path) {
        //强引用的Bitmap
        Bitmap bitmap = BitmapFactory.decodeFile(path);
        //软引用的Bitmap
        SoftReference<Bitmap> softBitmap = new SoftReference<Bitmap>(bitmap);
        //添加软引用对象到缓存
        imgMap.put(path, softBitmap);
    }

    /**
     * 从Map获取Bitmap
     */
    public Bitmap getBitmapFromCache(String path) {
        SoftReference<Bitmap> bit = imgMap.get(path);
        if (bit == null) {
            return null;
        }
        Bitmap bitmap = bit.get();
        return bitmap;
    }
}  