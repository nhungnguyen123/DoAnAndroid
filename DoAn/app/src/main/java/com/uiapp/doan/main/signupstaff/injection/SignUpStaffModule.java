package com.uiapp.doan.main.signupstaff.injection;

import com.uiapp.doan.injection.PerFragment;
import com.uiapp.doan.interactor.api.ApiManager;
import com.uiapp.doan.interactor.prefer.PreferManager;
import com.uiapp.doan.main.signupstaff.presenter.SignUpStaffPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by hongnhung on 11/3/16.
 */
@PerFragment
@Module
public class SignUpStaffModule {
    @Provides
    SignUpStaffPresenter provideSignUpStaffPresenter(ApiManager apiManager, PreferManager preferManager){
        return  new SignUpStaffPresenter(apiManager,preferManager);
    }


}
