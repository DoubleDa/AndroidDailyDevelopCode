package com.dyx.lcd.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.dyx.lcd.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * project name：LeakCanaryDemo
 * class describe：
 * create person：dayongxin
 * create time：2016/11/1 上午11:09
 * alter person：dayongxin
 * alter time：2016/11/1 上午11:09
 * alter remark：
 */
public class HandlerAct extends Activity {
    @BindView(R.id.tv_msg)
    TextView tvMsg;
    //创建一个Handler
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                tvMsg.setText("dyx");
            }
        }, 3 * 60 * 1000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //移除回调和信息
        mHandler.removeCallbacksAndMessages(null);
    }
}
