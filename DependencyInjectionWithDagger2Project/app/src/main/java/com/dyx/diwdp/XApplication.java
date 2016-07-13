package com.dyx.diwdp;

import android.app.Application;

import com.dyx.diwdp.component.DaggerNetComponent;
import com.dyx.diwdp.component.IonicChinaComponent;
import com.dyx.diwdp.component.NetComponent;
import com.dyx.diwdp.constants.Constants;
import com.dyx.diwdp.module.AppModule;
import com.dyx.diwdp.module.NetModule;

/**
 * project name：DependencyInjectionWithDagger2Project
 * class describe：
 * create person：dayongxin
 * create time：16/7/13 下午5:23
 * alter person：dayongxin
 * alter time：16/7/13 下午5:23
 * alter remark：
 */
public class XApplication extends Application {
    private NetComponent mNetComponent;
    private IonicChinaComponent mIonicChinaComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mNetComponent = DaggerNetComponent.builder().appModule(new AppModule(this)).netModule(new NetModule(Constants.BASE_URL)).build();
    }

    public NetComponent getmNetComponent() {
        return mNetComponent;
    }

    public IonicChinaComponent getmIonicChinaComponent() {
        return mIonicChinaComponent;
    }
}
