package com.uiapp.doan.interactor.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by hongnhung on 12/15/16.
 */

public class ChangePassThoResponse extends BaseResponse {
    @SerializedName("results")
    @Expose
    public String results;

}
