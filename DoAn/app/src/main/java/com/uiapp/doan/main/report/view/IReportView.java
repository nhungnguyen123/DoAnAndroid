package com.uiapp.doan.main.report.view;

import com.uiapp.doan.base.presenter.IView;

/**
 * Created by hongnhung on 12/20/16.
 */

public interface IReportView extends IView {
    void allOrderSuccess();
    void allOrderError(String message);


    void allOrderThoSuccess();
    void allOrderThoError(String message);

    void getallThosuccess();
}
