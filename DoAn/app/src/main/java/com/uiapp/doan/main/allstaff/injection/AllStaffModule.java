package com.uiapp.doan.main.allstaff.injection;

import com.uiapp.doan.injection.PerFragment;
import com.uiapp.doan.interactor.api.ApiManager;
import com.uiapp.doan.interactor.prefer.PreferManager;
import com.uiapp.doan.main.allstaff.presenter.AllStaffPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by hongnhung on 10/25/16.
 */

@Module
public class AllStaffModule {
    @Provides
    @PerFragment
    AllStaffPresenter provideAllStaffPresenter(ApiManager apiManager, PreferManager preferManager) {
        return new AllStaffPresenter(apiManager, preferManager);
    }
}
