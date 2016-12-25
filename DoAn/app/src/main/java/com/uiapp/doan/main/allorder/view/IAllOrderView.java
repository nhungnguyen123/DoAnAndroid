package com.uiapp.doan.main.allorder.view;

import com.uiapp.doan.base.presenter.IView;

/**
 * Created by hongnhung on 10/25/16.
 */

public interface IAllOrderView extends IView {
    void allOrderSuccess();
    void allOrderError(String message);


    void allOrderThoSuccess();
    void allOrderThoError(String message);


}
