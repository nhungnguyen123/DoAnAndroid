package com.uiapp.doan.base.presenter;

import com.uiapp.doan.interactor.api.ApiManager;
import com.uiapp.doan.interactor.prefer.PreferManager;

/**
 * Created by hongnhung on 10/23/16.
 */

public abstract class BasePresenter<T extends IView> implements IPresenter<T> {
    private T mView;
    ApiManager mApiManager;
    PreferManager mPreferManager;

    public BasePresenter(ApiManager apiManager, PreferManager preferManager) {
        this.mApiManager = apiManager;
        this.mPreferManager = preferManager;
    }

    public PreferManager getPreferManager() {
        return mPreferManager;
    }

    public ApiManager getApiManager() {
        return mApiManager;
    }

    @Override
    public void attachView(T mvpView) {
        mView = mvpView;
    }

    @Override
    public void detachView() {
        mView = null;

    }

    public boolean isViewAttached() {
        return mView != null;
    }

    public T getView() {
        return mView;
    }

    public void onResume() {
    }

    public void onPause() {
    }
}
