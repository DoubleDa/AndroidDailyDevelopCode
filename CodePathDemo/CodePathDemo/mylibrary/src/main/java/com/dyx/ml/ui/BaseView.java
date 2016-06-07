package com.dyx.ml.ui;

import android.view.View;

/**
 * project name：CodePathDemo
 * class describe：BaseView接口
 * create person：dayongxin
 * create time：16/5/23 下午10:35
 * alter person：dayongxin
 * alter time：16/5/23 下午10:35
 * alter remark：
 */
public interface BaseView {
    /**
     * 显示加载进度
     */
    void showLoading(String msg);

    /**
     * 隐藏进度
     */
    void hideLoading();

    /**
     * 显示错误信息
     */
    void showErrorMsg(String msg, View.OnClickListener onClickListener);

    /**
     * 显示空视图
     */
    void showEmptyView(String msg,View.OnClickListener onClickListener);

    /**
     * 显示空视图(包含图片)
     */
    void showEmptyViewImg(String msg,View.OnClickListener onClickListener,int imgId);

    /**
     * 显示网络错误信息
     */
    void showNetError(View.OnClickListener onClickListener);
}
