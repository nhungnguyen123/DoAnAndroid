package com.uiapp.doan.main.allstafforder.view;

import com.uiapp.doan.base.presenter.IView;

/**
 * Created by hongnhung on 11/22/16.
 */

public interface IAllStaffOrderView extends IView {

    void getallstaffordersuccess();
    void getAllOrderError(String message);
}
