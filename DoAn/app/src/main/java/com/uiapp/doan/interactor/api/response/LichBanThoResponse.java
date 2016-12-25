package com.uiapp.doan.interactor.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.uiapp.doan.dto.KhachHang;
import com.uiapp.doan.dto.LichBanTho;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hongnhung on 11/18/16.
 */

public class LichBanThoResponse extends BaseResponse {
    @SerializedName("results")
    @Expose
    private List<LichBanTho> results = new ArrayList<LichBanTho>();

    public List<LichBanTho> getResults() {
        return results;
    }

    public void setResults(List<LichBanTho> results) {
        this.results = results;
    }
}
