package com.dyx.mlp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.dyx.mlp.ui.AnonInnerClassAct;
import com.dyx.mlp.ui.HandlerAct;
import com.dyx.mlp.ui.InnerClassAct;
import com.dyx.mlp.ui.InstanceAct;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {

    @Bind(R.id.but_instance)
    Button butInstance;
    @Bind(R.id.but_handler)
    Button butHandler;
    @Bind(R.id.but_innner_class)
    Button butInnnerClass;
    @Bind(R.id.but_anonymous_class)
    Button butAnonymousClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.but_instance, R.id.but_handler, R.id.but_innner_class, R.id.but_anonymous_class})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.but_instance:
                intentTo(InstanceAct.class);
                break;
            case R.id.but_handler:
                intentTo(HandlerAct.class);
                break;
            case R.id.but_innner_class:
                intentTo(InnerClassAct.class);
                break;
            case R.id.but_anonymous_class:
                intentTo(AnonInnerClassAct.class);
                break;
            default:
                break;
        }
    }

    private void intentTo(Class<?> cla) {
        Intent i = new Intent(this, cla);
        startActivity(i);
    }
}
