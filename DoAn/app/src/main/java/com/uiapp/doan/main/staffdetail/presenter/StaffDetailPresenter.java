package com.uiapp.doan.main.staffdetail.presenter;

import com.uiapp.doan.base.presenter.BasePresenter;
import com.uiapp.doan.interactor.api.ApiManager;
import com.uiapp.doan.interactor.prefer.PreferManager;
import com.uiapp.doan.main.staffdetail.view.IStaffDetailView;

import javax.inject.Inject;

/**
 * Created by hongnhung on 11/19/16.
 */

public class StaffDetailPresenter extends BasePresenter<IStaffDetailView> implements  IStaffDetailPresenter {
    @Inject
    public StaffDetailPresenter(ApiManager apiManager, PreferManager preferManager) {
        super(apiManager, preferManager);
    }
}
