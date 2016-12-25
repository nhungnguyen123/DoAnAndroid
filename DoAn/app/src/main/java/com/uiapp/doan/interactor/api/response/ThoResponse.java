package com.uiapp.doan.interactor.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.uiapp.doan.dto.Quan;
import com.uiapp.doan.dto.Tho;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hongnhung on 10/30/16.
 */

public class ThoResponse extends BaseResponse {
    @SerializedName("results")
    @Expose
    public ArrayList<Tho> listTho;

    public ArrayList<Tho> getListTho() {
        return listTho;
    }

    public void setListTho(ArrayList<Tho> listTho) {
        this.listTho = listTho;
    }
}
