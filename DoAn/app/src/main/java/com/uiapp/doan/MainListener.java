package com.uiapp.doan;

import android.support.v4.app.Fragment;

import com.uiapp.doan.base.IFragmentInteraction;

/**
 * Created by hongnhung on 10/23/16.
 */

public interface MainListener extends IFragmentInteraction {
    void openMenuContainer();

    void goLogin();

    void goAboutUs();

    void goAllSaffOrder();

    void goAllStaff(String request);

    void goAllOrder(String orderThoKhach);

    void goChangePass();

    void goOrderSuccess(String message);

    void goChoose();
    void goReport();

    void goSignup(Fragment fragment);

    void goStaffDetail(String detail, String order);

    void goOrderFragment(String order);

    void goSignUpStaff();

    void goOrderDetail(String orderDetail);
}
