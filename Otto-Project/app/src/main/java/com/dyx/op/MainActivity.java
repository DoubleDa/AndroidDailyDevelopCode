package com.dyx.op;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.dyx.op.bus.AppBus;
import com.dyx.op.event.BusEventData;
import com.dyx.op.ui.TestFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {

    @Bind(R.id.but1)
    Button but1;
    @Bind(R.id.but2)
    Button but2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        FragmentManager manager = getFragmentManager();
        android.app.FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, TestFragment.getInstance());
        transaction.commit();
    }

    @OnClick({R.id.but1, R.id.but2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.but1:
                AppBus.getInstance().post(new BusEventData("dayongxin", 18));
                break;
            case R.id.but2:
                AppBus.getInstance().post("Success！");
                break;
        }
    }
}
