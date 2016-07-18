package com.dyx.hlirp;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.dyx.hlirp.adapter.DataAdapter;
import com.dyx.hlirp.model.DataModel;
import com.dyx.hlirp.utils.AssetsUtils;
import com.dyx.hlirp.utils.JsonHelper;

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
        String jsonData = AssetsUtils.getTextFromAssets(this, "file:///android_asset/data.json");
        try {
            DataModel dataModel = JsonHelper.fromJson(jsonData, DataModel.class);
            List<DataModel.DataEntity> dataEntities = dataModel.getData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
