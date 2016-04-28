package com.dyx.bkbp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dyx.bkbp.R;
import com.dyx.bkbp.entity.TestEntity;

import java.util.List;

import butterknife.Bind;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-04-28
 * Time      : 17:25
 * Summary   :
 * Copyright : Copyright (c) 2016
 */
public class TestAdapter extends RecyclerView.Adapter<TestAdapter.TestViewHolder> {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<TestEntity> mList;

    public TestAdapter(List<TestEntity> mList, LayoutInflater mLayoutInflater, Context mContext) {
        this.mList = mList;
        this.mLayoutInflater = mLayoutInflater;
        this.mContext = mContext;
    }

    @Override
    public TestViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TestViewHolder(mLayoutInflater.inflate(R.layout.content_main, parent, false));
    }

    @Override
    public void onBindViewHolder(TestViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class TestViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.tv_name)
        TextView tvName;
        @Bind(R.id.tv_age)
        TextView tvAge;

        public TestViewHolder(View itemView) {
            super(itemView);
        }
    }
}