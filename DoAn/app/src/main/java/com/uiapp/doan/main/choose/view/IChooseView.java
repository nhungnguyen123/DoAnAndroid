package com.uiapp.doan.main.choose.view;

import com.uiapp.doan.base.presenter.IView;
import com.uiapp.doan.interactor.api.response.DichVuResponse;
import com.uiapp.doan.interactor.api.response.QuanResponse;

/**
 * Created by hongnhung on 10/23/16.
 */

public interface IChooseView extends IView {
    void adddichvu(String all);

    void getQuanSuccess(QuanResponse quanResponse);

    void getQuanError(String message);

    void getDichVuSuccess(DichVuResponse dichVuResponse);

    void getDichVuError(String message);
}
