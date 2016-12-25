package com.uiapp.doan.injection.module;

import com.uiapp.doan.interactor.api.ApiManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hongnhung on 10/23/16.
 */


@Module
public class ApiModule {
    @Provides
    @Singleton
    Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://doansever.herokuapp.com")
//                .baseUrl("http://192.168.1.20:3000")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    ApiManager provideApiManager(Retrofit retrofit) {
        return new ApiManager(retrofit);
    }
}
