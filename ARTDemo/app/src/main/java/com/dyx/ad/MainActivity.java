package com.dyx.ad;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.orhanobut.logger.Logger;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = "***ART***";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Logger.d(TAG + "come:" + SystemClock.uptimeMillis());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Logger.d(TAG + "go:" + SystemClock.uptimeMillis());
    }
}
