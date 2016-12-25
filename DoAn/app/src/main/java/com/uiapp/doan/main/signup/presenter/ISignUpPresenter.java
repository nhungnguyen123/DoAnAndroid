package com.uiapp.doan.main.signup.presenter;

import com.uiapp.doan.dto.KhachHang;

/**
 * Created by hongnhung on 10/26/16.
 */

public interface ISignUpPresenter  {

    void SignUpUser(KhachHang createKhachHang);



    void setTaiKhoan();

    void setQuyenKhachHang();

    void setHoten();

    void setDiachi();

    void setEmail();

}
