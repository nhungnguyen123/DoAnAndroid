package com.uiapp.doan.main.orderdetail.presenter;

import com.uiapp.doan.AppConstants;
import com.uiapp.doan.base.presenter.BasePresenter;
import com.uiapp.doan.dto.Order;
import com.uiapp.doan.interactor.api.ApiManager;
import com.uiapp.doan.interactor.api.network.ApiCallback;
import com.uiapp.doan.interactor.api.network.RestError;
import com.uiapp.doan.interactor.api.request.LichBanThoRequest;
import com.uiapp.doan.interactor.api.response.CreateLichBanThoResponse;
import com.uiapp.doan.interactor.api.response.OrderResponse;
import com.uiapp.doan.interactor.prefer.PreferManager;
import com.uiapp.doan.main.orderdetail.view.IOrderDetailView;

import javax.inject.Inject;

/**
 * Created by hongnhung on 11/19/16.
 */

public class OrderDetailPresenter extends BasePresenter<IOrderDetailView> implements IOrderDetailPresenter {

    @Inject
    public OrderDetailPresenter(ApiManager apiManager, PreferManager preferManager) {
        super(apiManager, preferManager);
    }

    @Override
    public String getCmnd() {
        return getPreferManager().getKeyValueByKeyName(AppConstants.KEY_CMND);
    }

    @Override
    public String getSdtKhach() {
        return getPreferManager().getKeyValueByKeyName(AppConstants.KEY_TAI_KHOAN);
    }

    @Override
    public String getQuyen() {
        return getPreferManager().getKeyValueByKeyName(AppConstants.KEY_ROLE_USER);
    }

    @Override
    public void updateOrder(String mayc, Order order) {
        getApiManager().updateOrder(mayc, order, new ApiCallback<OrderResponse>() {
            @Override
            public void success(OrderResponse res) {
                getView().updateOrderSuccess();
            }

            @Override
            public void failure(RestError error) {
                getView().updateOrderError(error.message);
            }
        });
    }

    @Override
    public void createLichBantho(LichBanThoRequest lichBanThoRequest) {
        getApiManager().createlichBanTho(lichBanThoRequest, new ApiCallback<CreateLichBanThoResponse>() {
            @Override
            public void success(CreateLichBanThoResponse res) {
                getView().createlichBansuccess();
            }

            @Override
            public void failure(RestError error) {
                getView().createLichError(error.message);
            }
        });
    }
}
