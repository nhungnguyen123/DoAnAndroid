package com.uiapp.doan.interactor.api;

import android.util.Log;

import com.google.gson.Gson;
import com.uiapp.doan.dto.DefindKhachHang;
import com.uiapp.doan.dto.DichVu;
import com.uiapp.doan.dto.KhachHang;
import com.uiapp.doan.dto.Order;
import com.uiapp.doan.dto.Tho;
import com.uiapp.doan.interactor.api.network.ApiCallback;
import com.uiapp.doan.interactor.api.network.ApiClient;
import com.uiapp.doan.interactor.api.network.RestCallback;
import com.uiapp.doan.interactor.api.network.RestError;
import com.uiapp.doan.interactor.api.request.ChangePassRequest;
import com.uiapp.doan.interactor.api.request.LichBanThoRequest;
import com.uiapp.doan.interactor.api.request.LoginKhachHangRequest;
import com.uiapp.doan.interactor.api.request.LoginRequest;
import com.uiapp.doan.interactor.api.response.AllOrderResponse;
import com.uiapp.doan.interactor.api.response.ChangePassThoResponse;
import com.uiapp.doan.interactor.api.response.CreateKhachHangResponse;
import com.uiapp.doan.interactor.api.response.CreateLichBanThoResponse;
import com.uiapp.doan.interactor.api.response.CreateThoResponse;
import com.uiapp.doan.interactor.api.response.DichVuResponse;
import com.uiapp.doan.interactor.api.response.LichBanThoResponse;
import com.uiapp.doan.interactor.api.response.LoginKhachHangResponse;
import com.uiapp.doan.interactor.api.response.LoginResponse;
import com.uiapp.doan.interactor.api.response.OrderResponse;
import com.uiapp.doan.interactor.api.response.QuanResponse;
import com.uiapp.doan.interactor.api.response.ThoResponse;
import com.uiapp.doan.interactor.api.response.YeuCauResponse;
import com.uiapp.doan.utils.LogUtils;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by hongnhung on 10/23/16.
 */

public class ApiManager {
    public ApiClient apiClient;

    @Inject
    public ApiManager(Retrofit retrofit) {
        apiClient = retrofit.create(ApiClient.class);
    }

    public void getAllDichVu(final RestCallback<DichVuResponse> callback) {
        apiClient.getalldichvu().enqueue(new RestCallback<DichVuResponse>() {
            @Override
            public void success(DichVuResponse res) {
                callback.success(res);
            }

            @Override
            public void failure(RestError error) {
                callback.failure(error);
            }
        });
    }


    public void getAllQuan(final RestCallback<QuanResponse> callback) {
        apiClient.getallquan().enqueue(new RestCallback<QuanResponse>() {
            @Override
            public void success(QuanResponse res) {
                callback.success(res);
            }

            @Override
            public void failure(RestError error) {
                callback.failure(error);
            }
        });
    }


    public void getAllTho(final ApiCallback<ThoResponse> callback) {
        apiClient.getalltho().enqueue(new RestCallback<ThoResponse>() {
            @Override
            public void success(ThoResponse res) {
                callback.success(res);
            }

            @Override
            public void failure(RestError error) {
                Log.e("error", error.toString());
                Log.e("code", error.code + "");
                Log.e("message", error.message + "");
                callback.failure(error);
            }
        });
    }



    public void createTho(Tho tho, final ApiCallback<CreateThoResponse> callback) {
        apiClient.createTho(tho).enqueue(new RestCallback<CreateThoResponse>() {
            @Override
            public void success(CreateThoResponse res) {
                callback.success(res);
            }

            @Override
            public void failure(RestError error) {
                callback.failure(error);
            }
        });
    }


    public void getAllOrder(final ApiCallback<AllOrderResponse> callback) {
        apiClient.getAllOrder().enqueue(new RestCallback<AllOrderResponse>() {
            @Override
            public void success(AllOrderResponse res) {
                callback.success(res);
            }

            @Override
            public void failure(RestError error) {
                callback.failure(error);
            }
        });
    }


    public void getAllOrderTho(String cmnd, final ApiCallback<AllOrderResponse> callback) {
        apiClient.getAllOrderTho(cmnd).enqueue(new RestCallback<AllOrderResponse>() {
            @Override
            public void success(AllOrderResponse res) {
                callback.success(res);
            }

            @Override
            public void failure(RestError error) {

                callback.failure(error);
            }
        });
    }


    public void getAllYeuCauKhach(String sodt, final ApiCallback<AllOrderResponse> callback) {
        apiClient.getAllYeuCauKhach(sodt).enqueue(new RestCallback<AllOrderResponse>() {
            @Override
            public void success(AllOrderResponse res) {
                callback.success(res);
            }

            @Override
            public void failure(RestError error) {

                callback.failure(error);
            }
        });
    }


    public void getOrderByMaYc(String maYc, final ApiCallback<OrderResponse> callback) {
        apiClient.getOrderByMaYc(maYc).enqueue(new RestCallback<OrderResponse>() {
            @Override
            public void success(OrderResponse res) {
                callback.success(res);
            }

            @Override
            public void failure(RestError error) {
                callback.failure(error);
            }
        });
    }

    public void createOrder(Order order, final ApiCallback<OrderResponse> callback) {
        apiClient.createOrder(order).enqueue(new RestCallback<OrderResponse>() {
            @Override
            public void success(OrderResponse res) {
                callback.success(res);
            }

            @Override
            public void failure(RestError error) {
                callback.failure(error);
            }
        });
    }


    public void updateOrder(String mayc, Order order, final ApiCallback<OrderResponse> callback) {
        apiClient.updateOrder(order, mayc).enqueue(new RestCallback<OrderResponse>() {
            @Override
            public void success(OrderResponse res) {
                callback.success(res);
            }

            @Override
            public void failure(RestError error) {
                callback.failure(error);
            }
        });
    }

    public void createKhachHang(KhachHang khachHang, final ApiCallback<CreateKhachHangResponse> callback) {
        apiClient.createKhachHang(khachHang).enqueue(new RestCallback<CreateKhachHangResponse>() {
            @Override
            public void success(CreateKhachHangResponse res) {
                callback.success(res);
            }

            @Override
            public void failure(RestError error) {
                callback.failure(error);
            }
        });
    }


    public void loginNhanVien(LoginRequest loginRequest, final ApiCallback<LoginResponse> callback) {
        apiClient.login(loginRequest).enqueue(new RestCallback<LoginResponse>() {
            @Override
            public void success(LoginResponse res) {

                callback.success(res);
            }

            @Override
            public void failure(RestError error) {
                callback.failure(error);
            }
        });
    }

    public void loginkhachhang(LoginKhachHangRequest loginKhachHangRequest, final ApiCallback<LoginKhachHangResponse> callback) {
        apiClient.loginkhachhang(loginKhachHangRequest).enqueue(new RestCallback<LoginKhachHangResponse>() {
            @Override
            public void success(LoginKhachHangResponse res) {
                callback.success(res);
            }

            @Override
            public void failure(RestError error) {
                callback.failure(error);
            }
        });
    }


    public void getAllLichBanTho(final ApiCallback<LichBanThoResponse> callback) {
        apiClient.getAllLichBanTho().enqueue(new RestCallback<LichBanThoResponse>() {
            @Override
            public void success(LichBanThoResponse res) {
                callback.success(res);
            }

            @Override
            public void failure(RestError error) {
                callback.failure(error);
            }
        });

    }


    public void changePassTho(String cmnd, ChangePassRequest changePassRequest, final ApiCallback<ChangePassThoResponse> callback) {
        apiClient.changePassTho(cmnd, changePassRequest).enqueue(new RestCallback<ChangePassThoResponse>() {
            @Override
            public void success(ChangePassThoResponse res) {
                callback.success(res);
            }

            @Override
            public void failure(RestError error) {
                callback.failure(error);
            }
        });
    }

    public void createlichBanTho(LichBanThoRequest lichBanThoRequest, final ApiCallback<CreateLichBanThoResponse> callback) {
        apiClient.createLichBanTho(lichBanThoRequest).enqueue(new RestCallback<CreateLichBanThoResponse>() {
            @Override
            public void success(CreateLichBanThoResponse res) {
                callback.success(res);
            }

            @Override
            public void failure(RestError error) {
                callback.failure(error);
            }
        });
    }


}
