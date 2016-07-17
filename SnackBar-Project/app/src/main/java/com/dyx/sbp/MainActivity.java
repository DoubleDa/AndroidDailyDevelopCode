package com.dyx.sbp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @Bind(R.id.but_simple)
    Button butSimple;
    @Bind(R.id.but_click)
    Button butClick;
    @Bind(R.id.but_click_color)
    Button butClickColor;
    @Bind(R.id.but_click_bg)
    Button butClickCallback;
    @Bind(R.id.but_click_location)
    Button butClickLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.but_simple, R.id.but_click, R.id.but_click_color, R.id.but_click_bg, R.id.but_click_location})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.but_simple:
                Snackbar.make(butSimple, "成功！", Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.but_click:
                snackBarClick();
                break;
            case R.id.but_click_color:
                snackBarClickColor();
                break;
            case R.id.but_click_bg:
                snackBarBg();
                break;
            case R.id.but_click_location:
                snackBarLocation();
                break;
        }
    }

    private void snackBarLocation() {
        Snackbar snackbar = Snackbar.make(butClickLocation, "It is a Snackbar!", Snackbar.LENGTH_SHORT);
        View view = snackbar.getView();
        ViewGroup.LayoutParams params = view.getLayoutParams();
        CoordinatorLayout.LayoutParams cl = new CoordinatorLayout.LayoutParams(params.width, params.height);
        ((TextView) view.findViewById(R.id.snackbar_text)).setTextColor(Color.GREEN);
        cl.gravity = Gravity.CENTER;
        view.setLayoutParams(cl);
        view.setBackgroundColor(Color.BLUE);
        ImageView imageView = new ImageView(MainActivity.this);
        imageView.setImageResource(R.mipmap.ic_launcher);
        Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) view;
        snackbarLayout.addView(imageView, 0);
        snackbar.setActionTextColor(Color.RED).setAction("点我", new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        }).show();
    }

    private void snackBarBg() {
        Snackbar snackbar = Snackbar.make(butClickCallback, "It is a Snackbar!", Snackbar.LENGTH_SHORT);
        View view = snackbar.getView();
        view.setBackgroundColor(Color.BLUE);
        snackbar.show();
    }


    private void snackBarClickColor() {
        Snackbar.make(butClickColor, "It is a Snackbar!", Snackbar.LENGTH_SHORT).setActionTextColor(Color.BLUE).setAction("点我", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "成功！", Toast.LENGTH_SHORT).show();
            }
        }).show();
    }

    private void snackBarClick() {
        Snackbar.make(butClick, "It is a Snackbar!", Snackbar.LENGTH_SHORT).setAction("点我", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "成功！", Toast.LENGTH_SHORT).show();
            }
        }).show();
    }
}
