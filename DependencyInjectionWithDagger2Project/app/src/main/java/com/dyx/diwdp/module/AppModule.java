package com.dyx.diwdp.module;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * project name：DependencyInjectionWithDagger2Project
 * class describe：
 * create person：dayongxin
 * create time：16/7/13 下午4:46
 * alter person：dayongxin
 * alter time：16/7/13 下午4:46
 * alter remark：
 */
@Module
public class AppModule {
    Application mApplication;

    public AppModule(Application mApplication) {
        this.mApplication = mApplication;
    }

    @Provides
    @Singleton
    Application providesApplication() {
        return mApplication;
    }
}
