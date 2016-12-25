package com.uiapp.doan.main.login.injection;

import com.uiapp.doan.injection.PerFragment;
import com.uiapp.doan.interactor.api.ApiManager;
import com.uiapp.doan.interactor.prefer.PreferManager;
import com.uiapp.doan.main.choose.presenter.ChoosePresenter;
import com.uiapp.doan.main.choose.view.IChooseView;
import com.uiapp.doan.main.login.presenter.LoginPresenter;
import com.uiapp.doan.main.login.view.ILoginView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by hongnhung on 10/24/16.
 */
@PerFragment
@Module
public class LoginModule {

    @Provides
    LoginPresenter loginPresenter(ApiManager apiManager, PreferManager preferManager) {
        return new LoginPresenter(apiManager, preferManager);
    }
}
