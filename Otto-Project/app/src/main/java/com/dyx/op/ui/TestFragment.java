package com.dyx.op.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.apkfuns.logutils.LogUtils;
import com.dyx.op.R;
import com.dyx.op.bus.AppBus;
import com.dyx.op.event.BusEventData;
import com.dyx.op.event.BusScrollViewData;
import com.squareup.otto.Subscribe;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-04-27
 * Time      : 15:35
 * Summary   :
 * Copyright : Copyright (c) 2016
 */
public class TestFragment extends Fragment {

    @Bind(R.id.et_input)
    EditText etInput;

    public static TestFragment getInstance() {
        TestFragment fragment = new TestFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test_layout, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Subscribe
    public void onScrollChanged(BusScrollViewData data) {
        LogUtils.i(data);
    }

    @Override
    public void onStart() {
        super.onStart();
        AppBus.getInstance().register(this);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        AppBus.getInstance().unregister(this);
    }

    @Subscribe
    public void setContent(BusEventData data) {
        etInput.setText("姓名：" + data.getName() + "\n" + "年龄：" + data.getAge());
    }

    @Subscribe
    public void onDataChanged(String str) {
        LogUtils.i(str);
    }
}