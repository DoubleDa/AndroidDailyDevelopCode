package com.dyx.al.base;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cocosw.lifecycle.ActivityLifecycleCallbacksCompat;
import com.cocosw.lifecycle.FragmentLifecycleCallbacks;
import com.cocosw.lifecycle.LifecycleDispatcher;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-04-18
 * Time      : 11:12
 * Summary   :
 * Copyright : Copyright (c) 2016
 */
public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //为Activity注册生命周期回调
        LifecycleDispatcher.registerActivityLifecycleCallbacks(this, new ActivityLifecycleCallbacksCompat() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });
        //为Fragment注册生命周期回调
        LifecycleDispatcher.registerFragmentLifecycleCallbacks(this, new FragmentLifecycleCallbacks() {
            @Override
            public void onFragmentCreated(Fragment fragment, Bundle savedInstanceState) {

            }

            @Override
            public void onFragmentStarted(Fragment fragment) {

            }

            @Override
            public void onFragmentResumed(Fragment fragment) {

            }

            @Override
            public void onFragmentPaused(Fragment fragment) {

            }

            @Override
            public void onFragmentStopped(Fragment fragment) {

            }

            @Override
            public void onFragmentSaveInstanceState(Fragment fragment, Bundle outState) {

            }

            @Override
            public void onFragmentDestroyed(Fragment fragment) {

            }

            @Override
            public void onFragmentAttach(Fragment fragment, Activity activity) {

            }

            @Override
            public void onFragmentDetach(Fragment fragment) {

            }

            @Override
            public void onFragmentActivityCreated(Fragment fragment, Bundle savedInstanceState) {

            }

            @Override
            public void onFragmentCreateView(Fragment fragment, LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            }

            @Override
            public void onFragmentViewCreated(Fragment fragment, View view, Bundle savedInstanceState) {

            }
        });
    }
}