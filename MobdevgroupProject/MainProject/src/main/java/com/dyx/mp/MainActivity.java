package com.dyx.mp;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.dyx.mp.adapter.MainPageAdapter;
import com.dyx.mp.base.BaseActivity;
import com.dyx.mp.bean.MainItemBean;
import com.dyx.mp.ui.JavaCallJSAct;
import com.dyx.mp.view.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * 主页
 */
public class MainActivity extends BaseActivity {
    private RecyclerView mRc_main_item;
    private MainPageAdapter mMainPageAdapter;
    private List<MainItemBean> mList;

    @Override
    protected void initData() {
        mList = new ArrayList<MainItemBean>();
        mList.add(new MainItemBean("1、在WebView中如何让JS与Java安全地互相调用"));

        mMainPageAdapter = new MainPageAdapter(MainActivity.this, mList);
        mRc_main_item.setAdapter(mMainPageAdapter);
        mMainPageAdapter.setmOnMyItemClickLitener(new MainPageAdapter.OnMyItemClickLitener() {
            @Override
            public void onMyItemClick(View view, int position) {
                switch (position) {
                    case 0:
                        intentTo(MainActivity.this, JavaCallJSAct.class);
                        break;
                }
            }
        });
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initVariables() {
        mRc_main_item = (RecyclerView) findViewById(R.id.rc_main_item);
        mRc_main_item.setLayoutManager(new LinearLayoutManager(this));
        mRc_main_item.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
    }
}
