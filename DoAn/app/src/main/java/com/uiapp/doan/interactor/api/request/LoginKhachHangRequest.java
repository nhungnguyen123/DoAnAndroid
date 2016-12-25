package com.uiapp.doan.interactor.api.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by hongnhung on 11/10/16.
 */

public class LoginKhachHangRequest implements Serializable {
    @SerializedName("taikhoan")
    @Expose
    public String taikhoan;

    @SerializedName("matkhau")
    @Expose
    public String matkhau;

    public LoginKhachHangRequest(String taikhoan, String matkhau) {
        this.taikhoan = taikhoan;
        this.matkhau = matkhau;

    }


}
