package com.uiapp.doan.interactor.api.network;

import com.uiapp.doan.dto.DefindKhachHang;
import com.uiapp.doan.dto.KhachHang;
import com.uiapp.doan.dto.Order;
import com.uiapp.doan.dto.Tho;
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
import com.uiapp.doan.main.order.presenter.OrderPresenter;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by hongnhung on 10/23/16.
 */

public interface ApiClient {
    /**
     * Get All Dich Vu
     *
     * @return
     */
    @GET("/dichvu")
    Call<DichVuResponse> getalldichvu();

    /**
     * Get All quan
     *
     * @return
     */
    @GET("/quan")
    Call<QuanResponse> getallquan();

    /**
     * Get All Tho
     *
     * @return
     */
    @GET("/tho")
    Call<ThoResponse> getalltho();



    /**
     * Create tho
     *
     * @return
     */
    @POST("/tho")
    Call<CreateThoResponse> createTho(@Body Tho tho);

    /**
     * Get All Order
     *
     * @return
     */
    @GET("/yeucau")
    Call<AllOrderResponse> getAllOrder();

    /**
     * Create Order
     *
     * @param createOrder
     * @return
     */
    @POST("/yeucau")
    Call<OrderResponse> createOrder(@Body Order createOrder);


    @PUT("/yeucau/{mayc}")
    Call<OrderResponse> updateOrder(
            @Body Order createOrder,
            @Path("mayc") String mayc);

    @POST("/lichlamviectho")
    Call<CreateLichBanThoResponse>createLichBanTho(@Body LichBanThoRequest lichBanThoRequest);

    /**
     * Lấy tất cả các yêu cầu của thợ đáp ứng
     *
     * @param cmndTho
     * @return
     */
    @GET("/yeucautho/{cmndTho}")
    Call<AllOrderResponse> getAllOrderTho(
            @Path("cmndTho") String cmndTho);


    /**
     * Lấy jeets yêu cầu của khách theo số điện thoại khách
     *
     * @param sodt
     * @return
     */
    @GET("/yeucaukhach/{sodt}")
    Call<AllOrderResponse> getAllYeuCauKhach(
            @Path("sodt") String sodt);


    /**
     *
     */
    @GET("/yeucau/{maYc}")
    Call<OrderResponse> getOrderByMaYc(
            @Path("mayc") String mayc);


    @POST("/login")
    Call<LoginResponse> login(
            @Body LoginRequest loginRequest);


    @POST("/loginkhachhang")
    Call<LoginKhachHangResponse> loginkhachhang(
            @Body LoginKhachHangRequest loginRequest);


    @POST("/khachhang")
    Call<CreateKhachHangResponse> createKhachHang(
            @Body KhachHang khachHang);


    @GET("/lichbantho")
    Call<LichBanThoResponse> getAllLichBanTho();

    @PUT("/user/{cmnd}")
    Call<ChangePassThoResponse> changePassTho(
            @Path("cmnd") String cmnd,
            @Body ChangePassRequest changepass);

}
