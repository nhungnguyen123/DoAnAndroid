package com.uiapp.doan.main.choose.presenter;

import android.util.Log;

import com.google.gson.Gson;
import com.uiapp.doan.base.presenter.BasePresenter;
import com.uiapp.doan.dto.DichVu;
import com.uiapp.doan.dto.Quan;
import com.uiapp.doan.interactor.api.ApiManager;
import com.uiapp.doan.interactor.api.network.RestCallback;
import com.uiapp.doan.interactor.api.network.RestError;
import com.uiapp.doan.interactor.api.response.BaseResponse;
import com.uiapp.doan.interactor.api.response.DichVuResponse;
import com.uiapp.doan.interactor.api.response.QuanResponse;
import com.uiapp.doan.interactor.prefer.PreferManager;
import com.uiapp.doan.main.choose.view.IChooseView;
import com.uiapp.doan.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by hongnhung on 10/23/16.
 */

public class ChoosePresenter extends BasePresenter<IChooseView> implements IChoosePresenter {

    public List<String> listdichvu = new ArrayList<String>();
    public List<String> listquan = new ArrayList<>();
    public QuanResponse quanResponse= new QuanResponse();

    public DichVuResponse dichVuResponse;

    @Inject
    public ChoosePresenter(ApiManager apiManager, PreferManager preferManager) {
        super(apiManager, preferManager);
        dichVuResponse = new DichVuResponse();
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

    @Override
    public void getAllQuan() {
        getApiManager().getAllQuan(new RestCallback<QuanResponse>() {
            @Override
            public void success(QuanResponse res) {
                for (Quan quan: res.getListQuan()){
                    listquan.add(quan.getTenquan());
                }
                quanResponse.setListQuan(res.getListQuan());
                getView().getQuanSuccess(res);
            }

            @Override
            public void failure(RestError error) {
                getView().getQuanError(error.toString());
            }
        });
    }
}
