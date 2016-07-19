package com.dyx.hlirp;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dyx.hlirp.adapter.MyNeedAdapter;
import com.dyx.hlirp.model.DataModel;
import com.dyx.hlirp.utils.AssetsUtils;
import com.dyx.hlirp.utils.JsonHelper;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * project name：Heterogenous-Layouts-inside-RecyclerView-Project
 * class describe：
 * create person：dayongxin
 * create time：16/7/19 下午2:31
 * alter person：dayongxin
 * alter time：16/7/19 下午2:31
 * alter remark：
 */
public class MyNeedViewAct extends Activity {
    @Bind(R.id.rv_my_need)
    RecyclerView rvMyNeed;
    private MyNeedAdapter mMyNeedAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_my_need_view_layout);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initView() {
        rvMyNeed.setLayoutManager(new LinearLayoutManager(this));
        rvMyNeed.setHasFixedSize(true);
    }

    private void initData() {
        try {
            String jsonData = new String(AssetsUtils.InputStreamToByte(getClass().getResourceAsStream("/assets/data.json")));
            DataModel dataModel = JsonHelper.fromJson(jsonData, DataModel.class);
            DataModel.DataEntity dataEntity = dataModel.getData();
            mMyNeedAdapter = new MyNeedAdapter(this, dataEntity.getActs());
            rvMyNeed.setAdapter(mMyNeedAdapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
