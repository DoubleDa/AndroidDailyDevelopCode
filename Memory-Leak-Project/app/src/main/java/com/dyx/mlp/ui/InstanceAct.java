package com.dyx.mlp.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.dyx.mlp.R;
import com.dyx.mlp.utils.InstanceContext;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-04-19
 * Time      : 10:14
 * Summary   :
 * Copyright : Copyright (c) 2016
 */
public class InstanceAct extends Activity {
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_instance_layout);
        mContext = this;
        //doWrongTask();
        doRightTask();
    }

    private void doRightTask() {
        InstanceContext.getInstance(getApplicationContext());
    }

    private void doWrongTask() {
        InstanceContext.getInstance(mContext);
    }
}