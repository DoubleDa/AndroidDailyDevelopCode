package com.dyx.lcd;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.dyx.lcd.ui.CursorAct;
import com.dyx.lcd.ui.HandlerAct;
import com.dyx.lcd.ui.NotStaticAct;
import com.dyx.lcd.ui.SingletonAct;
import com.dyx.lcd.ui.ThreadAct;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_singleton)
    Button btnSingleton;
    @BindView(R.id.btn_handler)
    Button btnHandler;
    @BindView(R.id.btn_thread)
    Button btnThread;
    @BindView(R.id.btn_not_static)
    Button btnNotStatic;
    @BindView(R.id.btn_cursor)
    Button btnCursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_singleton, R.id.btn_handler, R.id.btn_thread, R.id.btn_not_static, R.id.btn_cursor})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_singleton:
                intentTo(SingletonAct.class);
                break;
            case R.id.btn_handler:
                intentTo(HandlerAct.class);
                break;
            case R.id.btn_thread:
                intentTo(ThreadAct.class);
                break;
            case R.id.btn_not_static:
                intentTo(NotStaticAct.class);
                break;
            case R.id.btn_cursor:
                intentTo(CursorAct.class);
                break;
        }
    }

    private void intentTo(Class<?> cla) {
        startActivity(new Intent(this, cla));
    }
}
