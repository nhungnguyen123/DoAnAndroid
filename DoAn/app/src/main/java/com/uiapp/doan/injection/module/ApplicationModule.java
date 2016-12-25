package com.uiapp.doan.injection.module;

import android.app.Application;
import android.content.Context;

import com.uiapp.doan.injection.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by hongnhung on 10/23/16.
 */

@Module
public class ApplicationModule {
    protected final Application mApplication;


    public ApplicationModule(Application mApplication) {
        this.mApplication = mApplication;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

}
