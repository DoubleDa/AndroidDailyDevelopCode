package com.dyx.library.view;

/**
 * project name：Chulaihai-Sample
 * class describe：
 * create person：dayongxin
 * create time：16/6/27 上午11:44
 * alter person：dayongxin
 * alter time：16/6/27 上午11:44
 * alter remark：
 */
public interface DyxView {
    /**
     * 显示提示信息
     */
    void showToast(String msg);

    /**
     * 显示提示信息
     */
    void showToast(int msgId);

    /**
     * 显示登录框
     */
    void showLoginLayout();

    /**
     * 显示注册框
     */
    void showRegisterLayout();

    /**
     * 显示网络无法访问提示信息
     */
    void showNetworkUnavailable();

    /**
     * 取消加载框
     */
    void dismissLoadingDialog();

    /**
     * 显示加载框
     */
    void showLoadingDialog();
}
