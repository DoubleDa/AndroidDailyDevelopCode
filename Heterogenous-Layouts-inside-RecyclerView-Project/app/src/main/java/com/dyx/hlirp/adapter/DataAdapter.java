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

import butterknife.Bind;
import butterknife.OnClick;

/**
 * project name：Heterogenous-Layouts-inside-RecyclerView-Project
 * class describe：
 * create person：dayongxin
 * create time：16/7/18 下午9:43
 * alter person：dayongxin
 * alter time：16/7/18 下午9:43
 * alter remark：
 */
public class DataAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private List<DataModel.DataEntity> mDataLists;
    private final int TEMPLATEFIRST = 1, TEMPLATESCOND = 2, TEMPLATETHRID = 3, TEMPLATEFOUTH = 4;

    public DataAdapter(Context mContext, List<DataModel.DataEntity> mDataLists) {
        this.mContext = mContext;
        this.mDataLists = mDataLists;
    }

    @Override
    public int getItemViewType(int position) {
        int type = mDataLists.get(position).getTemplateType();
        if (type == TEMPLATEFIRST) {
            return TEMPLATEFIRST;
        } else if (type == TEMPLATESCOND) {
            return TEMPLATESCOND;
        } else if (type == TEMPLATETHRID) {
            return TEMPLATETHRID;
        } else if (type == TEMPLATEFOUTH) {
            return TEMPLATEFOUTH;
        }
        return 0;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType) {
            case TEMPLATEFIRST:
                View view1 = inflater.inflate(R.layout.template1_layout, parent, false);
                viewHolder = new ViewHolderFirst(view1);
                break;
            case TEMPLATESCOND:
                View view2 = inflater.inflate(R.layout.template2_layout, parent, false);
                viewHolder = new ViewHolderSecond(view2);
                break;
            case TEMPLATETHRID:
                View view3 = inflater.inflate(R.layout.template3_layout, parent, false);
                viewHolder = new ViewHolderThrid(view3);
                break;
            case TEMPLATEFOUTH:
                View view4 = inflater.inflate(R.layout.template4_layout, parent, false);
                viewHolder = new ViewHolderFouth(view4);
                break;
            default:
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case TEMPLATEFIRST:
                ViewHolderFirst vh1 = (ViewHolderFirst) holder;
                configureVh1(vh1, position);
                break;
            case TEMPLATESCOND:
                ViewHolderSecond vh2 = (ViewHolderSecond) holder;
                configureVh2(vh2, position);
                break;
            case TEMPLATETHRID:
                break;
            case TEMPLATEFOUTH:
                break;
            default:
                break;
        }
    }

    private void configureVh2(ViewHolderSecond vh2, int position) {
//        DataModel.DataEntity dataEntity = mDataLists.get(position);
//        Picasso.with(mContext).load(dataEntity.getImgUrl()).into(vh2.ivTemplate2);
//        vh2.tvTemplate2.setText(mDataLists.get(position).);
    }

    private void configureVh1(ViewHolderFirst vh1, int position) {
        DataModel.DataEntity dataEntity = mDataLists.get(position);
        Picasso.with(mContext).load(dataEntity.getImgUrl()).into(vh1.ivTemplate1);
    }

    @Override
    public int getItemCount() {
        return mDataLists.size();
    }


    /**
     * 模板一
     */
    public static class ViewHolderFirst extends RecyclerView.ViewHolder {
        @Bind(R.id.iv_template1)
        ImageView ivTemplate1;

        @OnClick(R.id.iv_template1)
        public void onClick() {

        }

        public ViewHolderFirst(View itemView) {
            super(itemView);

        }

    }

    /**
     * 模板二
     */
    public static class ViewHolderSecond extends RecyclerView.ViewHolder {
        @Bind(R.id.iv_template2)
        ImageView ivTemplate2;
        @Bind(R.id.tv_template2)
        TextView tvTemplate2;

        public ViewHolderSecond(View itemView) {
            super(itemView);
        }
    }

    /**
     * 模板三
     */
    public static class ViewHolderThrid extends RecyclerView.ViewHolder {
        @Bind(R.id.tv_title_template3)
        TextView tvTitleTemplate3;
        @Bind(R.id.tv_description_template3)
        TextView tvDescriptionTemplate3;
        @Bind(R.id.tv_my_price_template3)
        TextView tvMyPriceTemplate3;
        @Bind(R.id.tv_market_price_template3)
        TextView tvMarketPriceTemplate3;
        @Bind(R.id.iv_template3)
        ImageView ivTemplate3;

        public ViewHolderThrid(View itemView) {
            super(itemView);
        }
    }

    /**
     * 模板四
     */
    public static class ViewHolderFouth extends RecyclerView.ViewHolder {
        @Bind(R.id.rv_template4)
        RecyclerView rvTemplate4;

        public ViewHolderFouth(View itemView) {
            super(itemView);
        }
    }
}
