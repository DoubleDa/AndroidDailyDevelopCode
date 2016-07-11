package com.dyx.cl.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.dyx.cl.utils.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 * project name：Chulaihai-Sample
 * class describe：应用程序配置类：用于保存用户相关信息及设置
 * create person：dayongxin
 * create time：16/6/27 下午2:25
 * alter person：dayongxin
 * alter time：16/6/27 下午2:25
 * alter remark：
 */
public class AppConfig {
    public static boolean isFinish = true;
    private final static String APP_CONFIG = "config";

    public final static String TEMP_TWEET = "temp_tweet";
    public final static String TEMP_TWEET_IMAGE = "temp_tweet_image";
    public final static String TEMP_MESSAGE = "temp_message";
    public final static String TEMP_COMMENT = "temp_comment";
    public final static String TEMP_POST_TITLE = "temp_post_title";
    public final static String TEMP_POST_CATALOG = "temp_post_catalog";
    public final static String TEMP_POST_CONTENT = "temp_post_content";

    public final static String CONF_APP_UNIQUEID = "APP_UNIQUEID";
    public final static String CONF_COOKIE = "cookie";
    public final static String CONF_ACCESSTOKEN = "accessToken";
    public final static String CONF_ACCESSSECRET = "accessSecret";
    public final static String CONF_EXPIRESIN = "expiresIn";
    public final static String CONF_LOAD_IMAGE = "perf_loadimage";
    public final static String CONF_SCROLL = "perf_scroll";
    public final static String CONF_HTTPS_LOGIN = "perf_httpslogin";
    public final static String CONF_VOICE = "perf_voice";

    private Context mContext;
    private static AppConfig appConfig;

    /**
     * 获取AppConfig实例
     *
     * @param context
     * @return
     */
    public static AppConfig getAppConfig(Context context) {
        if (appConfig == null) {
            appConfig = new AppConfig();
            appConfig.mContext = context;
        }
        return appConfig;
    }

    /**
     * 获取Preference设置
     */
    public static SharedPreferences getSharedPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    /**
     * 是否加载显示图片
     */
    public static boolean isLoadImage(Context context) {
        return getSharedPreferences(context)
                .getBoolean(CONF_LOAD_IMAGE, true);
    }

    /**
     * 获取cookie
     */
    public String getCookie() {
        return get(CONF_COOKIE);
    }

    /**
     * 设置accessToken
     *
     * @param accessToken
     */
    public void setAccessToken(String accessToken) {
        set(CONF_ACCESSTOKEN, accessToken);
    }

    /**
     * 获取AccessToken
     *
     * @return
     */
    public String getAccessToken() {
        return get(CONF_ACCESSTOKEN);
    }

    /**
     * 设置accessSecret
     *
     * @param accessSecret
     */
    public void setAccessSecret(String accessSecret) {
        set(CONF_ACCESSSECRET, accessSecret);
    }

    /**
     * 获取accessSecret
     *
     * @return
     */
    public String getAccessSecret() {
        return get(CONF_ACCESSSECRET);
    }

    /**
     * 设置有效期
     *
     * @param expiresIn
     */
    public void setExpiresIn(long expiresIn) {
        set(CONF_EXPIRESIN, String.valueOf(expiresIn));
    }

    /**
     * 获取有效期
     *
     * @return
     */
    public long getExpiresIn() {
        return StringUtils.toLong(get(CONF_EXPIRESIN));
    }

    /**
     * 根据键值获取值
     *
     * @param key
     * @return
     */
    public String get(String key) {
        Properties props = get();
        return (props != null) ? props.getProperty(key) : null;
    }

    /**
     * 获取Properties对象
     *
     * @return
     */
    public Properties get() {
        FileInputStream fis = null;
        Properties props = new Properties();
        try {
            //读取files目录下的config
            //fis = activity.openFileInput(APP_CONFIG);

            //读取app_config目录下的config
            File dirConf = mContext.getDir(APP_CONFIG, Context.MODE_PRIVATE);
            fis = new FileInputStream(dirConf.getPath() + File.separator + APP_CONFIG);

            props.load(fis);
        } catch (Exception e) {
        } finally {
            try {
                fis.close();
            } catch (Exception e) {
            }
        }
        return props;
    }

    /**
     * 设置Properties
     *
     * @param p
     */
    private void setProps(Properties p) {
        FileOutputStream fos = null;
        try {
            //把config建在files目录下
            //fos = activity.openFileOutput(APP_CONFIG, Context.MODE_PRIVATE);

            //把config建在(自定义)app_config的目录下
            File dirConf = mContext.getDir(APP_CONFIG, Context.MODE_PRIVATE);
            File conf = new File(dirConf, APP_CONFIG);
            fos = new FileOutputStream(conf);

            p.store(fos, null);
            fos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (Exception e) {
            }
        }
    }

    /**
     * 设置Properties
     *
     * @param ps
     */
    public void set(Properties ps) {
        Properties props = get();
        props.putAll(ps);
        setProps(props);
    }

    /**
     * 设置键值队
     *
     * @param key
     * @param value
     */
    public void set(String key, String value) {
        Properties props = get();
        props.setProperty(key, value);
        setProps(props);
    }

    /**
     * 移除键值
     *
     * @param key
     */
    public void remove(String... key) {
        Properties props = get();
        for (String k : key)
            props.remove(k);
        setProps(props);
    }
}
