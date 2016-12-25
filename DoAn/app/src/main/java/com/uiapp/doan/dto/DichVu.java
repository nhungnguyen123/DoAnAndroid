package com.uiapp.doan.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.uiapp.doan.interactor.api.response.BaseResponse;

import java.io.Serializable;

/**
 * Created by hongnhung on 10/27/16.
 */

public class DichVu extends BaseResponse {
    @SerializedName("_id")
    @Expose
    private String id;

    @SerializedName("tenDichVu")
    @Expose
    private String tenDichVu;

    @SerializedName("phiTheoGio")
    @Expose
    private Integer phiTheoGio;

    @SerializedName("mota")
    @Expose
    private String mota;

    @SerializedName("__v")
    @Expose
    private Integer v;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenDichVu() {
        return tenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public Integer getPhiTheoGio() {
        return phiTheoGio;
    }

    public void setPhiTheoGio(Integer phiTheoGio) {
        this.phiTheoGio = phiTheoGio;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }
}
