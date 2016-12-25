package com.uiapp.doan.main.orderdetail.injection;

import com.uiapp.doan.injection.PerFragment;
import com.uiapp.doan.interactor.api.ApiManager;
import com.uiapp.doan.interactor.prefer.PreferManager;
import com.uiapp.doan.main.allstaff.presenter.AllStaffPresenter;
import com.uiapp.doan.main.orderdetail.presenter.OrderDetailPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by hongnhung on 11/19/16.
 */

@Module
public class OrderDetailModule {
    @Provides
    @PerFragment
    OrderDetailPresenter provideOrderDetailPresenter(ApiManager apiManager, PreferManager preferManager) {
        return new OrderDetailPresenter(apiManager, preferManager);
    }
}
