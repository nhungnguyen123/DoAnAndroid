package com.uiapp.doan.main.staffdetail.injection;

import com.uiapp.doan.injection.PerFragment;
import com.uiapp.doan.interactor.api.ApiManager;
import com.uiapp.doan.interactor.prefer.PreferManager;
import com.uiapp.doan.main.signupstaff.presenter.SignUpStaffPresenter;
import com.uiapp.doan.main.staffdetail.presenter.StaffDetailPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by hongnhung on 11/19/16.
 */
@PerFragment
@Module
public class StaffDetailModule {

    @Provides
    StaffDetailPresenter provideStaffDetailPresenter(ApiManager apiManager, PreferManager preferManager){
        return  new StaffDetailPresenter(apiManager,preferManager);
    }

}
