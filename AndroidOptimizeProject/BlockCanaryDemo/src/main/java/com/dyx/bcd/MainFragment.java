package com.dyx.bcd;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.io.FileInputStream;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-04-12
 * Time      : 11:42
 * Summary   :
 * Copyright : Copyright (c) 2016
 */
public class MainFragment extends Fragment {
    @Bind(R.id.but1)
    Button but1;
    @Bind(R.id.but2)
    Button but2;
    @Bind(R.id.but3)
    Button but3;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.but1, R.id.but2, R.id.but3})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.but1:
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.but2:
                for (int i = 0; i < 100; ++i) {
                    readFile();
                }
                break;
            case R.id.but3:
                Toast.makeText(getActivity(), count() + "", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private double count() {
        double result = 0;
        for (int i = 0; i < 100000; i++) {
            result += Math.asin(i);
        }
        return result;
    }

    private void readFile() {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("/proc/stat");
            while (fis.read() != -1) ;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}