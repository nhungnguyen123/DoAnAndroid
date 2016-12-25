package com.uiapp.doan.interactor.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.uiapp.doan.dto.Tho;

/**
 * Created by hongnhung on 11/3/16.
 */

public class CreateThoResponse extends BaseResponse {
    @SerializedName("results")
    @Expose
    public Tho tho;

    public Tho getTho() {
        return tho;
    }

    public void setTho(Tho tho) {
        this.tho = tho;
    }
}
