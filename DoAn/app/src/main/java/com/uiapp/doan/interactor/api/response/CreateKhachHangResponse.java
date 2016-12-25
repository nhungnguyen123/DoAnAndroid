package com.uiapp.doan.interactor.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.uiapp.doan.dto.DefindKhachHang;

import java.io.Serializable;

/**
 * Created by hongnhung on 11/6/16.
 */

public class CreateKhachHangResponse extends BaseResponse {
    @SerializedName("results")
    @Expose
    public DefindKhachHang defindKhachHang;

    public DefindKhachHang getDefindKhachHang() {
        return defindKhachHang;
    }

    public void setDefindKhachHang(DefindKhachHang defindKhachHang) {
        this.defindKhachHang = defindKhachHang;
    }
}
