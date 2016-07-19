package com.dyx.hlirp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.dyx.hlirp.R;
import com.dyx.hlirp.model.DataModel;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * project name：Heterogenous-Layouts-inside-RecyclerView-Project
 * class describe：
 * create person：dayongxin
 * create time：16/7/19 下午2:36
 * alter person：dayongxin
 * alter time：16/7/19 下午2:36
 * alter remark：
 */
public class MyNeedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private List<DataModel.DataEntity.ActsEntity> mDataLists;
    private final int TEMPLATE4 = 4, TEMPLATE5 = 5, TEMPLATE6 = 6, TEMPLATE7 = 7;

    public MyNeedAdapter(Context mContext, List<DataModel.DataEntity.ActsEntity> mDataLists) {
        this.mContext = mContext;
        this.mDataLists = mDataLists;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (viewType) {
            case TEMPLATE4:
                View view4 = inflater.inflate(R.layout.template4_layout, parent, false);
                viewHolder = new ViewHolder4(view4);
                break;
            case TEMPLATE5:
                View view5 = inflater.inflate(R.layout.template5_layout, parent, false);
                viewHolder = new ViewHolder5(view5);
                break;
            case TEMPLATE6:
                View view6 = inflater.inflate(R.layout.template6_layout, parent, false);
                viewHolder = new ViewHolder6(view6);
                break;
            case TEMPLATE7:
                View view7 = inflater.inflate(R.layout.template7_layout, parent, false);
                viewHolder = new ViewHolder7(view7);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case TEMPLATE4:
                ViewHolder4 vh4 = (ViewHolder4) holder;
                configureVh4(vh4, position);
                break;
            case TEMPLATE5:
                ViewHolder5 vh5 = (ViewHolder5) holder;
                configureVh5(vh5, position);
                break;
            case TEMPLATE6:
                ViewHolder6 vh6 = (ViewHolder6) holder;
                configureVh6(vh6, position);
                break;
            case TEMPLATE7:
                ViewHolder7 vh7 = (ViewHolder7) holder;
                configureVh7(vh7, position);
                break;
        }
    }

    private void configureVh7(ViewHolder7 vh7, int position) {
        DataModel.DataEntity.ActsEntity actsEntity = mDataLists.get(position);
        if (actsEntity != null) {
            List<DataModel.DataEntity.ActsEntity.ItemsEntity> itemsEntities = actsEntity.getItems();
            vh7.mRv_item.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
            vh7.mRv_item.setHasFixedSize(true);
            MyNeedItemAdapter mMyNeedItemAdapter = new MyNeedItemAdapter(itemsEntities, mContext);
            vh7.mRv_item.setAdapter(mMyNeedItemAdapter);
        }
    }

    private void configureVh6(ViewHolder6 vh6, int position) {
        DataModel.DataEntity.ActsEntity actsEntity = mDataLists.get(position);
        if (actsEntity != null) {
            List<DataModel.DataEntity.ActsEntity.ItemsEntity> itemsEntities = actsEntity.getItems();
            for (DataModel.DataEntity.ActsEntity.ItemsEntity temp : itemsEntities) {
                Picasso.with(mContext).load(temp.getImgUrl()).into(vh6.mIv_template3);
            }
        }
    }

    private void configureVh5(ViewHolder5 vh5, int position) {
        DataModel.DataEntity.ActsEntity actsEntity = mDataLists.get(position);
        if (actsEntity != null) {
            List<DataModel.DataEntity.ActsEntity.ItemsEntity> itemsEntities = actsEntity.getItems();
            for (DataModel.DataEntity.ActsEntity.ItemsEntity temp : itemsEntities) {
                Picasso.with(mContext).load(temp.getImgUrl()).into(vh5.mIv_template2);
            }
        }
    }

    private void configureVh4(ViewHolder4 vh4, int position) {
        DataModel.DataEntity.ActsEntity actsEntity = mDataLists.get(position);
        if (actsEntity != null) {
            List<DataModel.DataEntity.ActsEntity.ItemsEntity> itemsEntities = actsEntity.getItems();
            for (DataModel.DataEntity.ActsEntity.ItemsEntity temp : itemsEntities) {
                Picasso.with(mContext).load(temp.getImgUrl()).into(vh4.mIv_template1);
            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        String strType = mDataLists.get(position).getTemplateType();
        if (strType.equals("4")) {
            return TEMPLATE4;
        } else if (strType.equals("5")) {
            return TEMPLATE5;
        } else if (strType.equals("6")) {
            return TEMPLATE6;
        } else if (strType.equals("7")) {
            return TEMPLATE7;
        }
        return 0;
    }

    @Override
    public int getItemCount() {
        return mDataLists.size();
    }

    public static class ViewHolder4 extends RecyclerView.ViewHolder {
        ImageView mIv_template1;

        public ViewHolder4(View itemView) {
            super(itemView);
            mIv_template1 = (ImageView) itemView.findViewById(R.id.iv_template4);
        }
    }

    public static class ViewHolder5 extends RecyclerView.ViewHolder {
        ImageView mIv_template2;

        public ViewHolder5(View itemView) {
            super(itemView);
            mIv_template2 = (ImageView) itemView.findViewById(R.id.iv_template5);
        }
    }

    public static class ViewHolder6 extends RecyclerView.ViewHolder {
        ImageView mIv_template3;

        public ViewHolder6(View itemView) {
            super(itemView);
            mIv_template3 = (ImageView) itemView.findViewById(R.id.iv_template6);
        }
    }

    public static class ViewHolder7 extends RecyclerView.ViewHolder {
        RecyclerView mRv_item;

        public ViewHolder7(View itemView) {
            super(itemView);
            mRv_item = (RecyclerView) itemView.findViewById(R.id.rv_item);
        }
    }
}
