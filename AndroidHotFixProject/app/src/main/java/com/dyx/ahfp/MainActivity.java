package com.dyx.ahfp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.dyx.ahfp.utils.BugUtils;
import com.dyx.ahfp.utils.Utils;
import com.dyx.hl.HotFix;

import java.io.File;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-04-06
 * Time      : 15:41
 * Summary   : 实现Android热修复技术
 * Copyright : Copyright (c) 2016
 */
public class MainActivity extends Activity implements View.OnClickListener {
    public final static String HOT_FIX_FILE_NAME = "toast_dex.jar";
    public final static String HOT_FIX_CLASS_NAME = "com.dyx.ahfp.utils.BugUtils";
    private Button mBut_show;
    private Button mBut_fix;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        mBut_show.setOnClickListener(this);
        mBut_fix.setOnClickListener(this);
    }

    private void initView() {
        mBut_show = (Button) findViewById(R.id.but_show);
        mBut_fix = (Button) findViewById(R.id.but_fix);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.but_show:
                Toast.makeText(MainActivity.this, BugUtils.getShowInfo(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.but_fix:
                //TODO 方式2：手动进行bug热修复（本工程内）
                doHotFixTask();
                break;
            default:
                break;
        }
    }

    /**
     * 进行热修复任务
     */
    private void doHotFixTask() {
        File dexPath = new File(getDir("dex", Context.MODE_PRIVATE), HOT_FIX_FILE_NAME);
        Utils.prepareDex(this, dexPath, HOT_FIX_FILE_NAME);
        //待修复的class
        HotFix.patch(this, dexPath.getAbsolutePath(), HOT_FIX_CLASS_NAME);
    }
}