package com.uiapp.doan.main.allorder.presenter;

import android.util.Log;

import com.google.gson.Gson;
import com.uiapp.doan.AppConstants;
import com.uiapp.doan.base.presenter.BasePresenter;
import com.uiapp.doan.dto.Order;
import com.uiapp.doan.interactor.api.ApiManager;
import com.uiapp.doan.interactor.api.network.ApiCallback;
import com.uiapp.doan.interactor.api.network.RestError;
import com.uiapp.doan.interactor.api.response.AllOrderResponse;
import com.uiapp.doan.interactor.prefer.PreferManager;
import com.uiapp.doan.main.allorder.view.IAllOrderView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;


public class AllOrderPresenter extends BasePresenter<IAllOrderView> implements IAllOrderPresenter {
    public List<Order> mListOrder;
    public List<Order> mListOrderTho;
    public List<Order> mListOrderThoSort;
    public List<Order> mListOrderKhachHang;
    public List<Order> mListOrderKhachHangSort;

    @Inject
    public AllOrderPresenter(ApiManager apiManager, PreferManager preferManager) {
        super(apiManager, preferManager);
        mListOrder = new ArrayList<>();
        mListOrderTho = new ArrayList<>();
        mListOrderKhachHang = new ArrayList<>();
        mListOrderThoSort = new ArrayList<>();
        mListOrderKhachHangSort= new ArrayList<>();
    }

    @Override
    public void getAllOrder() {
        getApiManager().getAllOrder(new ApiCallback<AllOrderResponse>() {
            @Override
            public void success(AllOrderResponse res) {

                String jsonAllOrder = new Gson().toJson(res);
                Log.e("jsonAllOrder", jsonAllOrder);

                Log.e("sotaikhoannhanve", getKeyTaiKhoan());
                for (Order order : res.getListOrder()) {
                    Log.e("sdtTrang", order.getAccountKH() + "");
                    if (getKeyTaiKhoan().equalsIgnoreCase(order.getAccountKH())) {
                        mListOrderKhachHang.add(order);
                        String jsonOneOrder = new Gson().toJson(order);
                        Log.e("jsonOneOrder", jsonOneOrder);
                        Log.e("giobatdau", order.getGiobatdau() + "");


                    }

                }
                for ( int i=mListOrderKhachHang.size()-1;i>=0;i--)
                {
                    mListOrderKhachHangSort.add(mListOrderKhachHang.get(i));
                }

                getView().allOrderSuccess();
            }

            @Override
            public void failure(RestError error) {
                getView().allOrderError(error.message);
            }
        });
    }

    @Override
    public void getAllOrderTho() {
        getApiManager().getAllOrderTho(getKeyCmnd(), new ApiCallback<AllOrderResponse>() {
            @Override
            public void success(AllOrderResponse res) {
                for (Order order : res.getListOrder()) {

                    if (getKeyCmnd().equalsIgnoreCase(order.getCmndTho())) {
                        mListOrderTho.add(order);

                    }

                }

                for ( int i=mListOrderTho.size()-1;i>=0;i--)
                {
                    mListOrderThoSort.add(mListOrderTho.get(i));
                }

                getView().allOrderThoSuccess();
            }

            @Override
            public void failure(RestError error) {
                getView().allOrderThoError(error.message);
            }
        });
    }


    @Override
    public String getKeyTaiKhoan() {
        return getPreferManager().getKeyValueByKeyName(AppConstants.KEY_TAI_KHOAN);
    }

    @Override
    public String getKeyCmnd() {
        Log.e("returncmnd", getPreferManager().getKeyValueByKeyName(AppConstants.KEY_CMND));
        return getPreferManager().getKeyValueByKeyName(AppConstants.KEY_CMND);
    }

    @Override
    public String getQuyen() {
        return getPreferManager().getKeyValueByKeyName(AppConstants.KEY_ROLE_USER);
    }
}
