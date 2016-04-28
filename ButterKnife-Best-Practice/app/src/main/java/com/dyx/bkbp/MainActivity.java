package com.dyx.bkbp;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.dyx.bkbp.base.BaseActivity;

import butterknife.Bind;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @Bind(R.id.textView)
    TextView textView;
    @Bind(R.id.button)
    Button button;
    @Bind(R.id.imageButton)
    ImageButton imageButton;
    @Bind(R.id.imageView)
    ImageView imageView;
    @Bind(R.id.webView)
    WebView webView;
    @Bind(R.id.listView)
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_main);
    }

    @OnClick({R.id.textView, R.id.button, R.id.imageButton, R.id.imageView, R.id.webView, R.id.listView})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.textView:
                break;
            case R.id.button:
                break;
            case R.id.imageButton:
                break;
            case R.id.imageView:
                break;
            case R.id.webView:
                break;
            case R.id.listView:
                break;
        }
    }
}
