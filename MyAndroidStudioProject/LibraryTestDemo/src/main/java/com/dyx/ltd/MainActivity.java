package com.dyx.ltd;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends Activity {


    @Bind(R.id.but_test1)
    Button butTest1;
    @Bind(R.id.but_test2)
    Button butTest2;
    @Bind(R.id.but_test3)
    Button butTest3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.but_test1, R.id.but_test2, R.id.but_test3})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.but_test1:
                Toast.makeText(this,"Success!",Toast.LENGTH_SHORT).show();
                break;
            case R.id.but_test2:
                break;
            case R.id.but_test3:
                break;
        }
    }
}
