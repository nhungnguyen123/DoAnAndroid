package com.uiapp.doan.main.order.injection;

import com.uiapp.doan.injection.PerFragment;
import com.uiapp.doan.interactor.api.ApiManager;
import com.uiapp.doan.interactor.prefer.PreferManager;
import com.uiapp.doan.main.order.presenter.OrderPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by hongnhung on 11/1/16.
 */
@Module
public class OrderModule {

    @Provides
    @PerFragment
    OrderPresenter provideOrderPresenter(ApiManager apiManager, PreferManager preferManager) {
        return new OrderPresenter(apiManager, preferManager);
    }
}
