package com.dyx.ncd;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.dyx.ncd.constants.Constants;
import com.dyx.ncd.model.ClassifyModel;
import com.dyx.ncd.net.ApiService;
import com.orhanobut.logger.Logger;

import retrofit2.Retrofit;

public class NewsListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
    }

    private void initData() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constants.API_SERVER_HOST).build();
        ApiService service = retrofit.create(ApiService.class);
        ClassifyModel classifyModel = service.getClassify();
        Logger.d(classifyModel.isStatus());
    }
}
