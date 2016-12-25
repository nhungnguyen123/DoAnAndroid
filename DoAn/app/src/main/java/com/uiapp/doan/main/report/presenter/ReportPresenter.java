package com.uiapp.doan.main.report.presenter;

import android.util.Log;

import com.google.gson.Gson;
import com.uiapp.doan.AppConstants;
import com.uiapp.doan.base.presenter.BasePresenter;
import com.uiapp.doan.dto.Order;
import com.uiapp.doan.dto.Report;
import com.uiapp.doan.dto.Tho;
import com.uiapp.doan.interactor.api.ApiManager;
import com.uiapp.doan.interactor.api.network.ApiCallback;
import com.uiapp.doan.interactor.api.network.RestError;
import com.uiapp.doan.interactor.api.response.AllOrderResponse;
import com.uiapp.doan.interactor.api.response.ThoResponse;
import com.uiapp.doan.interactor.prefer.PreferManager;
import com.uiapp.doan.main.report.view.IReportView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by hongnhung on 12/20/16.
 */

public class ReportPresenter extends BasePresenter<IReportView> implements IReportPresenter {

    public List<Order> mListOrder;
    public List<Order> mListOrderTho;
    public List<Order> mListOrderKhachHang;

    public List<Report> mListReportTho;
    public List<Report> mListReportKhach;
    String luong = "";
    public int tienkhach = 0;
    public int tientho = 0;

    @Inject
    public ReportPresenter(ApiManager apiManager, PreferManager preferManager) {
        super(apiManager, preferManager);
        mListOrder = new ArrayList<>();
        mListOrderTho = new ArrayList<>();
        mListOrderKhachHang = new ArrayList<>();
        mListReportTho = new ArrayList<>();
        mListReportKhach = new ArrayList<>();

    }

    @Override
    public String getQuyen() {
        return getPreferManager().getKeyValueByKeyName(AppConstants.KEY_ROLE_USER);
    }

    @Override
    public String cmndtho() {
        return getPreferManager().getKeyValueByKeyName(AppConstants.KEY_CMND);
    }

    @Override
    public String taikhoan() {
        return getPreferManager().getKeyValueByKeyName(AppConstants.KEY_TAI_KHOAN);
    }

    @Override
    public void getAllOrder() {
        getApiManager().getAllOrder(new ApiCallback<AllOrderResponse>() {
            @Override
            public void success(AllOrderResponse res) {
                String jsonAllOrder = new Gson().toJson(res);
                Log.e("jsonAllOrder", jsonAllOrder);
                Log.e("sotaikhoannhanve", taikhoan());
                for (Order order : res.getListOrder()) {
                    Log.e("sdtTrang", order.getAccountKH() + "");
                    if (taikhoan().equalsIgnoreCase(order.getAccountKH())) {

                        Report report = new Report();
                        report.setDichvu(order.getDichvuyc().get(0));
                        report.setGiobatdau(order.getGiobatdau());
                        report.setGioketthuc(order.getGioketthuc());
                        report.setNgaylam(order.getNgaylam());
                        report.setTien(order.getPhidichvu() + "");
                        tienkhach = tienkhach + Integer.parseInt(order.getPhidichvu());
                        mListReportKhach.add(report);
                    }

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
        getApiManager().getAllOrderTho(cmndtho(), new ApiCallback<AllOrderResponse>() {
            @Override
            public void success(AllOrderResponse res) {
                for (Order order : res.getListOrder()) {
                    if (cmndtho().equalsIgnoreCase(order.getCmndTho())) {

                        Report report = new Report();
                        report.setDichvu(order.getDichvuyc().get(0));
                        report.setGiobatdau(order.getGiobatdau());
                        report.setGioketthuc(order.getGioketthuc());
                        report.setNgaylam(order.getNgaylam());

                        int giobatdau = Integer.parseInt(order.getGiobatdau());
                        int gioketthuc = Integer.parseInt(order.getGioketthuc());
                        int tienluonggio = Integer.parseInt(luong);

                        int tien = (gioketthuc - giobatdau) / 60 * tienluonggio;


                        report.setTien(tien + "");
                        tientho = tientho + tien;
                        mListReportTho.add(report);


                    }

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
    public void getAllTho() {
        getApiManager().getAllTho(new ApiCallback<ThoResponse>() {
            @Override
            public void success(ThoResponse res) {
                for (Tho tho : res.getListTho()) {
                    if (tho.getCmnd().equals(cmndtho())) {
                        luong = tho.getLuongtheogio();
                    }

                }
                getView().getallThosuccess();

            }

            @Override
            public void failure(RestError error) {
                Log.e("error", error.toString());
            }
        });
    }

}
