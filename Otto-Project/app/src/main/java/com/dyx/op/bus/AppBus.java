package com.dyx.op.bus;

import com.squareup.otto.Bus;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-04-27
 * Time      : 15:37
 * Summary   :
 * Copyright : Copyright (c) 2016
 */
public class AppBus extends Bus {
    private static AppBus bus;

    public static AppBus getInstance() {
        if (bus == null) {
            return new AppBus();
        }
        return bus;
    }
}  