package com.dyx.mp.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Da on 2016/4/5.
 */
public class MainItemBean implements Parcelable {
    public String itemName;

    public MainItemBean(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.itemName);
    }

    public MainItemBean() {
    }

    protected MainItemBean(Parcel in) {
        this.itemName = in.readString();
    }

    public static final Parcelable.Creator<MainItemBean> CREATOR = new Parcelable.Creator<MainItemBean>() {
        @Override
        public MainItemBean createFromParcel(Parcel source) {
            return new MainItemBean(source);
        }

        @Override
        public MainItemBean[] newArray(int size) {
            return new MainItemBean[size];
        }
    };
}
