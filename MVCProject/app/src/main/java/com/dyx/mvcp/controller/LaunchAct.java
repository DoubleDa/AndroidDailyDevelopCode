package com.dyx.mvcp.controller;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

import com.dyx.mvcp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * project name：MVCProject
 * class describe：
 * create person：dayongxin
 * create time：2016/12/22 上午11:02
 * alter person：dayongxin
 * alter time：2016/12/22 上午11:02
 * alter remark：http://blog.csdn.net/p106786860/article/details/53439421
 */
public class LaunchAct extends Activity {
    @BindView(R.id.btn_get_access_token)
    Button btnGetAccessToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_get_access_token)
    public void onClick() {

    }
}
