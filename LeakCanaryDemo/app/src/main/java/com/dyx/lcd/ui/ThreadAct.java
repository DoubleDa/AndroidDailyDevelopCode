package com.dyx.lcd.ui;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import com.dyx.lcd.R;
import com.orhanobut.logger.Logger;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * project name：LeakCanaryDemo
 * class describe：
 * create person：dayongxin
 * create time：2016/11/1 上午11:44
 * alter person：dayongxin
 * alter time：2016/11/1 上午11:44
 * alter remark：
 */
public class ThreadAct extends Activity {
    @BindView(R.id.tv_msg)
    TextView tvMsg;
    //后台任务处理
    private AsyncTask<Void, Void, Integer> mAsyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);
        ButterKnife.bind(this);
        initAsyncTask();
    }

    private void initAsyncTask() {
        mAsyncTask = new AsyncTask<Void, Void, Integer>() {
            @Override
            protected Integer doInBackground(Void... voids) {
                int i = 0;
                while (!isCancelled()) {
                    i++;
                    if (i > 10000000) {
                        break;
                    }
                    Logger.d(i);
                }
                return i;
            }

            @Override
            protected void onPostExecute(Integer integer) {
                super.onPostExecute(integer);
                tvMsg.setText(String.valueOf(integer));
            }
        };
        mAsyncTask.execute();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mAsyncTask!=null&&!mAsyncTask.isCancelled()){
            mAsyncTask.cancel(true);
        }
        mAsyncTask=null;
    }
}
