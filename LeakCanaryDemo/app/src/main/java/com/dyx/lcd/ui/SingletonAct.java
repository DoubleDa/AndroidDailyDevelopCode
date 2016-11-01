package com.dyx.lcd.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.dyx.lcd.R;
import com.dyx.lcd.other.LoginManager;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * project name：LeakCanaryDemo
 * class describe：
 * create person：dayongxin
 * create time：2016/11/1 上午10:54
 * alter person：dayongxin
 * alter time：2016/11/1 上午10:54
 * alter remark：
 */
public class SingletonAct extends Activity {
    @BindView(R.id.tv_result)
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleton);
        ButterKnife.bind(this);
        tvResult.setText(LoginManager.getInstance(this).getResult());
    }
}
