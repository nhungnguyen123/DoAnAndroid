package com.uiapp.doan.interactor.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by hongnhung on 11/2/16.
 */

public class YeuCauResponse extends BaseResponse {
    @SerializedName("results")
    @Expose
    public String maYc;

    public String getMaYc() {
        return maYc;
    }

    public void setMaYc(String maYc) {
        this.maYc = maYc;
    }
}
