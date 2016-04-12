package com.dyx.bcd.context;

import android.content.pm.PackageInfo;

import com.dyx.bcd.base.BaseApplication;
import com.github.moduth.blockcanary.BlockCanaryContext;

import java.io.File;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-04-12
 * Time      : 11:05
 * Summary   :
 * Copyright : Copyright (c) 2016
 */
public class AppBlockCanaryContext extends BlockCanaryContext {
    /**
     * 获取user id
     *
     * @return
     */
    @Override
    public String getUid() {
        return "2010212253";
    }

    /**
     * 获取apk限定词
     *
     * @return
     */
    @Override
    public String getQualifier() {
        String qual = "";
        try {
            PackageInfo info = BaseApplication.getAppContext().getPackageManager().getPackageInfo(BaseApplication.getAppContext().getPackageName(), 0);
            qual = info.versionName + info.versionCode + "wochu";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return qual;
    }

    /**
     * 获取网络类型：2G, 3G, 4G, wifi
     *
     * @return
     */
    @Override
    public String getNetworkType() {
        return "wifi";
    }

    /**
     * 获取配置间隔
     *
     * @return
     */
    @Override
    public int getConfigDuration() {
        return 5000;
    }

    /**
     * 获取block配置的临界值
     *
     * @return
     */
    @Override
    public int getConfigBlockThreshold() {
        return 1000;
    }

    /**
     * 是否显示notification和block出来
     *
     * @return
     */
    @Override
    public boolean isNeedDisplay() {
        return true;
    }

    /**
     * 获取log信息路径
     *
     * @return
     */
    @Override
    public String getLogPath() {
        return super.getLogPath();
    }

    /**
     * 压缩log信息
     *
     * @param src
     * @param dest
     * @return
     */
    @Override
    public boolean zipLogFile(File[] src, File dest) {
        return super.zipLogFile(src, dest);
    }

    /**
     * 上传log信息
     *
     * @param zippedFile
     */
    @Override
    public void uploadLogFile(File zippedFile) {
        super.uploadLogFile(zippedFile);
    }

    /**
     * 获取折叠堆栈前缀
     *
     * @return
     */
    @Override
    public String getStackFoldPrefix() {
        return super.getStackFoldPrefix();
    }

    /**
     * 获取存储空间
     *
     * @return
     */
    @Override
    public int getConfigDumpIntervalMillis() {
        return super.getConfigDumpIntervalMillis();
    }
}