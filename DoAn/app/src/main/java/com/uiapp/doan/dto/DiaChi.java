package com.uiapp.doan.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.uiapp.doan.interactor.api.response.BaseResponse;

/**
 * Created by hongnhung on 10/30/16.
 */

public class DiaChi  {

    @SerializedName("quan")
    @Expose
    private String quan;
    @SerializedName("tenkhuvuc")
    @Expose
    private String tenkhuvuc;

    /**
     *
     * @return
     * The quan
     */
    public String getQuan() {
        return quan;
    }

    /**
     *
     * @param quan
     * The quan
     */
    public void setQuan(String quan) {
        this.quan = quan;
    }

    /**
     *
     * @return
     * The tenkhuvuc
     */
    public String getTenkhuvuc() {
        return tenkhuvuc;
    }

    /**
     *
     * @param tenkhuvuc
     * The tenkhuvuc
     */
    public void setTenkhuvuc(String tenkhuvuc) {
        this.tenkhuvuc = tenkhuvuc;
    }

}
