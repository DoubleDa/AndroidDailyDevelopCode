package com.dyx.bkbp.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-04-28
 * Time      : 17:30
 * Summary   :
 * Copyright : Copyright (c) 2016
 */
public class TestEntity implements Parcelable {
    private String name;
    private int age;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.age);
    }

    public TestEntity() {
    }

    protected TestEntity(Parcel in) {
        this.name = in.readString();
        this.age = in.readInt();
    }

    public static final Parcelable.Creator<TestEntity> CREATOR = new Parcelable.Creator<TestEntity>() {
        @Override
        public TestEntity createFromParcel(Parcel source) {
            return new TestEntity(source);
        }

        @Override
        public TestEntity[] newArray(int size) {
            return new TestEntity[size];
        }
    };
}