package com.uiapp.doan.main.orderdetail.view;

import com.uiapp.doan.base.presenter.IView;

/**
 * Created by hongnhung on 11/19/16.
 */

public interface IOrderDetailView extends IView {

    void updateOrderSuccess();

    void updateOrderError(String message);

    void createlichBansuccess();

    void createLichError(String message);
}
