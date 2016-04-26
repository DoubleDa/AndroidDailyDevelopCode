package com.dyx.rap.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.dyx.rap.entity.TopicEntity;

import java.util.List;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-04-26
 * Time      : 16:55
 * Summary   :
 * Copyright : Copyright (c) 2016
 */
public class TopicsAdapter extends RecyclerView.Adapter {
    public TopicsAdapter(List<TopicEntity.DataBean> lists) {
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}