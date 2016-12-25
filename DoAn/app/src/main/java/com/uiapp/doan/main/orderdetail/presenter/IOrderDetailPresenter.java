package com.uiapp.doan.main.orderdetail.presenter;

import com.uiapp.doan.dto.Order;
import com.uiapp.doan.interactor.api.request.LichBanThoRequest;

/**
 * Created by hongnhung on 11/19/16.
 */

public interface IOrderDetailPresenter {
    String getCmnd();

    String getSdtKhach();

    String getQuyen();

    void updateOrder(String mayc, Order order);
    void createLichBantho(LichBanThoRequest lichBanThoRequest);
}
