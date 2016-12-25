package com.uiapp.doan.injection.module;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.uiapp.doan.interactor.prefer.PreferManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by hongnhung on 10/23/16.
 */

@Module
public class PreferModule {
    @Singleton
    @Provides
    SharedPreferences provideSharedPreferences(Application application) {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

    @Singleton
    @Provides
    PreferManager providePreferManager(SharedPreferences preferences) {
        return new PreferManager(preferences);
    }
}
