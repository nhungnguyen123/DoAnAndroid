package com.uiapp.doan.main.login.view;

import com.uiapp.doan.base.presenter.IView;
import com.uiapp.doan.interactor.api.response.CreateKhachHangResponse;
import com.uiapp.doan.interactor.api.response.LoginKhachHangResponse;
import com.uiapp.doan.interactor.api.response.LoginResponse;

/**
 * Created by hongnhung on 10/24/16.
 */

public interface ILoginView extends IView {

    void loginSuccess(LoginResponse res);
    void loginError(String message);

    void loginKhachSuccess(LoginKhachHangResponse createKhachHangResponse);
    void  loginKhachHangError(String message);

}
