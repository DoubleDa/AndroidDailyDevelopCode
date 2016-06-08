package com.dyx.cpd.ui.activity;

import com.dyx.cpd.R;
import com.dyx.cpd.listener.MyCustomObject;
import com.dyx.ml.ui.activity.BaseActivity;

/**
 * project name：CodePathDemo
 * class describe：
 * create person：dayongxin
 * create time：16/6/6 下午11:38
 * alter person：dayongxin
 * alter time：16/6/6 下午11:38
 * alter remark：
 */
public class CreatingCustomListenersAct extends BaseActivity {
    @Override
    protected void initView() {
        setContentView(R.layout.act_creating_custom_listeners_layout);

        MyCustomObject object = new MyCustomObject();

        object.setCustomObjectListener(new MyCustomObject.MyCustomObjectListener() {
            @Override
            public void stepOne(String titleOne) {

            }

            @Override
            public void stepTwo(String titleTwo) {

            }

            @Override
            public void stepThree(String titleThree) {

            }
        });
    }
}
