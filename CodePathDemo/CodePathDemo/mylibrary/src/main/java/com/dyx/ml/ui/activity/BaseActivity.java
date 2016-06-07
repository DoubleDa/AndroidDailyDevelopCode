package com.dyx.ml.ui.activity;

import android.app.Activity;
import android.os.Bundle;

import butterknife.ButterKnife;

/**
 * project name：CodePathDemo
 * class describe：Activity基类
 * create person：dayongxin
 * create time：16/5/23 下午10:25
 * alter person：dayongxin
 * alter time：16/5/23 下午10:25
 * alter remark：
 */
public abstract class BaseActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        initView();
    }

    protected abstract void initView();

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
