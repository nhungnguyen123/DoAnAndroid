package com.uiapp.doan.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.uiapp.doan.interactor.api.response.BaseResponse;

/**
 * Created by hongnhung on 10/27/16.
 */

public class Quan extends BaseResponse {
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("tenquan")
    @Expose
    private String tenquan;
    @SerializedName("tenkhuvuc")
    @Expose
    private String tenkhuvuc;
    @SerializedName("__v")
    @Expose
    private Integer v;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenquan() {
        return tenquan;
    }

    public void setTenquan(String tenquan) {
        this.tenquan = tenquan;
    }

    public String getTenkhuvuc() {
        return tenkhuvuc;
    }

    public void setTenkhuvuc(String tenkhuvuc) {
        this.tenkhuvuc = tenkhuvuc;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }
}
