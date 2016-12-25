package com.uiapp.doan.main.order.presenter;

import android.util.Log;

import com.google.gson.Gson;
import com.uiapp.doan.AppConstants;
import com.uiapp.doan.base.presenter.BasePresenter;
import com.uiapp.doan.dto.Order;
import com.uiapp.doan.interactor.api.ApiManager;
import com.uiapp.doan.interactor.api.network.ApiCallback;
import com.uiapp.doan.interactor.api.network.RestError;
import com.uiapp.doan.interactor.api.response.OrderResponse;
import com.uiapp.doan.interactor.api.response.YeuCauResponse;
import com.uiapp.doan.interactor.prefer.PreferManager;
import com.uiapp.doan.main.order.view.IOrderView;

import javax.inject.Inject;

/**
 * Created by hongnhung on 11/1/16.
 */

public class OrderPresenter extends BasePresenter<IOrderView> implements IOrderPresenter {

    @Inject
    public OrderPresenter(ApiManager apiManager, PreferManager preferManager) {
        super(apiManager, preferManager);
    }



    @Override
    public void createOrder(Order order) {
        getApiManager().createOrder(order, new ApiCallback<OrderResponse>() {
            @Override
            public void success(OrderResponse res) {
                String red = new Gson().toJson(res);
                Log.e("create order success ", red);
                getView().createOrderSuccess();

            }

            @Override
            public void failure(RestError error) {
                getView().createOrderError(error.message);
            }
        });
    }

    @Override
    public String getTaiKhoan() {
        return  getPreferManager().getKeyValueByKeyName(AppConstants.KEY_TAI_KHOAN);
    }

    @Override
    public String getHoTenKhachHang() {
        return getPreferManager().getKeyValueByKeyName(AppConstants.HO_TEN);
    }

    @Override
    public String getDiaChi() {
        return getPreferManager().getKeyValueByKeyName(AppConstants.KEY_DIA_CHI);
    }

    @Override
    public String getEmail() {
        return getPreferManager().getKeyValueByKeyName(AppConstants.EMAIL);
    }

    @Override
    public String getQuyen() {
        if (getPreferManager().getKeyValueByKeyName(AppConstants.KEY_ROLE_USER) == null) {
            return "";
        } else {
            return getPreferManager().getKeyValueByKeyName(AppConstants.KEY_ROLE_USER);

        }
    }
}
