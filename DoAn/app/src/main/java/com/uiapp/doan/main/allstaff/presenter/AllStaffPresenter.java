package com.uiapp.doan.main.allstaff.presenter;

import android.util.Log;

import com.google.gson.Gson;
import com.uiapp.doan.base.presenter.BasePresenter;
import com.uiapp.doan.dto.LichBanTho;
import com.uiapp.doan.dto.Tho;
import com.uiapp.doan.interactor.api.ApiManager;
import com.uiapp.doan.interactor.api.network.ApiCallback;
import com.uiapp.doan.interactor.api.network.RestCallback;
import com.uiapp.doan.interactor.api.network.RestError;
import com.uiapp.doan.interactor.api.response.LichBanThoResponse;
import com.uiapp.doan.interactor.api.response.ThoResponse;
import com.uiapp.doan.interactor.prefer.PreferManager;
import com.uiapp.doan.main.allstaff.view.IAllStaffView;
import com.uiapp.doan.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by hongnhung on 10/25/16.
 */

public class AllStaffPresenter extends BasePresenter<IAllStaffView> implements IAllStaffPresenter {

    public List<Tho> listTho;
    public List<LichBanTho> listLichBanTho;


    @Inject
    public AllStaffPresenter(ApiManager apiManager, PreferManager preferManager) {
        super(apiManager, preferManager);
        listTho = new ArrayList<>();
        listLichBanTho = new ArrayList<>();
    }

    @Override
    public void attachView(IAllStaffView mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void getallstaff() {

        getApiManager().getAllTho(new ApiCallback<ThoResponse>() {
            @Override
            public void success(ThoResponse res) {
                for (Tho tho : res.getListTho()) {
                    listTho.add(tho);
                }
                getView().getallstaffsuccess();
            }

            @Override
            public void failure(RestError error) {
                Log.e("error", error.toString());
            }
        });
    }

    @Override
    public void getAllLicBantho() {
        getApiManager().getAllLichBanTho(new ApiCallback<LichBanThoResponse>() {
            @Override
            public void success(LichBanThoResponse res) {
                for (LichBanTho lichBanTho : res.getResults()) {
                    listLichBanTho.add(lichBanTho);
                }

                String lichbanString = new Gson().toJson(res);
                Log.e("lichbanString", lichbanString + "");
                getView().getAllLichBanThoSuccess();
            }

            @Override
            public void failure(RestError error) {
                getView().getAllLichBanThoError(error.message);
            }
        });
    }


}
