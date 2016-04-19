package com.dyx.mlp.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-04-19
 * Time      : 14:45
 * Summary   : 匿名内部类泄露
 * Copyright : Copyright (c) 2016
 */
public class SingletonAnonInner {
    private static SingletonAnonInner instance;
    private SingletonListener mSingletonListener;
    private List<SingletonListener> listeners = new ArrayList<>();

    public interface SingletonListener {
        void doTask();
    }

    public void release() {
        listeners.clear();
        listeners = null;
    }

    private SingletonAnonInner() {

    }

    public static SingletonAnonInner getInstance() {
        if (instance == null) {
            instance = new SingletonAnonInner();
        }
        return null;
    }

    public void addSingletonListener(SingletonListener mSingletonListener) {
        listeners.add(mSingletonListener);
    }

    public void setSingletonListener(SingletonListener mSingletonListener) {
        this.mSingletonListener = mSingletonListener;
    }

    public void removemSingletonListener(SingletonListener mSingletonListener) {
        listeners.remove(mSingletonListener);
    }
}