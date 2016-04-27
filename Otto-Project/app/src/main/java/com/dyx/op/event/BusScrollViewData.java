package com.dyx.op.event;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-04-27
 * Time      : 15:40
 * Summary   :
 * Copyright : Copyright (c) 2016
 */
public class BusScrollViewData {
    private int a;
    private int b;
    private int c;
    private int d;

    public BusScrollViewData(int a, int b, int c, int d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public String toString() {
        return "BusScrollViewData{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                '}';
    }
}