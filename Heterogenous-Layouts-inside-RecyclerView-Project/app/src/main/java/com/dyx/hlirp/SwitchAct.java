package com.dyx.hlirp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * project name：Heterogenous-Layouts-inside-RecyclerView-Project
 * class describe：
 * create person：dayongxin
 * create time：16/7/19 下午4:03
 * alter person：dayongxin
 * alter time：16/7/19 下午4:03
 * alter remark：
 */
public class SwitchAct extends Activity {
    @Bind(R.id.but_custom)
    Button butCustom;
    @Bind(R.id.but_my)
    Button butMy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_switch_layout);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.but_custom, R.id.but_my})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.but_custom:
                intentTo(MainActivity.class);
                break;
            case R.id.but_my:
                intentTo(MyNeedViewAct.class);
                break;
        }
    }


    private void intentTo(Class<?> cla) {
        Intent intent = new Intent(SwitchAct.this, cla);
        startActivity(intent);
    }
}
