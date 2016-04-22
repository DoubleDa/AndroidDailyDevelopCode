package com.dyx.abp.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dyx.abp.R;
import com.dyx.abp.entity.ImageUrl;
import com.dyx.abp.entity.Person;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import it.sephiroth.android.library.picasso.Picasso;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-04-22
 * Time      : 15:40
 * Summary   :
 * Copyright : Copyright (c) 2016
 */
public class PicassoAdapter extends ArrayAdapter<ImageUrl> {
    private Context mContext;

    public PicassoAdapter(Context context, int resource, List<ImageUrl> objects) {
        super(context, R.layout.lv_item_picasso_layout, objects);
        this.mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = new View(mContext);
        }
        ImageUrl url = getItem(position);
        Picasso.with(mContext).load(url.getUrl()).into((ImageView) view);
        return super.getView(position, convertView, parent);
    }


    public static class ViewHolder {
        @Bind(R.id.iv_Picasso)
        ImageView ivPicasso;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}