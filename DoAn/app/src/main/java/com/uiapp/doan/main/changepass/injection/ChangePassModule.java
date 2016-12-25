package com.uiapp.doan.main.changepass.injection;

import com.uiapp.doan.injection.PerFragment;
import com.uiapp.doan.interactor.api.ApiManager;
import com.uiapp.doan.interactor.prefer.PreferManager;
import com.uiapp.doan.main.allstafforder.presenter.AllStaffOrderPresenter;
import com.uiapp.doan.main.changepass.presenter.ChangePassPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by hongnhung on 12/15/16.
 */
@Module
public class ChangePassModule {


    @Provides
    @PerFragment
    ChangePassPresenter provideChangePassPresenter(ApiManager apiManager, PreferManager preferManager) {
        return new ChangePassPresenter(apiManager, preferManager);
    }
}
