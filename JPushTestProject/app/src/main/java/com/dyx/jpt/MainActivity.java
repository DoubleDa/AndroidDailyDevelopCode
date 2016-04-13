package com.dyx.jpt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.dyx.jpt.ui.AdvancedFunctionAct;
import com.dyx.jpt.ui.NotificationAct;
import com.dyx.jpt.ui.SettingFunctionAct;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {

    @Bind(R.id.but1)
    Button but1;
    @Bind(R.id.but2)
    Button but2;
    @Bind(R.id.but3)
    Button but3;
    public static boolean isForeground = false;
    public static final String KEY_TITLE = "title";
    public static final String KEY_MESSAGE = "message";
    public static final String KEY_EXTRAS = "extras";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.but1, R.id.but2, R.id.but3})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.but1:
                intentTo(AdvancedFunctionAct.class);
                break;
            case R.id.but2:
                intentTo(SettingFunctionAct.class);
                break;
            case R.id.but3:
                intentTo(NotificationAct.class);
                break;
        }
    }

    private void intentTo(Class<?> cla) {
        Intent i = new Intent(MainActivity.this, cla);
        startActivity(i);
    }

    @Override
    protected void onResume() {
        isForeground = true;
        super.onResume();
    }
}
