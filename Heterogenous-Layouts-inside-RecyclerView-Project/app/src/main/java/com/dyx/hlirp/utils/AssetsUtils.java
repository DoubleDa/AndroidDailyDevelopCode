package com.dyx.hlirp.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;

import org.apache.http.util.EncodingUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * project name：Heterogenous-Layouts-inside-RecyclerView-Project
 * class describe：
 * create person：dayongxin
 * create time：16/7/18 下午9:51
 * alter person：dayongxin
 * alter time：16/7/18 下午9:51
 * alter remark：
 */
public class AssetsUtils {
    /**
     * 从assets 文件夹中读取文本数据
     *
     * @param context
     * @param fileName
     * @return
     */
    public static String getTextFromAssets(final Context context, String fileName) {
        String result = "";
        try {
            InputStream in = context.getResources().getAssets().open(fileName);
            // 获取文件的字节数
            int lenght = in.available();
            // 创建byte数组
            byte[] buffer = new byte[lenght];
            // 将文件中的数据读到byte数组中
            in.read(buffer);
            result = EncodingUtils.getString(buffer, "UTF-8");
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 从assets 文件夹中读取图片
     *
     * @param ctx
     * @param fileName
     * @return
     */
    public static Drawable loadImageFromAsserts(final Context ctx, String fileName) {
        try {
            InputStream is = ctx.getResources().getAssets().open(fileName);
            return Drawable.createFromStream(is, null);
        } catch (IOException e) {
            if (e != null) {
                e.printStackTrace();
            }
        } catch (OutOfMemoryError e) {
            if (e != null) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            if (e != null) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
