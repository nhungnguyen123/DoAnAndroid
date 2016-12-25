package com.uiapp.doan;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

import com.uiapp.doan.injection.component.ApplicationComponent;
import com.uiapp.doan.injection.component.DaggerApplicationComponent;
import com.uiapp.doan.injection.module.ApiModule;
import com.uiapp.doan.injection.module.ApplicationModule;
import com.uiapp.doan.injection.module.PreferModule;
import com.uiapp.doan.utils.LogUtils;



public class MainApplication extends Application {
    ApplicationComponent appComponent;
    private static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();

    }
    public static Context getContext(){
        return mContext;
    }

    public static ApplicationComponent getApplicationComponent(Context context){
        MainApplication app = (MainApplication) context.getApplicationContext();
        if (app.appComponent == null) {
            app.appComponent = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(app))
                    .apiModule(new ApiModule())
                    .preferModule(new PreferModule())
                    .build();
        }
        return app.appComponent;
    }

}
