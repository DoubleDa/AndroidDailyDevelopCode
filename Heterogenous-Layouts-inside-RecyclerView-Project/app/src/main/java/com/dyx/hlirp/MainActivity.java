package com.dyx.hlirp;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.dyx.hlirp.adapter.DataAdapter;
import com.dyx.hlirp.constants.Constants;
import com.dyx.hlirp.model.DataModel;
import com.dyx.hlirp.model.Template1;
import com.dyx.hlirp.model.Template2;
import com.dyx.hlirp.model.Template3;
import com.dyx.hlirp.utils.AssetsUtils;
import com.dyx.hlirp.utils.JsonHelper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends Activity {

    @Bind(R.id.rv)
    RecyclerView rv;
    private DataAdapter mDataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        initData();

    }

    private void initView() {
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setHasFixedSize(true);
    }

    private void initData() {
        mDataAdapter = new DataAdapter(this, getHybridListData());
        rv.setAdapter(mDataAdapter);
    }

    private List<Object> getHybridListData() {
        List<Object> objectList = new ArrayList<>();
        objectList.add(new Template1(Constants.IMG_URL_TEMPLATE1));
        objectList.add(new Template2(Constants.IMG_URL_TEMPLATE2, Constants.IMG_TITLE));
        objectList.add(new Template3(Constants.IMG_URL_TEMPLATE3, Constants.IMG_TITLE, Constants.GOODS_DESCRIPTION, Constants.GOODS_MY_PRICE, Constants.GOODS_MARKET_PRICE));
        objectList.add(new Template1(Constants.IMG_URL_TEMPLATE1));
        objectList.add(new Template3(Constants.IMG_URL_TEMPLATE3, Constants.IMG_TITLE, Constants.GOODS_DESCRIPTION, Constants.GOODS_MY_PRICE, Constants.GOODS_MARKET_PRICE));
        objectList.add(new Template2(Constants.IMG_URL_TEMPLATE2, Constants.IMG_TITLE));
        objectList.add(new Template2(Constants.IMG_URL_TEMPLATE2, Constants.IMG_TITLE));
        objectList.add(new Template1(Constants.IMG_URL_TEMPLATE1));
        objectList.add(new Template3(Constants.IMG_URL_TEMPLATE3, Constants.IMG_TITLE, Constants.GOODS_DESCRIPTION, Constants.GOODS_MY_PRICE, Constants.GOODS_MARKET_PRICE));
        objectList.add(new Template2(Constants.IMG_URL_TEMPLATE2, Constants.IMG_TITLE));
        objectList.add(new Template3(Constants.IMG_URL_TEMPLATE3, Constants.IMG_TITLE, Constants.GOODS_DESCRIPTION, Constants.GOODS_MY_PRICE, Constants.GOODS_MARKET_PRICE));
        objectList.add(new Template1(Constants.IMG_URL_TEMPLATE1));
        objectList.add(new Template3(Constants.IMG_URL_TEMPLATE3, Constants.IMG_TITLE, Constants.GOODS_DESCRIPTION, Constants.GOODS_MY_PRICE, Constants.GOODS_MARKET_PRICE));
        objectList.add(new Template1(Constants.IMG_URL_TEMPLATE1));
        objectList.add(new Template2(Constants.IMG_URL_TEMPLATE2, Constants.IMG_TITLE));
        objectList.add(new Template3(Constants.IMG_URL_TEMPLATE3, Constants.IMG_TITLE, Constants.GOODS_DESCRIPTION, Constants.GOODS_MY_PRICE, Constants.GOODS_MARKET_PRICE));
        objectList.add(new Template2(Constants.IMG_URL_TEMPLATE2, Constants.IMG_TITLE));
        objectList.add(new Template1(Constants.IMG_URL_TEMPLATE1));
        return objectList;
    }


}
