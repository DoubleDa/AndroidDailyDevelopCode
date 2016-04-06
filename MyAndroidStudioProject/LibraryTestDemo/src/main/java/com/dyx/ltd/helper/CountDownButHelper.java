package com.dyx.ltd.helper;

import android.os.CountDownTimer;
import android.widget.Button;

/**
 * Created by Da on 2016/3/30.
 * count down button helper
 */
public class CountDownButHelper {
    private CountDownTimer mCountDownTimer;
    private OnFinishCountListener mOnFinishCountListener;
    private Button mButton;

    public CountDownButHelper(final Button mButton, final String defaultStr, int maxTime, int intervalTime) {
        this.mButton = mButton;
        mCountDownTimer = new CountDownTimer(maxTime * 1000, intervalTime * 1000 - 10) {
            @Override
            public void onTick(long millisUntilFinished) {
                mButton.setText(defaultStr + "（" + (millisUntilFinished + 15) / 1000 + "秒)");
            }

            @Override
            public void onFinish() {
                mButton.setEnabled(true);
                mButton.setText(defaultStr);
                if (mOnFinishCountListener != null) {
                    mOnFinishCountListener.onFinish();
                }
            }
        };
    }

    public void start() {
        mButton.setEnabled(false);
        mCountDownTimer.start();
    }

    public void setmOnFinishCountListener(OnFinishCountListener mOnFinishCountListener) {
        this.mOnFinishCountListener = mOnFinishCountListener;
    }

    public interface OnFinishCountListener {
        public void onFinish();
    }
}
