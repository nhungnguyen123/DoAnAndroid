package com.uiapp.doan.main.allstaff.view;

import com.uiapp.doan.base.presenter.IView;

/**
 * Created by hongnhung on 10/25/16.
 */

public interface IAllStaffView extends IView {
    void getallstaffsuccess();

    String getallstafferror(String message);

    void getAllLichBanThoSuccess();
    void getAllLichBanThoError(String message);
}
