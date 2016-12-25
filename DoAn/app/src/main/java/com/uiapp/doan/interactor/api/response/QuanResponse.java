package com.uiapp.doan.interactor.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.uiapp.doan.dto.DichVu;
import com.uiapp.doan.dto.Quan;

import java.util.List;

/**
 * Created by hongnhung on 10/30/16.
 */

public class QuanResponse extends BaseResponse {
    @SerializedName("results")
    @Expose
    public List<Quan> listQuan;

    public List<Quan> getListQuan() {
        return listQuan;
    }

    public void setListQuan(List<Quan> listQuan) {
        this.listQuan = listQuan;
    }
}
