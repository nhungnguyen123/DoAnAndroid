package com.uiapp.doan.interactor.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.uiapp.doan.interactor.api.request.LichBanThoRequest;

/**
 * Created by hongnhung on 12/17/16.
 */

public class CreateLichBanThoResponse extends BaseResponse {
    @SerializedName("results")
    @Expose
    public LichBanThoRequest lichBanThoRequest;

    public LichBanThoRequest getLichBanThoRequest() {
        return lichBanThoRequest;
    }

    public void setLichBanThoRequest(LichBanThoRequest lichBanThoRequest) {
        this.lichBanThoRequest = lichBanThoRequest;
    }
}
