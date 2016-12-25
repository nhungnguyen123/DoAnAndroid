package com.uiapp.doan.main.signup.view;

import com.uiapp.doan.base.presenter.IView;
import com.uiapp.doan.dto.KhachHang;
import com.uiapp.doan.interactor.api.response.CreateKhachHangResponse;
import com.uiapp.doan.interactor.api.response.KhachHangResponse;

/**
 * Created by hongnhung on 10/26/16.
 */

public interface ISignUpView extends IView {

    void createKhachHangSuccesS(CreateKhachHangResponse khachHangResponse);
    void createKhachHangError(String message);
}
