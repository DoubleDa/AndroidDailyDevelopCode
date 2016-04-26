package com.dyx.rap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.dyx.rap.ui.ComplexActivity;
import com.dyx.rap.ui.LambdaActivity;
import com.dyx.rap.ui.NetworkActivity;
import com.dyx.rap.ui.SimpleActivity;
import com.dyx.rap.ui.ThreadActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 要点包含:
 * (1) 链式表达式的使用方式.
 * (2) Lambda的应用.
 * (3) Rx处理网络请求.
 * (4) 线程自动管理, 防止内存泄露.
 * (5) RxBinding绑定控件的异步事件.
 */
public class MainActivity extends Activity {

    @Bind(R.id.but_simple)
    Button butSimple;
    @Bind(R.id.but_complex)
    Button butComplex;
    @Bind(R.id.but_lambda)
    Button butLambda;
    @Bind(R.id.but_network)
    Button butNetwork;
    @Bind(R.id.but_thread)
    Button butThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.but_simple, R.id.but_complex, R.id.but_lambda, R.id.but_network, R.id.but_thread})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.but_simple:
                intentTo(SimpleActivity.class);
                break;
            case R.id.but_complex:
                intentTo(ComplexActivity.class);
                break;
            case R.id.but_lambda:
                intentTo(LambdaActivity.class);
                break;
            case R.id.but_network:
                intentTo(NetworkActivity.class);
                break;
            case R.id.but_thread:
                intentTo(ThreadActivity.class);
                break;
        }
    }

    private void intentTo(Class<?> cla) {
        Intent i = new Intent(this, cla);
        startActivity(i);
    }
}
