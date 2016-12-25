package com.uiapp.doan.main.allstafforder.presenter;

import android.util.Log;

import com.uiapp.doan.base.presenter.BasePresenter;
import com.uiapp.doan.dto.Tho;
import com.uiapp.doan.interactor.api.ApiManager;
import com.uiapp.doan.interactor.api.network.ApiCallback;
import com.uiapp.doan.interactor.api.network.RestError;
import com.uiapp.doan.interactor.api.response.ThoResponse;
import com.uiapp.doan.interactor.prefer.PreferManager;
import com.uiapp.doan.main.allstafforder.view.IAllStaffOrderView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by hongnhung on 11/22/16.
 */

public class AllStaffOrderPresenter extends BasePresenter<IAllStaffOrderView> implements IAllStaffOrderPresenter {


    public List<Tho> listTho;
    @Inject
    public AllStaffOrderPresenter(ApiManager apiManager, PreferManager preferManager) {
        super(apiManager, preferManager);
        listTho = new ArrayList<>();
    }


    @Override
    public void getAllStaff() {

        getApiManager().getAllTho(new ApiCallback<ThoResponse>() {
            @Override
            public void success(ThoResponse res) {
                for (Tho tho : res.getListTho()) {
                    listTho.add(tho);
                }

                getView().getallstaffordersuccess();
            }

            @Override
            public void failure(RestError error) {
                Log.e("error", error.toString());
                getView().getAllOrderError(error.message);
            }
        });
    }
}
