package com.uiapp.doan.interactor.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.uiapp.doan.dto.Order;
import com.uiapp.doan.dto.Quan;

import java.util.List;

/**
 * Created by hongnhung on 11/4/16.
 */

public class AllOrderResponse extends BaseResponse {
    @SerializedName("results")
    @Expose
    public List<Order> listOrder;

    public List<Order> getListOrder() {
        return listOrder;
    }

    public void setListOrder(List<Order> listOrder) {
        this.listOrder = listOrder;
    }
}
