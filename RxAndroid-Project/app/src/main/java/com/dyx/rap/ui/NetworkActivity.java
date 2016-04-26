package com.dyx.rap.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dyx.rap.R;
import com.dyx.rap.adapter.TopicsAdapter;
import com.dyx.rap.entity.TopicEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-04-26
 * Time      : 14:08
 * Summary   :
 * Copyright : Copyright (c) 2016
 */
public class NetworkActivity extends Activity {
    @Bind(R.id.rv_network)
    RecyclerView rvNetwork;
    private List<TopicEntity.DataBean> lists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_network_layout);
        ButterKnife.bind(this);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvNetwork.setLayoutManager(llm);

        lists = new ArrayList<TopicEntity.DataBean>();
        TopicsAdapter topicsAdapter = new TopicsAdapter(lists);
        rvNetwork.setAdapter(topicsAdapter);
    }
}