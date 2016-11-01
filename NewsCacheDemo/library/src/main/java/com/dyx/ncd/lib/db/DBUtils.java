package com.dyx.ncd.lib.db;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

import io.realm.Realm;
import io.realm.RealmObject;

/**
 * project name：NewsCacheDemo
 * class describe：
 * create person：dayongxin
 * create time：2016/11/1 下午4:10
 * alter person：dayongxin
 * alter time：2016/11/1 下午4:10
 * alter remark：
 */
public class DBUtils {
    private static DBUtils instance = null;
    private Realm mRealm;

    private DBUtils() {
    }

    public static DBUtils getInstance() {
        if (instance == null) {
            synchronized (DBUtils.class) {
                if (instance == null) {
                    instance = new DBUtils();
                }
            }
        }
        return instance;
    }

    /**
     * 存储json字符串
     *
     * @param cla
     * @param json
     */
    public void writeDataToDb(final Class<? extends RealmObject> cla, final String json) {
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.createObjectFromJson(cla, json);
            }
        });
    }

    /**
     * 存储InputStream
     *
     * @param cla
     * @param is
     */
    public void writeDataToDb(final Class<? extends RealmObject> cla, final InputStream is) {
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                try {
                    realm.createObjectFromJson(cla, is);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * 存储JSONObject
     *
     * @param cla
     * @param json
     */
    public void writeDataToDb(final Class<? extends RealmObject> cla, final JSONObject json) {
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.createObjectFromJson(cla, json);
            }
        });
    }

    public void readDataFromDb() {
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                
            }
        });
    }
}
