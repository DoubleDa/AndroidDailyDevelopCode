package com.dyx.dil.utils;

import java.io.File;
import java.math.BigDecimal;

/**
 * project name：DImageLoader
 * class describe：
 * create person：dayongxin
 * create time：2016/12/30 下午8:33
 * alter person：dayongxin
 * alter time：2016/12/30 下午8:33
 * alter remark：
 */
public class FileUtils {
    /**
     * 获取指定文件夹大小
     *
     * @param file
     * @return
     */
    public static long getFolderSize(File file) {
        //初始化大小
        long size = 0;
        //列出目录下所有的文件
        File[] files = file.listFiles();
        //遍历文件数组
        for (File file1 : files) {
            if (file1.isDirectory()) {
                //目录
                size = size + getFolderSize(file1);
            } else {
                //文件
                size = size + file1.length();
            }
        }
        return size;
    }

    /**
     * 获取格式化大小
     *
     * @param size
     * @return
     */
    public static String getFormatSize(double size) {
        //byte
        double kiloByte = size / 1024;
        if (kiloByte < 1) {
            return size + "Byte";
        }
        //kb
        double megaByte = kiloByte / 1024;
        if (megaByte < 1) {
            BigDecimal resultKb = new BigDecimal(Double.toString(kiloByte));
            return resultKb.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString() + "KB";
        }
        //mb
        double gigaByte = megaByte / 1024;
        if (gigaByte < 1) {
            BigDecimal resultMb = new BigDecimal(Double.toString(megaByte));
            return resultMb.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString() + "MB";
        }
        //gb
        double teraByte = gigaByte / 1024;
        if (teraByte < 1) {
            BigDecimal resultGb = new BigDecimal(Double.toString(gigaByte));
            return resultGb.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString() + "GB";
        }
        //tb
        BigDecimal resultTb = new BigDecimal(Double.toString(teraByte));
        return resultTb.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString() + "TB";
    }
}
