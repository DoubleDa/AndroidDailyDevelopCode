package com.dyx.lw;

import android.webkit.WebView;

import java.lang.ref.WeakReference;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-04-05
 * Time      : 14:51
 * Summary   : 异步回调
 * Copyright : Copyright (c) 2016
 */
public class JsCallback {
    private final static String CALLBACK_JS_FORMATT = "javascript:%s.callback(%d, %d %s);";
    private int mIndex;
    private boolean isCanGoOn;
    private WeakReference<WebView> mWebView;
    private int mPermanent;
    private String mInjectName;


    public JsCallback(WebView webView, String mInjectName, int anInt) {
        isCanGoOn = true;
        mWebView = new WeakReference<WebView>(webView);
        this.mInjectName = mInjectName;
        this.mIndex = mIndex;
    }

    public void apply(Object... args) throws JsCallbackException {
        if (mWebView.get() == null) {
            throw new JsCallbackException("the WebView related to the JsCallback has been recycled");
        }
        if (!isCanGoOn) {
            throw new JsCallbackException("the JsCallback isn't permanent,cannot be called more than once");
        }
        StringBuilder sb = new StringBuilder();
        for (Object obj : args) {
            sb.append(",");
            boolean isStrTag = obj instanceof String;
            if (isStrTag) {
                sb.append("\"");
            }
            sb.append(String.valueOf(obj));
            if (isStrTag) {
                sb.append("\"");
            }
        }
        String executeJs = String.format(CALLBACK_JS_FORMATT, mInjectName, mIndex, mPermanent, sb.toString());
        mWebView.get().loadUrl(executeJs);
        isCanGoOn = mPermanent > 0;
    }

    public void setmPermanent(boolean value) {
        mPermanent = value ? 1 : 0;
    }

    public class JsCallbackException extends Throwable {
        public JsCallbackException(String s) {
            super(s);
        }
    }
}