package com.dyx.sd;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import java.util.List;

/**
 * project name：SwitchDemo
 * class describe：
 * create person：dayongxin
 * create time：2016/12/26 下午4:32
 * alter person：dayongxin
 * alter time：2016/12/26 下午4:32
 * alter remark：
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    private List<MainModel> mDatas;
    private Context mContext;

    public MainAdapter(List<MainModel> mDatas, Context mContext) {
        this.mDatas = mDatas;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.mTv_name.setText(mDatas.get(position).getName());
        holder.mS_main.setTag(mDatas.get(position));
        if (mDatas.get(position).getTag() == 0) {
            holder.mS_main.setChecked(false);
        } else if (mDatas.get(position).getTag() == 1) {
            holder.mS_main.setChecked(true);
        }

        holder.mS_main.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                MainModel mMainModel = (MainModel) compoundButton.getTag();
                if (b && mMainModel.getTag() == 0) {
                    mMainModel.setTag(1);
                    //
                    Log.i("TAG", "点击了");
                } else if (!b && mMainModel.getTag() == 1) {
                    mMainModel.setTag(0);
                    //
                    Log.i("TAG", "取消了");
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTv_name;
        Switch mS_main;

        public ViewHolder(View itemView) {
            super(itemView);
            mTv_name = (TextView) itemView.findViewById(R.id.tv_name);
            mS_main = (Switch) itemView.findViewById(R.id.s_main);
        }
    }
}
