package com.uiapp.doan.main.menucontainer.injection;

import com.uiapp.doan.injection.PerFragment;
import com.uiapp.doan.interactor.api.ApiManager;
import com.uiapp.doan.interactor.prefer.PreferManager;
import com.uiapp.doan.main.menucontainer.presenter.MenuContainerPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by hongnhung on 10/23/16.
 */
@Module
public class MenuContainerModule {
    @Provides
    @PerFragment
    MenuContainerPresenter provideMenuContainerPresenter(ApiManager apiManager, PreferManager preferManager) {
        return new MenuContainerPresenter(apiManager, preferManager);
    }
}
