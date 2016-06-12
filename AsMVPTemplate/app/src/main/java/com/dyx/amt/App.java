package com.dyx.amt;

import android.app.Application;
import android.support.annotation.NonNull;

import com.dyx.amt.injection.AppComponent;
import com.dyx.amt.injection.AppModule;
import com.dyx.amt.injection.DaggerAppComponent;

public final class App extends Application {
    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    @NonNull
    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}