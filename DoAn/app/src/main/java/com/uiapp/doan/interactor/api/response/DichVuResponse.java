package com.uiapp.doan.interactor.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.uiapp.doan.dto.DichVu;

import java.util.List;

/**
 * Created by hongnhung on 10/29/16.
 */

public class DichVuResponse extends BaseResponse {
    @SerializedName("results")
    @Expose
    public List<DichVu> dichVus;

    public List<DichVu> getDichVus() {
        return dichVus;
    }

    public void setDichVus(List<DichVu> dichVus) {
        this.dichVus = dichVus;
    }
}
