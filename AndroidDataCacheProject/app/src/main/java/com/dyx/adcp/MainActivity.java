package com.dyx.adcp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.dyx.cdbf.utils.CacheUtil;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {

    @Bind(R.id.but_write)
    Button butWrite;
    @Bind(R.id.but_read)
    Button butRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.but_write, R.id.but_read})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.but_write:
                String data = "";
                String url = "";
                CacheUtil.putDataToFile(data, url);
                break;
            case R.id.but_read:
                String mUrl = "";
                String result = CacheUtil.getDataByUrl(mUrl, CacheUtil.CacheModel.CACHE_TIMEOUT_MODEL_LONG, this);
                break;
        }
    }
}
