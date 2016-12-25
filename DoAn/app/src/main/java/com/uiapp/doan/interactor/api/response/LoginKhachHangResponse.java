package com.uiapp.doan.interactor.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.uiapp.doan.base.fragment.BaseFragment;
import com.uiapp.doan.dto.KhachHang;

import java.io.Serializable;

/**
 * Created by hongnhung on 11/10/16.
 */

public class LoginKhachHangResponse extends BaseResponse {
    @SerializedName("results")
    @Expose
    public KhachHang khachHang;

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }
}
