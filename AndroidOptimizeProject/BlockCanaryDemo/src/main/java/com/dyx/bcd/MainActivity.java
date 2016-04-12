package com.dyx.bcd;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.FrameLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.but_start)
    Button butStart;
    @Bind(R.id.container)
    FrameLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        getSupportFragmentManager().beginTransaction().add(R.id.container, MainFragment.newInstance()).commit();
    }

    @OnClick(R.id.but_start)
    public void onClick() {
        showMyDialog();
    }

    private void showMyDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("Tip");
        builder.setMessage("This is a blockCanary demo!");
        builder.setNegativeButton("Ok", null);
        builder.show();
    }


}
