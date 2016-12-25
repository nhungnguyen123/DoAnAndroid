package com.uiapp.doan.main.choosedetail.presenter;


import com.uiapp.doan.base.presenter.BasePresenter;
import com.uiapp.doan.interactor.api.ApiManager;
import com.uiapp.doan.interactor.prefer.PreferManager;
import com.uiapp.doan.main.choosedetail.view.IChooseDetailView;

import javax.inject.Inject;

public class ChooseDetailPresenter extends BasePresenter<IChooseDetailView> implements  IChooseDetailPresenter{

    @Inject
    public ChooseDetailPresenter(ApiManager apiManager, PreferManager preferManager) {
        super(apiManager, preferManager);
    }
}
