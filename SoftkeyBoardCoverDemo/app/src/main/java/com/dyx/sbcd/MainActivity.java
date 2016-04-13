package com.dyx.sbcd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.dyx.sbcd.ui.Method1Act;
import com.dyx.sbcd.ui.Method2Act;
import com.dyx.sbcd.ui.Method3Act;
import com.dyx.sbcd.ui.Method4Act;

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
    @Bind(R.id.but4)
    Button but4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.but1, R.id.but2, R.id.but3, R.id.but4})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.but1:
                intentTo(Method1Act.class);
                break;
            case R.id.but2:
                intentTo(Method2Act.class);
                break;
            case R.id.but3:
                intentTo(Method3Act.class);
                break;
            case R.id.but4:
                intentTo(Method4Act.class);
                break;
        }
    }

    private void intentTo(Class<?> cls) {
        Intent i = new Intent(this, cls);
        startActivity(i);
    }
}
