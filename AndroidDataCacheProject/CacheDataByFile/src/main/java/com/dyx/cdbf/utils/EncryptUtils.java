package com.dyx.cdbf.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-04-14
 * Time      : 14:45
 * Summary   :
 * Copyright : Copyright (c) 2016
 */
public class EncryptUtils {
    /**
     * MD5
     *
     * @param str
     * @return
     */
    public static String encryptToMD5(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = md.digest(str.getBytes());
            StringBuffer sb = new StringBuffer();
            for (byte b : bytes) {
                int num = b & 0xff;
                String nums = Integer.toHexString(num);
                if (nums.length() == 1) {
                    sb.append("0");
                }
                sb.append(nums);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }

    }
}