package com.uiapp.doan.main.signupstaff.view;

import com.uiapp.doan.base.presenter.IView;
import com.uiapp.doan.interactor.api.response.CreateThoResponse;
import com.uiapp.doan.interactor.api.response.DichVuResponse;

/**
 * Created by hongnhung on 11/3/16.
 */

public interface ISignUpStaffView extends IView {

    void createSuccess(CreateThoResponse createThoResponse);
    void createError(String message);
    void getDichVuSuccess(DichVuResponse dichVuResponse);

    void getDichVuError(String message);
}
