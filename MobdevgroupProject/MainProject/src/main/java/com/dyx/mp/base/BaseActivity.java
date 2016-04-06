package com.dyx.mp.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;

import com.dyx.mp.utils.AppManager;

/**
 * Created by Da on 2016/4/5.
 */
public abstract class BaseActivity extends Activity {
    private boolean isFullScreen = true;


    public void setIsFullScreen(boolean isFullScreen) {
        this.isFullScreen = isFullScreen;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        if (isFullScreen) {
            requestWindowFeature(Window.FEATURE_NO_TITLE);
        }
        AppManager.getAppManager().addActivity(this);
        initView(savedInstanceState);
        initVariables();
        initData();
    }


    protected abstract void initView(Bundle savedInstanceState);

    protected abstract void initVariables();

    protected abstract void initData();

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
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
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getAppManager().destoryActivity(this);
    }

    public void intentTo(Context context, Class<?> cla) {
        Intent intent = new Intent();
        intent.setClass(context, cla);
        startActivity(intent);
    }
}
