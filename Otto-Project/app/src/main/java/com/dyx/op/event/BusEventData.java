package com.dyx.op.event;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-04-27
 * Time      : 15:39
 * Summary   :
 * Copyright : Copyright (c) 2016
 */
public class BusEventData {
    private String name;
    private int age;

    public BusEventData(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}