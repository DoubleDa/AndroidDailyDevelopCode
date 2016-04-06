package com.dyx.lw;

import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-04-05
 * Time      : 15:54
 * Summary   : 扩展WebChromeClient
 * Copyright : Copyright (c) 2016
 */
public class InjectWebview extends WebChromeClient {
    private JsCallJava mJsCallJava;
    private boolean isInjectJs;

    public InjectWebview(String injectName, Class clas) {
        mJsCallJava = new JsCallJava(injectName, clas);
    }

    public InjectWebview(JsCallJava mJsCallJava) {
        this.mJsCallJava = mJsCallJava;
    }

    @Override
    public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
        result.confirm();
        return true;
    }

    @Override
    public void onProgressChanged(WebView view, int newProgress) {
        if (newProgress <= 25) {
            isInjectJs = false;
        } else if (!isInjectJs) {
            view.loadUrl(mJsCallJava.getmPreloadInterfaceJs());
            isInjectJs = true;
        }
        super.onProgressChanged(view, newProgress);
    }

    @Override
    public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
        result.confirm(mJsCallJava.call(view, message));
        return true;
    }
}