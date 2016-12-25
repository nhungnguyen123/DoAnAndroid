package com.uiapp.doan.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.uiapp.doan.interactor.api.response.BaseResponse;

/**
 * Created by hongnhung on 12/12/16.
 */

public class Id extends BaseResponse {
    @SerializedName("$oid")
    @Expose
    private String $oid;

    public String get$oid() {
        return $oid;
    }

    public void set$oid(String $oid) {
        this.$oid = $oid;
    }
}
