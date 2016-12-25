package com.uiapp.doan.main.login.presenter;

import com.uiapp.doan.interactor.api.request.LoginKhachHangRequest;
import com.uiapp.doan.interactor.api.request.LoginRequest;

/**
 * Created by hongnhung on 10/24/16.
 */

public interface ILoginPresenter {

    void loginNhanVien(String username, String password);

    void loginkhachhang(LoginKhachHangRequest loginRequest);

    void setQuyen();
    void setQuyenChiDatHang();
    void setUserNameTho();


    void setCmnd();

    void setTaiKhoan();

    void setQuyenKhachHang();

    void setHoten();

    void setDiachi();

    void setEmail();


}
