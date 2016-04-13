package com.dyx.sbcd.view;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.dyx.sbcd.listener.KeyboardStateListener;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-04-13
 * Time      : 15:31
 * Summary   :
 * Copyright : Copyright (c) 2016
 */
public class SoftKeyboardView extends LinearLayout {
    public final static int KEYBOARD_HIDE = 0;
    public final static int KEYBOARD_SHOW = 1;
    public final static int KEYBOARD_MIN_HEIGHT = 72;
    private Handler mHandler = new Handler();
    private KeyboardStateListener mKeyboardStateListener;

    public void setKeyboardStateListener(KeyboardStateListener mKeyboardStateListener) {
        this.mKeyboardStateListener = mKeyboardStateListener;
    }

    public SoftKeyboardView(Context context) {
        super(context);
    }

    public SoftKeyboardView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * @param w    当前w
     * @param h    当前h
     * @param oldw 原来w
     * @param oldh 原来h
     */
    @Override
    protected void onSizeChanged(int w, final int h, int oldw, final int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                if (oldh - h > KEYBOARD_MIN_HEIGHT) {
                    mKeyboardStateListener.stateChange(KEYBOARD_SHOW);
                } else {
                    if (mKeyboardStateListener != null) {
                        mKeyboardStateListener.stateChange(KEYBOARD_HIDE);
                    }
                }
            }
        });
    }
}