package com.uiapp.doan.injection.component;

import android.app.Application;
import android.content.Context;

import com.uiapp.doan.MainApplication;
import com.uiapp.doan.base.fragment.BaseFragment;
import com.uiapp.doan.injection.ApplicationContext;
import com.uiapp.doan.injection.module.ApiModule;
import com.uiapp.doan.injection.module.ApplicationModule;
import com.uiapp.doan.injection.module.PreferModule;
import com.uiapp.doan.interactor.api.ApiManager;
import com.uiapp.doan.interactor.prefer.PreferManager;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by hongnhung on 10/23/16.
 */
@Singleton
@Component(modules = {ApplicationModule.class, ApiModule.class, PreferModule.class})
public interface ApplicationComponent {
    void inject(MainApplication mainApplication);

    void inject(BaseFragment baseFragment);

    @ApplicationContext
    Context getContext();

    Application getApplication();

    ApiManager getApiManager();

    PreferManager getPreferManager();
}
