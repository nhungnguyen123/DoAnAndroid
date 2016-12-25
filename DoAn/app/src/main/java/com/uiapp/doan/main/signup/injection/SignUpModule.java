package com.uiapp.doan.main.signup.injection;

import com.uiapp.doan.injection.PerFragment;
import com.uiapp.doan.interactor.api.ApiManager;
import com.uiapp.doan.interactor.prefer.PreferManager;
import com.uiapp.doan.main.login.presenter.LoginPresenter;
import com.uiapp.doan.main.signup.presenter.SignUpPresenter;
import com.uiapp.doan.main.signup.view.ISignUpView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by hongnhung on 10/26/16.
 */

@PerFragment
@Module
public class SignUpModule {



    @Provides
    SignUpPresenter signUpPresenter(ApiManager apiManager, PreferManager preferManager) {
        return new SignUpPresenter(apiManager, preferManager);
    }
}
