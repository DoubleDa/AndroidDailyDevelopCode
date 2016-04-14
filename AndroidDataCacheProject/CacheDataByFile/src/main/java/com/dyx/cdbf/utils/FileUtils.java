package com.dyx.cdbf.utils;

import android.os.Environment;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-04-14
 * Time      : 15:14
 * Summary   :
 * Copyright : Copyright (c) 2016
 */
public class FileUtils {
    public static final long B = 1;
    public static final long KB = B * 1024;
    public static final long MB = KB * 1024;
    public static final long GB = MB * 1024;
    public static final int DEFAULT_BUFFER = 1024 * 8;

    /**
     * 格式化文件大小
     *
     * @param size
     * @return
     */
    public static String formatFileSize(long size) {
        StringBuilder sb = new StringBuilder();
        String resultUnit = null;
        double tempSize = 0;
        if (size < KB) {
            sb.append(size).append("B");
            return sb.toString();
        } else if (size < MB) {
            tempSize = getSize(size, KB);
            resultUnit = "KB";
        } else if (size < GB) {
            tempSize = getSize(size, MB);
            resultUnit = "MB";
        } else {
            tempSize = getSize(size, GB);
            resultUnit = "GB";
        }
        return sb.append(dealSize(tempSize)).append(resultUnit).toString();
    }

    /**
     * 保留小数点两位
     *
     * @param tempSize
     * @return
     */
    private static String dealSize(double tempSize) {
        return String.format("%.2f", tempSize);
    }

    /**
     * 重新计算大小
     *
     * @param size
     * @param kb
     * @return
     */
    private static double getSize(long size, long kb) {
        return (double) size / (double) kb;
    }

    /**
     * 获取缓存数据
     *
     * @param file
     * @return
     */
    public static String getDataFromFile(File file) throws IOException {
        String result = "";
        InputStream is = null;
        try {
            is = new FileInputStream(file);
            result = getDataFromStream(is);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                is.close();
            }
        }

        return result;
    }

    private static String getDataFromStream(InputStream is) throws IOException {
        StringBuffer sb = new StringBuffer();
        String line = "";
        BufferedReader br = null;
        br = new BufferedReader(new InputStreamReader(is));
        try {
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                br.close();
            }
        }
        return sb.toString();
    }

    /**
     * 向缓存文件添加数据
     *
     * @param file
     * @param data
     */
    public static void putDataToFile(File file, String data) throws IOException {
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream(file));
            dos.write(data.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (dos != null) {
                dos.close();
            }
        }
    }

    /**
     * SD卡是否挂载且可用
     *
     * @return
     */
    public static boolean isSDCardAvailable() {
        return android.os.Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    /**
     * 创建文件目录
     *
     * @param path
     */
    public static void createFileDir(String path) {
        if (!isSDCardAvailable()) {
            return;
        }
        File file = new File(path);
        if (!file.exists()) {
            try {
                file.mkdirs();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}