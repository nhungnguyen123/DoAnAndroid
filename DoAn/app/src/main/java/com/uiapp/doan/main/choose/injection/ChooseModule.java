package com.uiapp.doan.main.choose.injection;

import com.uiapp.doan.injection.PerFragment;
import com.uiapp.doan.interactor.api.ApiManager;
import com.uiapp.doan.interactor.prefer.PreferManager;
import com.uiapp.doan.main.choose.presenter.ChoosePresenter;
import com.uiapp.doan.main.choose.view.IChooseView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by hongnhung on 10/23/16.
 */

@Module
public class ChooseModule {

    @PerFragment
    @Provides
    ChoosePresenter provideChoosePresenter(ApiManager apiManager , PreferManager preferManager){
        return  new ChoosePresenter(apiManager ,preferManager);
    }
}
