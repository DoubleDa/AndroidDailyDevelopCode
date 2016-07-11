package com.dyx.cl.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;

import java.security.MessageDigest;
import java.util.Random;

/**
 * project name：Chulaihai-Sample
 * class describe：
 * create person：dayongxin
 * create time：16/6/27 下午5:29
 * alter person：dayongxin
 * alter time：16/6/27 下午5:29
 * alter remark：
 */
public class AppUtil {
    /**
     * @param plainText
     * @return
     */
    public static String getMd5Str(String plainText) {
        String re_md5 = new String();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[] = md.digest();

            int i;

            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }

            re_md5 = buf.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return re_md5.toUpperCase();
    }

    public static String getDeviceId(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append("a");

        /**
         * 1.wifi mac地址
         */
        WifiManager wm = (WifiManager) context
                .getSystemService(Context.WIFI_SERVICE);
        WifiInfo wi = wm.getConnectionInfo();
        String wifiMac = wi.getMacAddress();
        boolean resultWifiMac = wifiMac.isEmpty();
        if (!resultWifiMac) {
            sb.append("wifi");
            sb.append(wifiMac);
            return sb.toString();
        }

        /**
         * IMEI（imei）
         */
        TelephonyManager tm = (TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE);
        String imei = tm.getDeviceId();
        boolean resultImei = imei.isEmpty();
        if (!resultImei) {
            sb.append("imei");
            sb.append(imei);
            return sb.toString();
        }

        /**
         * 序列号（sn）
         */
        String sn = tm.getSimSerialNumber();
        boolean resultSn = sn.isEmpty();
        if (!resultSn) {
            sb.append("sn");
            sb.append(sn);
            return sb.toString();
        }

        /**
         * 生成随机码
         */
        String uuid = getUUID(context);
        boolean resultUuid = uuid.isEmpty();
        if (!resultUuid) {
            sb.append("uuid");
            sb.append(uuid);
            return sb.toString();
        }
        return sb.toString();
    }

    public static String getUUID(Context context) {
        SharedPreferences sp = context.getSharedPreferences("uuid",
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("my_uuid", getRandomString());
        editor.apply();
        return sp.getString("my_uuid", null);
    }

    public static String getRandomString() {
        int strLen = 15;
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < strLen; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    public static String getdeviceVersion() {
        String sysVer = android.os.Build.VERSION.RELEASE;
        return "Android" + sysVer;
    }

    public static long randomID() {
        return -System.currentTimeMillis() + 10;
    }

    public static boolean isRandomID(long id) {
        return id < 0;
    }
}
