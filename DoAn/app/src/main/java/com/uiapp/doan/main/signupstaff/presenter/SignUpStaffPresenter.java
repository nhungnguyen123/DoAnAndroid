package com.uiapp.doan.main.signupstaff.presenter;

import com.uiapp.doan.base.presenter.BasePresenter;
import com.uiapp.doan.dto.DichVu;
import com.uiapp.doan.dto.Tho;
import com.uiapp.doan.interactor.api.ApiManager;
import com.uiapp.doan.interactor.api.network.ApiCallback;
import com.uiapp.doan.interactor.api.network.RestCallback;
import com.uiapp.doan.interactor.api.network.RestError;
import com.uiapp.doan.interactor.api.response.BaseResponse;
import com.uiapp.doan.interactor.api.response.CreateThoResponse;
import com.uiapp.doan.interactor.api.response.DichVuResponse;
import com.uiapp.doan.interactor.prefer.PreferManager;
import com.uiapp.doan.main.signupstaff.view.ISignUpStaffView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by hongnhung on 11/3/16.
 */

public class SignUpStaffPresenter extends BasePresenter<ISignUpStaffView> implements ISignUpStaffPresenter {

    public List<String> listdichvu = new ArrayList<String>();
    public DichVuResponse dichVuResponse;

    @Inject
    public SignUpStaffPresenter(ApiManager apiManager, PreferManager preferManager) {
        super(apiManager, preferManager);
        listdichvu = new ArrayList<>();
        dichVuResponse = new DichVuResponse();
    }

    @Override
    public void signUpStaff(Tho tho) {
        getApiManager().createTho(tho, new ApiCallback<CreateThoResponse>() {
            @Override
            public void success(CreateThoResponse res) {
                getView().createSuccess(res);
            }

            @Override
            public void failure(RestError error) {
                getView().createError(error.message);
            }
        });
    }

    @Override
    public void getAllDichVu() {
        getApiManager().getAllDichVu(new RestCallback<DichVuResponse>() {
            @Override
            public void success(DichVuResponse res) {
                dichVuResponse.setDichVus(res.getDichVus());
                for (DichVu dichvu : res.getDichVus()) {
                    listdichvu.add(dichvu.getTenDichVu());
                }
                getView().getDichVuSuccess(res);
            }

            @Override
            public void failure(RestError error) {
                getView().getDichVuError(error.toString());
            }
        });
    }
}
