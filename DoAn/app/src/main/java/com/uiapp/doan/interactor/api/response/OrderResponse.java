package com.uiapp.doan.interactor.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.uiapp.doan.dto.Order;

/**
 * Created by hongnhung on 11/4/16.
 */

public class OrderResponse extends BaseResponse {
    @SerializedName("Results")
    @Expose
    private Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
