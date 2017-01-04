package com.dyx.dil.listener;

/**
 * project name：DImageLoader
 * class describe：
 * create person：dayongxin
 * create time：2016/12/30 上午11:56
 * alter person：dayongxin
 * alter time：2016/12/30 上午11:56
 * alter remark：
 */
public interface DProgressLoadListener {
    void update(int readLength, int totalLength);

    void onException();

    void onResourceReady();
}
