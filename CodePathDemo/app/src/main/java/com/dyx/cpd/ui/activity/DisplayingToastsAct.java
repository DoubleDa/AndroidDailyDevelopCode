package com.dyx.cpd.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.dyx.cpd.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * project name：CodePathDemo
 * class describe：
 * create person：dayongxin
 * create time：16/6/8 下午5:01
 * alter person：dayongxin
 * alter time：16/6/8 下午5:01
 * alter remark：
 */
public class DisplayingToastsAct extends Activity {


    @BindView(R.id.button)
    Button button;
    @BindView(R.id.button2)
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_displaying_toasts_layout);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.button, R.id.button2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                Toast.makeText(this, "测试", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button2:
                break;
        }
    }
}

