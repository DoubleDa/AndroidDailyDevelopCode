package com.dyx.ml.utils;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * project name：CodePathDemo
 * class describe：
 * create person：dayongxin
 * create time：16/6/8 下午4:43
 * alter person：dayongxin
 * alter time：16/6/8 下午4:43
 * alter remark：
 */
public class ToastUtil {
    private static Toast toast = null;
    private static Toast currentToast;
    private static View toastView;

    /**
     * 显示图片的Toast
     *
     * @param context
     * @param imgResId
     * @param charSequence
     */
    public static void imageToast(Context context, int imgResId, CharSequence charSequence) {
        // 创建一个Toast提示消息
        toast = Toast.makeText(context, charSequence, Toast.LENGTH_SHORT);
        // 设置Toast提示消息在屏幕上的位置
        toast.setGravity(Gravity.CENTER, 0, 0);
        // 获取Toast提示消息里原有的View
        View view = toast.getView();
        // 创建一个ImageView
        ImageView imageView = new ImageView(context);
        // 为ImageView设置图片
        imageView.setImageResource(imgResId);
        // 创建一个ViewGroup容器
        LinearLayout ll = new LinearLayout(context);
        // 向LinearLayout中添加ImageView和Toast原有的View
        ll.addView(imageView);
        ll.addView(view);
        // 将LineLayout容器设置为toast的View
        toast.setView(ll);
        // 显示消息
        toast.show();
    }

    /**
     * 显示文字的Toast
     *
     * @param context
     * @param
     * @return
     */
    public static Toast textToast(Context context, CharSequence text) {
        if (currentToast == null) {
            currentToast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
            toastView = currentToast.getView();
        }
        if (toastView != null) {
            currentToast.setView(toastView);
            currentToast.setText(text);
            currentToast.setDuration(Toast.LENGTH_SHORT);
        }
        return currentToast;
    }
}
