package com.dyx.mgdp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {

    @Bind(R.id.but_add)
    Button butAdd;
    @Bind(R.id.but_delete)
    Button butDelete;
    @Bind(R.id.but_alert)
    Button butAlert;
    @Bind(R.id.but_search)
    Button butSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.but_add, R.id.but_delete, R.id.but_alert, R.id.but_search})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.but_add:
                break;
            case R.id.but_delete:
                break;
            case R.id.but_alert:
                break;
            case R.id.but_search:
                break;
        }
    }
}
