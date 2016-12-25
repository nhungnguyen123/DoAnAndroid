package com.uiapp.doan.main.login.presenter;

import android.util.Log;

import com.google.gson.Gson;
import com.uiapp.doan.AppConstants;
import com.uiapp.doan.base.presenter.BasePresenter;
import com.uiapp.doan.dto.KhachHang;
import com.uiapp.doan.interactor.api.ApiManager;
import com.uiapp.doan.interactor.api.network.ApiCallback;
import com.uiapp.doan.interactor.api.network.RestError;
import com.uiapp.doan.interactor.api.request.LoginKhachHangRequest;
import com.uiapp.doan.interactor.api.request.LoginRequest;
import com.uiapp.doan.interactor.api.response.CreateKhachHangResponse;
import com.uiapp.doan.interactor.api.response.KhachHangResponse;
import com.uiapp.doan.interactor.api.response.LoginKhachHangResponse;
import com.uiapp.doan.interactor.api.response.LoginResponse;
import com.uiapp.doan.interactor.prefer.PreferManager;
import com.uiapp.doan.main.login.view.ILoginView;

import javax.inject.Inject;

/**
 * Created by hongnhung on 10/24/16.
 */

public class LoginPresenter extends BasePresenter<ILoginView> implements ILoginPresenter {


    public LoginResponse lgResponse = new LoginResponse();
    public KhachHangResponse khachHangResponse = new KhachHangResponse();


    @Inject
    public LoginPresenter(ApiManager apiManager, PreferManager preferManager) {
        super(apiManager, preferManager);
    }

    //TODO Truyền tham số vào .
    @Override
    public void loginNhanVien(String username, String password) {
        LoginRequest loginRequest = new LoginRequest(username, password);
        getApiManager().loginNhanVien(loginRequest, new ApiCallback<LoginResponse>() {
            @Override
            public void success(LoginResponse res) {
                lgResponse.setUser(res.getUser());
                String loginstaff = new Gson().toJson(res);
                Log.e("loginstaff", loginstaff + "");
                getView().loginSuccess(res);
            }

            @Override
            public void failure(RestError error) {
                getView().loginError(error.message);
            }
        });
    }

    @Override
    public void loginkhachhang(LoginKhachHangRequest loginRequest) {
        getApiManager().loginkhachhang(loginRequest, new ApiCallback<LoginKhachHangResponse>() {
            @Override
            public void success(LoginKhachHangResponse res) {
                khachHangResponse.setKhachHang(res.getKhachHang());
                String thongtinkhachhan = new Gson().toJson(res);
                Log.e("thongtinkhachhan", thongtinkhachhan + "");
                getView().loginKhachSuccess(res);
            }

            @Override
            public void failure(RestError error) {
                getView().loginKhachHangError(error.message);
            }
        });
    }

    @Override
    public void setQuyen() {

        getPreferManager().setKeyValueByKeyName(AppConstants.KEY_ROLE_USER, lgResponse.getUser().getQuyen());
    }

    @Override
    public void setQuyenChiDatHang() {
        getPreferManager().setKeyValueByKeyName(AppConstants.KEY_ROLE_USER, null);
        getPreferManager().setKeyValueByKeyName(AppConstants.EMAIL, "");
        getPreferManager().setKeyValueByKeyName(AppConstants.KEY_DIA_CHI, "");
        getPreferManager().setKeyValueByKeyName(AppConstants.HO_TEN, "");
        getPreferManager().setKeyValueByKeyName(AppConstants.KEY_TAI_KHOAN, "");
    }

    @Override
    public void setUserNameTho() {
        getPreferManager().setKeyValueByKeyName(AppConstants.KEY_NAME_DISPLAY,lgResponse.getUser().getUsername());
    }

    @Override
    public void setCmnd() {
        Log.e("cmndhave", lgResponse.getUser().getCmnd() + "");
        getPreferManager().setKeyValueByKeyName(AppConstants.KEY_CMND, lgResponse.getUser().getCmnd());
    }

    @Override
    public void setTaiKhoan() {
        getPreferManager().setKeyValueByKeyName(AppConstants.KEY_TAI_KHOAN, khachHangResponse.getKhachHang().getTaikhoan() + "");
    }

    @Override
    public void setQuyenKhachHang() {
        getPreferManager().setKeyValueByKeyName(AppConstants.KEY_ROLE_USER, AppConstants.QUYEN);
    }

    @Override
    public void setHoten() {
        getPreferManager().setKeyValueByKeyName(AppConstants.HO_TEN, khachHangResponse.getKhachHang().getHoten());
    }

    @Override
    public void setDiachi() {
        getPreferManager().setKeyValueByKeyName(AppConstants.KEY_DIA_CHI, khachHangResponse.getKhachHang().getDiachi());
    }

    @Override
    public void setEmail() {

        getPreferManager().setKeyValueByKeyName(AppConstants.EMAIL, khachHangResponse.getKhachHang().getEmail());
    }
}
