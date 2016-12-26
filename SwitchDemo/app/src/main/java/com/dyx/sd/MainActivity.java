package com.dyx.sd;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private RecyclerView mRecyclerView;
    private MainAdapter mMainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_main);
        //
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL_LIST));
        mMainAdapter = new MainAdapter(getDatas(), this);
        mRecyclerView.setAdapter(mMainAdapter);
    }

    private List<MainModel> getDatas() {
        List<MainModel> results = new ArrayList<>();
        results.add(new MainModel("A", 0));
        results.add(new MainModel("B", 1));
        results.add(new MainModel("C", 0));
        results.add(new MainModel("D", 1));
        results.add(new MainModel("E", 0));
        results.add(new MainModel("F", 0));
        results.add(new MainModel("哈", 1));
        results.add(new MainModel("呵呵", 0));
        results.add(new MainModel("呵呵", 1));
        results.add(new MainModel("呵呵", 0));
        results.add(new MainModel("呵呵", 1));
        results.add(new MainModel("A", 0));
        results.add(new MainModel("B", 1));
        results.add(new MainModel("C", 0));
        results.add(new MainModel("D", 1));
        results.add(new MainModel("E", 0));
        results.add(new MainModel("F", 0));
        results.add(new MainModel("哈", 1));
        results.add(new MainModel("呵呵", 0));
        results.add(new MainModel("呵呵", 1));
        results.add(new MainModel("呵呵", 0));
        results.add(new MainModel("呵呵", 1));
        return results;
    }
}
