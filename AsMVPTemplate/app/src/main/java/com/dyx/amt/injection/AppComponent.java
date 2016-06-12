package com.dyx.amt.injection;

import android.content.Context;

import com.dyx.amt.App;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    Context getAppContext();

    App getApp();
}