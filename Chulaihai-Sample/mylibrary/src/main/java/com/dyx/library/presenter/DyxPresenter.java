package com.dyx.library.presenter;

import com.dyx.library.view.DyxView;

/**
 * project name：Chulaihai-Sample
 * class describe：
 * create person：dayongxin
 * create time：16/6/27 上午11:54
 * alter person：dayongxin
 * alter time：16/6/27 上午11:54
 * alter remark：
 */
public interface DyxPresenter<V extends DyxView> {
    /**
     * 绑定View
     */
    void attachView(V view);

    /**
     * 解绑View
     */
    void dettachView(boolean retainInstances);

    /**
     * View可见
     */
    void resume();

    /**
     * View暂停
     */
    void pause();

    /**
     * View销毁
     */
    void destory();
}
