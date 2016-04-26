package com.dyx.rap.ui;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

import com.dyx.rap.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-04-26
 * Time      : 17:01
 * Summary   :
 * Copyright : Copyright (c) 2016
 */
public class NetworkDetailActivity extends Activity {
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_author)
    TextView tvAuthor;
    @Bind(R.id.wv_content)
    WebView wvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_network_detail_layout);
        ButterKnife.bind(this);
    }
}