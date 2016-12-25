package com.uiapp.doan.base.presenter;

/**
 * Created by hongnhung on 10/23/16.
 */

public interface IPresenter<V extends IView> {
    void attachView(V mvpView);

    void detachView();
}
