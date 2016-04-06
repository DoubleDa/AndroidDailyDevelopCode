package com.dyx.mp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dyx.mp.R;
import com.dyx.mp.bean.MainItemBean;

import java.util.List;

/**
 * Created by Da on 2016/4/5.
 */
public class MainPageAdapter extends RecyclerView.Adapter<MainPageAdapter.MainPageVH> {
    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private List<MainItemBean> mList;
    private OnMyItemClickLitener mOnMyItemClickLitener;

    public interface OnMyItemClickLitener {
        void onMyItemClick(View view, int position);
    }

    public void setmOnMyItemClickLitener(OnMyItemClickLitener mOnMyItemClickLitener) {
        this.mOnMyItemClickLitener = mOnMyItemClickLitener;
    }

    public MainPageAdapter(Context mContext, List<MainItemBean> mList) {
        this.mContext = mContext;
        this.mList = mList;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public MainPageVH onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MainPageVH(mLayoutInflater.inflate(R.layout.adapter_main_page_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(final MainPageVH holder, int position) {
        holder.mTv_item_name.setText(mList.get(position).itemName);

        if(mOnMyItemClickLitener!=null){
            holder.mTv_item_name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos=holder.getLayoutPosition();
                    mOnMyItemClickLitener.onMyItemClick(v,pos);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    public static class MainPageVH extends RecyclerView.ViewHolder {
        TextView mTv_item_name;

        public MainPageVH(View itemView) {
            super(itemView);
            mTv_item_name = (TextView) itemView.findViewById(R.id.tv_item_name);
        }
    }
}
