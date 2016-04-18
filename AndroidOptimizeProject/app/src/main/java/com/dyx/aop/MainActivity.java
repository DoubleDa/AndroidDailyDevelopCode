package com.dyx.aop;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {

    @Bind(R.id.iv)
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        doMemoryhandle();
    }

    /**
     * 自身内存占用监控
     */
    private void doMemoryhandle() {
        /**
         * 实现原理
         */
        //获取maxMemory
        long maxMemory = Runtime.getRuntime().maxMemory();
        //获取usingMemory
        long usingMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        /**
         * 操作方式：我们可以定期(前台每隔3分钟)去得到这个值，当我们这个值达到危险值时(例如80%)，
         * 我们应当主要去释放我们的各种cache资源(bitmap的cache为大头)，同时显示的去Trim应用
         * 的memory,加速内存收集
         */
        //WindowManagerGlobal.getInstance().startTrimMemory(TRIM_MEMORY_COMPLETE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        /**
         * 通过兜底回收内存：在Activity onDestory时候从view的rootview开始，递归释放所有子view涉及的图片，
         * 背景，DrawingCache，监听器等等资源，让Activity成为一个不占资源的空壳，泄露了也不会导致图片资源被持有
         */
        //获取Drawable对象
        Drawable d = iv.getDrawable();
        if (d != null) {
            //设置Drawable回调为空
            d.setCallback(null);
        }
        //设置背景为空
        iv.setImageDrawable(null);

    }

    @OnClick(R.id.iv)
    public void onClick() {
    }
}
