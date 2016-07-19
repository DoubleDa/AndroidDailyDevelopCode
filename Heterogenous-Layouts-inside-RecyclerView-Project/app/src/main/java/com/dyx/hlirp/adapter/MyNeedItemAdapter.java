package com.dyx.hlirp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dyx.hlirp.R;
import com.dyx.hlirp.model.DataModel;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * project name：Heterogenous-Layouts-inside-RecyclerView-Project
 * class describe：
 * create person：dayongxin
 * create time：16/7/19 下午3:28
 * alter person：dayongxin
 * alter time：16/7/19 下午3:28
 * alter remark：
 */
public class MyNeedItemAdapter extends RecyclerView.Adapter<MyNeedItemAdapter.ViewHolder> {
    private List<DataModel.DataEntity.ActsEntity.ItemsEntity> itemsEntities;
    private Context mContext;

    public MyNeedItemAdapter(List<DataModel.DataEntity.ActsEntity.ItemsEntity> itemsEntities, Context mContext) {
        this.itemsEntities = itemsEntities;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_need_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        DataModel.DataEntity.ActsEntity.ItemsEntity itemsEntity = itemsEntities.get(position);
        Picasso.with(mContext).load(itemsEntity.getImgUrl()).into(holder.mIv_my_need_item);
        holder.mTv_my_need_item.setText(itemsEntity.getGoodsName());
        holder.mTv_my_need_item_price.setText(itemsEntity.getPrice() + "/");
        holder.mTv_my_need_item_unit.setText(itemsEntity.getUnit());
    }

    @Override
    public int getItemCount() {
        return itemsEntities.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mIv_my_need_item;
        TextView mTv_my_need_item;
        TextView mTv_my_need_item_price;
        TextView mTv_my_need_item_unit;

        public ViewHolder(View itemView) {
            super(itemView);
            mIv_my_need_item = (ImageView) itemView.findViewById(R.id.iv_my_need_item);
            mTv_my_need_item = (TextView) itemView.findViewById(R.id.tv_my_need_item);
            mTv_my_need_item_price = (TextView) itemView.findViewById(R.id.tv_my_need_item_price);
            mTv_my_need_item_unit = (TextView) itemView.findViewById(R.id.tv_my_need_item_unit);
        }
    }
}
