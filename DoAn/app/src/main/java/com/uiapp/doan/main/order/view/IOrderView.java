package com.uiapp.doan.main.order.view;

import com.uiapp.doan.base.presenter.IView;


public interface IOrderView extends IView {

    void getidYcSuccess(String messageYc);
    void getidYcError(String message);

    void createOrderSuccess();
    void createOrderError(String message);
}
