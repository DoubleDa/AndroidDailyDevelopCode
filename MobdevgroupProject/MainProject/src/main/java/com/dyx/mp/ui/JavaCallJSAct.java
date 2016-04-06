package com.dyx.mp.ui;

import android.os.Bundle;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;

import com.dyx.lw.InjectWebview;
import com.dyx.mp.R;
import com.dyx.mp.base.BaseActivity;
import com.dyx.mp.utils.ScopeHostJs;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-04-05
 * Time      : 17:24
 * Summary   : 测试InjectWebview
 * Copyright : Copyright (c) 2016
 */
public class JavaCallJSAct extends BaseActivity {
    private WebView mWv_call_js;
    private ImageView mIv_exit;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.act_java_call_js_layout);
    }

    @Override
    protected void initVariables() {
        mWv_call_js = (WebView) findViewById(R.id.wv_call_js);
        mIv_exit = (ImageView) findViewById(R.id.iv_exit);
        WebSettings settings = mWv_call_js.getSettings();
        settings.setJavaScriptEnabled(true);
        mWv_call_js.setWebChromeClient(new InjectWebview("HostApp", ScopeHostJs.class));
        mWv_call_js.loadUrl("file:///android_asset/test.html");
    }

    @Override
    protected void initData() {

    }

    public class MyWebChromeClient extends InjectWebview {
        public MyWebChromeClient(String injectName, Class clas) {
            super(injectName, clas);
        }

        @Override
        public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
            return super.onJsPrompt(view, url, message, defaultValue, result);
        }

        @Override
        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
            return super.onJsAlert(view, url, message, result);
        }

        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
        }
    }
}