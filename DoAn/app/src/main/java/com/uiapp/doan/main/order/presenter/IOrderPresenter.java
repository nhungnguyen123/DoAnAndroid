package com.uiapp.doan.main.order.presenter;

import com.uiapp.doan.base.presenter.IView;
import com.uiapp.doan.dto.Order;

/**
 * Created by hongnhung on 11/1/16.
 */

public interface IOrderPresenter extends IView {


//    void getYeuCau();
    void createOrder(Order order);
    String getTaiKhoan();
    String getHoTenKhachHang();
    String getDiaChi();
    String getEmail();
    String getQuyen();


}
