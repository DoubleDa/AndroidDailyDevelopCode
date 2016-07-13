package com.dyx.diwdp;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dyx.diwdp.interfaces.IonicChinaInterface;

import javax.inject.Inject;

import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Inject
    SharedPreferences mSharedPreferences;

    @Inject
    Retrofit mRetrofit;

    @Inject
    IonicChinaInterface mIonicChinaInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

    }
}
