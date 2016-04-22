package com.dyx.abp.config.picasso;

import android.graphics.Bitmap;

import it.sephiroth.android.library.picasso.Transformation;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-04-22
 * Time      : 16:01
 * Summary   :
 * Copyright : Copyright (c) 2016
 */
public class CropSquareTransformation implements Transformation {
    @Override
    public Bitmap transform(Bitmap bitmap) {
        int size = Math.min(bitmap.getWidth(), bitmap.getHeight());
        int x = (bitmap.getWidth() - size) / 2;
        int y = (bitmap.getHeight() - size) / 2;
        Bitmap result = Bitmap.createBitmap(bitmap, x, y, size, size);
        if(result!=bitmap){
            bitmap.recycle();
        }
        return result;
    }

    @Override
    public String key() {
        return null;
    }
}