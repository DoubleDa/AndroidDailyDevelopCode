package com.dyx.mlp.ui;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;

import com.dyx.mlp.R;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-04-19
 * Time      : 14:37
 * Summary   :
 * Copyright : Copyright (c) 2016
 */
public class InnerClassAct extends Activity {
    public static final int ONE_HOUR = 60 * 60 * 60 * 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_inner_class_layout);
        doLeakTask();
    }

    private void doLeakTask() {
        new DownloadTask().execute();
    }

    public class DownloadTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            try {
                Thread.sleep(ONE_HOUR);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}