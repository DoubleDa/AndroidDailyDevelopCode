package com.dyx.hlirp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dyx.hlirp.R;
import com.dyx.hlirp.constants.Constants;
import com.dyx.hlirp.model.Template1;
import com.dyx.hlirp.model.Template2;
import com.dyx.hlirp.model.Template3;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
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
    public Context mContext;
    private List<Object> mDataLists;
    private final int TEMPLATEFIRST = 1, TEMPLATESCOND = 2, TEMPLATETHRID = 3;

    public DataAdapter(Context mContext, List<Object> mDataLists) {
        this.mContext = mContext;
        this.mDataLists = mDataLists;
    }

    @Override
    public int getItemViewType(int position) {
        if (mDataLists.get(position) instanceof Template1) {
            return TEMPLATEFIRST;
        } else if (mDataLists.get(position) instanceof Template2) {
            return TEMPLATESCOND;
        } else if (mDataLists.get(position) instanceof Template3) {
            return TEMPLATETHRID;
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
                ViewHolderThrid vh3 = (ViewHolderThrid) holder;
                configureVh3(vh3, position);
                break;
            default:
                break;
        }
    }

    private void configureVh3(ViewHolderThrid vh3, int position) {
        Template3 template3 = (Template3) mDataLists.get(position);
        if (template3 != null) {
            vh3.mTv_title_template3.setText(template3.getImgTitle());
            vh3.mTv_description_template3.setText(template3.getGoodsDescription());
            vh3.mTv_my_price_template3.setText(template3.getGoodsMyPrice());
            vh3.mTv_market_price_template3.setText(template3.getGoodsMarketPrice());
            Picasso.with(mContext).load(template3.getImgUrl()).into(vh3.mIv_template3);
        }
    }

    private void configureVh2(ViewHolderSecond vh2, int position) {
        Template2 template2 = (Template2) mDataLists.get(position);
        if (template2 != null) {
            vh2.mTv_template2.setText(template2.getImgTitle());
            Picasso.with(mContext).load(template2.getImgUrl()).into(vh2.mIv_template2);
        }
    }

    private void configureVh1(ViewHolderFirst vh1, int position) {
        Template1 template1 = (Template1) mDataLists.get(position);
        if (template1 != null) {
            Picasso.with(mContext).load(template1.getImgUrl()).into(vh1.mIv_template1);
        }
    }

    @Override
    public int getItemCount() {
        return mDataLists.size();
    }


    /**
     * 模板一
     */
    public static class ViewHolderFirst extends RecyclerView.ViewHolder {
        ImageView mIv_template1;

        public ViewHolderFirst(View itemView) {
            super(itemView);
            mIv_template1 = (ImageView) itemView.findViewById(R.id.iv_template1);
        }

    }

    /**
     * 模板二
     */
    public static class ViewHolderSecond extends RecyclerView.ViewHolder {
        ImageView mIv_template2;
        TextView mTv_template2;

        public ViewHolderSecond(View itemView) {
            super(itemView);
            mIv_template2 = (ImageView) itemView.findViewById(R.id.iv_template2);
            mTv_template2 = (TextView) itemView.findViewById(R.id.tv_template2);
        }
    }

    /**
     * 模板三
     */
    public static class ViewHolderThrid extends RecyclerView.ViewHolder {
        TextView mTv_title_template3;
        TextView mTv_description_template3;
        TextView mTv_my_price_template3;
        TextView mTv_market_price_template3;
        ImageView mIv_template3;

        public ViewHolderThrid(View itemView) {
            super(itemView);
            mTv_title_template3 = (TextView) itemView.findViewById(R.id.tv_title_template3);
            mTv_description_template3 = (TextView) itemView.findViewById(R.id.tv_description_template3);
            mTv_my_price_template3 = (TextView) itemView.findViewById(R.id.tv_my_price_template3);
            mTv_market_price_template3 = (TextView) itemView.findViewById(R.id.tv_market_price_template3);
            mIv_template3 = (ImageView) itemView.findViewById(R.id.iv_template3);
        }
    }


}
