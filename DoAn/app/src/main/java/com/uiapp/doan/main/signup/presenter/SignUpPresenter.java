package com.uiapp.doan.main.signup.presenter;

import android.util.Log;

import com.google.gson.Gson;
import com.uiapp.doan.AppConstants;
import com.uiapp.doan.base.presenter.BasePresenter;
import com.uiapp.doan.dto.KhachHang;
import com.uiapp.doan.interactor.api.ApiManager;
import com.uiapp.doan.interactor.api.network.ApiCallback;
import com.uiapp.doan.interactor.api.network.RestError;
import com.uiapp.doan.interactor.api.response.CreateKhachHangResponse;
import com.uiapp.doan.interactor.prefer.PreferManager;
import com.uiapp.doan.main.signup.view.ISignUpView;

import javax.inject.Inject;

/**
 * Created by hongnhung on 10/26/16.
 */

public class SignUpPresenter extends BasePresenter<ISignUpView> implements ISignUpPresenter {

    CreateKhachHangResponse khachHangResponse = new CreateKhachHangResponse();

    @Inject
    public SignUpPresenter(ApiManager apiManager, PreferManager preferManager) {
        super(apiManager, preferManager);
    }

    @Override
    public void SignUpUser(KhachHang createKhachHang) {
        getApiManager().createKhachHang(createKhachHang, new ApiCallback<CreateKhachHangResponse>() {
            @Override
            public void success(CreateKhachHangResponse res) {

                String jsonCreateKhach = new Gson().toJson(res);

                Log.e("jsonCreateKhach", jsonCreateKhach);
                khachHangResponse.setDefindKhachHang(res.getDefindKhachHang());
                getView().createKhachHangSuccesS(res);
            }

            @Override
            public void failure(RestError error) {
                getView().createKhachHangError(error.message);

            }
        });
    }


    @Override
    public void setTaiKhoan() {
        getPreferManager().setKeyValueByKeyName(AppConstants.KEY_TAI_KHOAN, khachHangResponse.getDefindKhachHang().getKhachHang().getTaikhoan());
    }

    @Override
    public void setQuyenKhachHang() {
        getPreferManager().setKeyValueByKeyName(AppConstants.KEY_ROLE_USER, AppConstants.QUYEN);
    }

    @Override
    public void setHoten() {
        getPreferManager().setKeyValueByKeyName(AppConstants.HO_TEN, khachHangResponse.getDefindKhachHang().getKhachHang().getHoten());
    }

    @Override
    public void setDiachi() {
        getPreferManager().setKeyValueByKeyName(AppConstants.KEY_DIA_CHI, khachHangResponse.getDefindKhachHang().getKhachHang().getDiachi());
    }

    @Override
    public void setEmail() {
        getPreferManager().setKeyValueByKeyName(AppConstants.EMAIL, khachHangResponse.getDefindKhachHang().getKhachHang().getEmail());
    }
}
