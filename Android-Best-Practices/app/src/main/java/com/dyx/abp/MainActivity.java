package com.dyx.abp;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.dyx.abp.adapter.ItemListAdapter;
import com.dyx.abp.base.BaseActivity;
import com.dyx.abp.ui.OkhttpAct;
import com.dyx.abp.ui.VolleyAct;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @Bind(R.id.rv_list)
    RecyclerView rvList;
    private List<String> items;
    private ItemListAdapter mItemListAdapter;

    @Override
    protected void initView() {
        rvList.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void initParam() {
        items = new ArrayList<String>();
    }

    @Override
    protected void initData() {
        items.add("1、使用okhttp网络请求框架");
        items.add("2、使用Volley网络请求框架");
        mItemListAdapter = new ItemListAdapter(this, items);
        rvList.setAdapter(mItemListAdapter);
        mItemListAdapter.setmOnItemListener(new ItemListAdapter.OnItemListener() {
            @Override
            public void onItemClick(View view, int position) {
                switch (position) {
                    case 0:
                        intentTo(MainActivity.this, OkhttpAct.class);
                        break;
                    case 1:
                        intentTo(MainActivity.this, VolleyAct.class);
                        break;
                    default:
                        break;
                }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
}
