package com.dyx.jpt.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.dyx.jpt.MainActivity;
import com.dyx.jpt.ui.NotificationAct;
import com.dyx.jpt.utils.ExampleUtil;

import org.json.JSONException;
import org.json.JSONObject;

import cn.jpush.android.api.JPushInterface;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-04-13
 * Time      : 17:14
 * Summary   : 自定义接收器(如果不定义这个 Receiver，则：1、默认用户会打开主界面；2、接收不到自定义消息)
 * Copyright : Copyright (c) 2016
 */
public class MyJPushReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        if (JPushInterface.ACTION_REGISTRATION_ID.equals(intent.getAction())) {
            //接收Registration Id
            String registrationId = bundle.getString(JPushInterface.EXTRA_REGISTRATION_ID);
        } else if (JPushInterface.ACTION_MESSAGE_RECEIVED.equals(intent.getAction())) {
            //接收到推送下来的自定义消息
            String msg = bundle.getString(JPushInterface.EXTRA_MESSAGE);
            processCustomMessage(context, bundle);
        } else if (JPushInterface.ACTION_NOTIFICATION_RECEIVED.equals(intent.getAction())) {
            //接收到推送下来的通知
            int notificationId = bundle.getInt(JPushInterface.EXTRA_NOTIFICATION_ID);
        } else if (JPushInterface.ACTION_NOTIFICATION_OPENED.equals(intent.getAction())) {
            //用户点击打开了通知
            Intent i = new Intent(context, NotificationAct.class);
            i.putExtras(bundle);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            context.startActivity(i);
        } else if (JPushInterface.ACTION_RICHPUSH_CALLBACK.equals(intent.getAction())) {
            //用户收到到RICH PUSH CALLBACK
            String richStr = bundle.getString(JPushInterface.EXTRA_EXTRA);
        } else if (JPushInterface.ACTION_CONNECTION_CHANGE.equals(intent.getAction())) {
            //连接渠道状态
            boolean connected = intent.getBooleanExtra(JPushInterface.EXTRA_CONNECTION_CHANGE, false);
        } else {
            //Unhandled intent
        }
    }

    /**
     * 发送消息到MainActivity
     *
     * @param context
     * @param bundle
     */
    private void processCustomMessage(Context context, Bundle bundle) {
        if (MainActivity.isForeground) {
            String msg = bundle.getString(JPushInterface.EXTRA_MESSAGE);
            String extras = bundle.getString(JPushInterface.EXTRA_EXTRA);
            Intent i = new Intent(MainActivity.MEDIA_SESSION_SERVICE);
            i.putExtra(MainActivity.KEY_MESSAGE, msg);
            if (!ExampleUtil.isEmpty(extras)) {
                try {
                    JSONObject object = new JSONObject(extras);
                    if (null != object && object.length() > 0) {
                        i.putExtra(MainActivity.KEY_EXTRAS, extras);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            context.sendBroadcast(i);
        }
    }
}