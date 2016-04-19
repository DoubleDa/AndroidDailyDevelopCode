package com.dyx.abp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dyx.abp.R;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-04-19
 * Time      : 16:57
 * Summary   :
 * Copyright : Copyright (c) 2016
 */
public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ItemListAdapterViewHolder> {
    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private List<String> lists;
    public OnItemListener mOnItemListener;

    public interface OnItemListener {
        void onItemClick(View view, int position);
    }


    public void setmOnItemListener(OnItemListener mOnItemListener) {
        this.mOnItemListener = mOnItemListener;
    }

    public ItemListAdapter(Context mContext, List<String> lists) {
        this.mContext = mContext;
        this.lists = lists;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public ItemListAdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ItemListAdapterViewHolder(mLayoutInflater.inflate(R.layout.rv_item_layout, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(final ItemListAdapterViewHolder itemListAdapterViewHolder, int i) {
        //填充数据
        itemListAdapterViewHolder.itemStr.setText(lists.get(i));
        //添加点击事件
        if (mOnItemListener != null) {
            itemListAdapterViewHolder.itemStr.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = itemListAdapterViewHolder.getLayoutPosition();
                    mOnItemListener.onItemClick(v, position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return lists == null ? 0 : lists.size();
    }

    public static class ItemListAdapterViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.item_str)
        TextView itemStr;

        public ItemListAdapterViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}