package com.uiapp.doan.main.allorder.injection;

import com.uiapp.doan.injection.PerFragment;
import com.uiapp.doan.interactor.api.ApiManager;
import com.uiapp.doan.interactor.prefer.PreferManager;
import com.uiapp.doan.main.allorder.presenter.AllOrderPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by hongnhung on 10/25/16.
 */

@Module
public class AllOrderModule {
    @Provides
    @PerFragment
    AllOrderPresenter provideAllOrderPresenter(ApiManager apiManager, PreferManager preferManager){
        return  new AllOrderPresenter(apiManager , preferManager);
    }
}
