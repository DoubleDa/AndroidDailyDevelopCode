package com.dyx.diwdp.module;

import com.dyx.diwdp.interfaces.IonicChinaInterface;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.Retrofit;

/**
 * project name：DependencyInjectionWithDagger2Project
 * class describe：
 * create person：dayongxin
 * create time：16/7/13 下午5:15
 * alter person：dayongxin
 * alter time：16/7/13 下午5:15
 * alter remark：
 */
@Module
public class IonicChinaModule {
    @Provides
    @Singleton
    public IonicChinaInterface providesIonicChinaInterface(Retrofit retrofit) {
        return retrofit.create(IonicChinaInterface.class);
    }
}
