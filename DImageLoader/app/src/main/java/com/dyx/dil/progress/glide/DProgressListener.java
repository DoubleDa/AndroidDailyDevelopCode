package com.dyx.dil.progress.glide;

/**
 * project name：DImageLoader
 * class describe：
 * create person：dayongxin
 * create time：2016/12/30 下午7:46
 * alter person：dayongxin
 * alter time：2016/12/30 下午7:46
 * alter remark：
 */
public interface DProgressListener {
    void update(long readLength, long totalLength, boolean done);
}
