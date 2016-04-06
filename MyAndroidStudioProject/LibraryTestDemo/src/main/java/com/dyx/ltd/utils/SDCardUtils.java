package com.dyx.ltd.utils;

import android.os.Environment;

import java.io.File;

/**
 * Created by Da on 2016/3/29.
 */
public class SDCardUtils {
    public static class MySDCard {
        public long total;
        public long free;
    }

    public static MySDCard getMySDCardInfo() {
        String state = android.os.Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED)) {
            try {
                File filePath = android.os.Environment.getExternalStorageDirectory();

                android.os.StatFs statFs = new android.os.StatFs(filePath.getPath());
                long totalBlock = statFs.getBlockCount();
                long everyBlockSize = statFs.getBlockSize();
                long blockCount = statFs.getAvailableBlocks();
                long freeBlockCount = statFs.getFreeBlocks();

                MySDCard mySDCard = new MySDCard();
                mySDCard.total = totalBlock * everyBlockSize;
                mySDCard.free = blockCount * everyBlockSize;
                return mySDCard;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
