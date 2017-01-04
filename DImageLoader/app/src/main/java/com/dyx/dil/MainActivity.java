package com.dyx.dil;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.dyx.dil.engine.DImageLoader;
import com.dyx.dil.listener.DProgressLoadListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends Activity {
    @BindView(R.id.iv_show)
    ImageView ivShow;
    @BindView(R.id.activity_main)
    RelativeLayout activityMain;
    private static final String IMGAGE_URL = "http://img.i-kitchen.cn/upload/77f507b4-697c-4e6a-8d3f-fd192d5505b9.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        DImageLoader.getInstance().displayImageWithProgress(IMGAGE_URL, ivShow, new DProgressLoadListener() {
            @Override
            public void update(int readLength, int totalLength) {
                Log.i("TAG", readLength + "|" + totalLength);
            }

            @Override
            public void onException() {

            }

            @Override
            public void onResourceReady() {

            }
        });
    }
}
