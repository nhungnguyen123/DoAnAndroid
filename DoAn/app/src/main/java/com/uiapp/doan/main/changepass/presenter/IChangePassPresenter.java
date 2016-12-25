package com.uiapp.doan.main.changepass.presenter;

import com.uiapp.doan.interactor.api.request.ChangePassRequest;

/**
 * Created by hongnhung on 12/15/16.
 */

public interface IChangePassPresenter {

    void changePassTho(ChangePassRequest changePassRequest);

    String getCmnd();

    String getQuyen();

    String getUsername();
    void goLogOut();
}


