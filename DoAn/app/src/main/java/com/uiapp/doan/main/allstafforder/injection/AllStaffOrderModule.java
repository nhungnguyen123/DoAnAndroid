package com.uiapp.doan.main.allstafforder.injection;

import com.uiapp.doan.injection.PerFragment;
import com.uiapp.doan.interactor.api.ApiManager;
import com.uiapp.doan.interactor.prefer.PreferManager;
import com.uiapp.doan.main.allstaff.presenter.AllStaffPresenter;
import com.uiapp.doan.main.allstafforder.presenter.AllStaffOrderPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by hongnhung on 11/22/16.
 */
@Module
public class AllStaffOrderModule {

    @Provides
    @PerFragment
    AllStaffOrderPresenter provideAllStaffOrderPresenter(ApiManager apiManager, PreferManager preferManager) {
        return new AllStaffOrderPresenter(apiManager, preferManager);
    }

}
