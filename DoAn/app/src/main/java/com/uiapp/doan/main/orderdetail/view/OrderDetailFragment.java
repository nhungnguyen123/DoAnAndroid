package com.uiapp.doan.main.orderdetail.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.uiapp.doan.AppConstants;
import com.uiapp.doan.MainActivity;
import com.uiapp.doan.MainApplication;
import com.uiapp.doan.R;
import com.uiapp.doan.base.fragment.BaseFragment;
import com.uiapp.doan.dto.Order;
import com.uiapp.doan.interactor.api.request.LichBanThoRequest;
import com.uiapp.doan.main.allstaff.presenter.AllStaffPresenter;
import com.uiapp.doan.main.orderdetail.injection.DaggerOrderDetailComponent;
import com.uiapp.doan.main.orderdetail.injection.OrderDetailComponent;
import com.uiapp.doan.main.orderdetail.injection.OrderDetailModule;
import com.uiapp.doan.main.orderdetail.presenter.OrderDetailPresenter;

import javax.inject.Inject;

import butterknife.Bind;

import static butterknife.ButterKnife.Finder.VIEW;
import static com.uiapp.doan.utils.CommonUtils.showSnackBar;


public class OrderDetailFragment extends BaseFragment implements IOrderDetailView {


    @Bind(R.id.tv_phone_Tho)
    TextView mTvPhonetho;

    @Bind(R.id.tv_name)
    TextView mTvNane;


    @Bind(R.id.tv_address)
    TextView mTvAddress;

    @Bind(R.id.tv_district)
    TextView mTvQuan;


    @Bind(R.id.tv_day)
    TextView mTvDay;


    @Bind(R.id.tv_time_start)
    TextView mTvTimestart;

    @Bind(R.id.tv_time_end)
    TextView mTvTimeEnd;

    @Bind(R.id.tv_service)
    TextView mTvService;

    @Bind(R.id.tv_pay)
    TextView mTvPay;

    @Bind(R.id.tv_danhgia)
    EditText mEdtDanhGia;

    @Bind(R.id.btn_ketthuc)
    Button mBtnKetThuc;


    @Bind(R.id.tv_description_work)
    TextView mTvMoTaCongViec;
    @Bind(R.id.btn_tuchoi)
    Button mBtnTuChoi;


    @Bind(R.id.btn_update)
    Button mBtnUpdate;

    @Bind(R.id.btn_xac_nhan)
    Button mBtnXacNhan;


    @Bind(R.id.ln_khach_hang)
    LinearLayout mLnKhachHang;

    @Bind(R.id.tv_trang_thai_order)
    TextView mTvTrangThaiOrder;

    public String Trangthai = "";

    public String orderDetail;

    @Inject
    OrderDetailPresenter mPresenter;

    public static OrderDetailFragment newInstance() {

        Bundle args = new Bundle();

        OrderDetailFragment fragment = new OrderDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        OrderDetailComponent component = DaggerOrderDetailComponent.builder()
                .applicationComponent(MainApplication.getApplicationComponent(getActivity()))
                .orderDetailModule(new OrderDetailModule())
                .build();
        component.inject(this);
        mPresenter.attachView(this);


        Bundle bundle = this.getArguments();
        orderDetail = bundle.getString("ORDERDETAIL");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_order_detail;
    }

    @Override
    protected void initData() {


        final Order order = new Gson().fromJson(orderDetail, Order.class);
        Log.e("orderId", order.getId());

        String mayc = order.getMayc();
        if (mayc == null) {
            Log.e("khong lay duocw", "mayc");
        } else {
            Log.e("mayc", mayc + "");
        }


        if (mPresenter.getQuyen().equalsIgnoreCase(AppConstants.QUYEN)) {
            mBtnTuChoi.setVisibility(View.GONE);
            mBtnKetThuc.setVisibility(View.GONE);
            mBtnUpdate.setVisibility(View.VISIBLE);
            mLnKhachHang.setVisibility(View.VISIBLE);
            mBtnXacNhan.setVisibility(View.GONE);
        } else {
            mBtnUpdate.setVisibility(View.GONE);
            if (order.getTrangthai().equalsIgnoreCase(AppConstants.TRANGTHAIBATDAU)) {
                mBtnXacNhan.setVisibility(View.VISIBLE);
                mBtnTuChoi.setVisibility(View.VISIBLE);
                mBtnKetThuc.setVisibility(View.INVISIBLE);
            } else if (order.getTrangthai().equalsIgnoreCase(AppConstants.TRANGTHAIDANGTHUCHIEN)) {
                mBtnTuChoi.setVisibility(View.GONE);
                mBtnXacNhan.setVisibility(View.GONE);
            } else if (order.getTrangthai().equalsIgnoreCase(AppConstants.TRANGTHAITUCHOI)) {
                mBtnXacNhan.setVisibility(View.GONE);
                mBtnTuChoi.setVisibility(View.GONE);
                mBtnKetThuc.setVisibility(View.GONE);
            } else if (order.getTrangthai().equalsIgnoreCase(AppConstants.TRANGTHAIXACNHAN)) {
                mBtnXacNhan.setVisibility(View.GONE);
                mBtnTuChoi.setVisibility(View.GONE);
                mBtnKetThuc.setVisibility(View.VISIBLE);
            } else {
                mBtnXacNhan.setVisibility(View.GONE);
                mBtnTuChoi.setVisibility(View.GONE);
                mBtnKetThuc.setVisibility(View.GONE);
            }


        }

        String jsonget = new Gson().toJson(order);
        mTvPhonetho.setText(order.getHotenTho());
        mTvAddress.setText(order.getDiachi());
        mTvMoTaCongViec.setText(order.getMota());
        mTvNane.setText(order.getHotenKH());
        mEdtDanhGia.setText(order.getNhanxet());
        mTvPay.setText(order.getPhidichvu());
        mTvDay.setText(order.getNgaylam());
        mTvTrangThaiOrder.setText(order.getTrangthai());
        mTvQuan.setText(order.getQuan());
        mTvService.setText(order.getDichvuyc().get(0));


        Log.e("danhgia", order.getNhanxet() + "");
        if (order.getNhanxet() != null) {
            mEdtDanhGia.setText(order.getNhanxet() + "");
            mBtnUpdate.setVisibility(View.GONE);
        }
        if (order.getGiobatdau() == null) {

        } else {
            int intbatdau = Integer.parseInt(order.getGiobatdau());
            int giobatdau = intbatdau / 60;

            if (giobatdau * 60 == intbatdau) {
                mTvTimestart.setText(intbatdau / 60 + "");
            } else {
                mTvTimestart.setText(intbatdau / 60 + " : 30");
            }
        }


        if (order.getGioketthuc() == null) {

        } else {
            int intketthuc = Integer.parseInt(order.getGioketthuc());
            int gioketthu = intketthuc / 60;
            if (gioketthu * 60 == intketthuc) {
                mTvTimeEnd.setText(intketthuc / 60 + "");
            } else {
                mTvTimeEnd.setText(intketthuc / 60 + " : 30");
            }
        }
        Log.e("jsonget", jsonget + "");

        mBtnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                order.setNhanxet(mEdtDanhGia.getText().toString());
                mPresenter.updateOrder(order.getId(), order);
            }
        });

        mBtnTuChoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (order.getTrangthai().equalsIgnoreCase(AppConstants.TRANGTHAIBATDAU)) {
                    order.setTrangthai("Từ chối");
                    Trangthai = "Từ chối";
                    mPresenter.updateOrder(order.getId(), order);

                }
            }
        });
        mBtnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (order.getTrangthai().equalsIgnoreCase(AppConstants.TRANGTHAIBATDAU)) {
                    order.setTrangthai("Xác nhận");
                    Trangthai = "Xác nhận";
                    mPresenter.updateOrder(order.getId(), order);
                    LichBanThoRequest lichBanThoRequest = new LichBanThoRequest();
                    lichBanThoRequest.setCmnd(mPresenter.getCmnd());
                    lichBanThoRequest.setHotenKH(order.getHotenKH());
                    lichBanThoRequest.setGiobd(order.getGiobatdau());
                    lichBanThoRequest.setGiokt(order.getGioketthuc());
                    lichBanThoRequest.setNgay(order.getNgaylam());
                    mPresenter.createLichBantho(lichBanThoRequest);

                }
            }
        });
        mBtnKetThuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("clickketthuc", "click");

                if (order.getTrangthai().equalsIgnoreCase(AppConstants.TRANGTHAIBATDAU) || order.getTrangthai().equalsIgnoreCase(AppConstants.TRANGTHAIDANGTHUCHIEN)) {
                    order.setTrangthai("Kết thúc");
                    Trangthai = "Kết thúc";
                    Log.e("ketthu", "click");
                    mPresenter.updateOrder(order.getId(), order);

                }
            }
        });

    }

    @Override
    protected void initListener() {

    }

    @Override
    public void updateOrderSuccess() {
        showSnackBar(getView(), " Cập nhật đơn hàng thành công !", Snackbar.LENGTH_SHORT);
        if (Trangthai=="Từ chối")
        {

            Intent intent = new Intent(this.getActivity(), MainActivity.class);
            getActivity().finish();
            startActivity(intent);

        }else {
            mBtnUpdate.setVisibility(View.GONE);
        }


    }

    @Override
    public void updateOrderError(String message) {
        showSnackBar(getView(), " Cập nhật đơn hàng thất bạt ! " + message + "", Snackbar.LENGTH_SHORT);

    }

    @Override
    public void createlichBansuccess() {
        showSnackBar(getView(), " Cập nhật đơn hàng và lịch bận thợ thành công  ! ", Snackbar.LENGTH_SHORT);
        mBtnUpdate.setVisibility(View.GONE);
        Intent intent = new Intent(this.getActivity(), MainActivity.class);
        getActivity().finish();
        startActivity(intent);
    }

    @Override
    public void createLichError(String message) {
        showSnackBar(getView(), " Cập nhật đơn hàng và lịch bận thợ thành công  ! ", Snackbar.LENGTH_SHORT);
        mBtnUpdate.setVisibility(View.GONE);
        Intent intent = new Intent(this.getActivity(), MainActivity.class);
        getActivity().finish();
        startActivity(intent);
//        showSnackBar(getView(), " Cập nhật đơn lịch bận thợ thất bại ! " + message + "", Snackbar.LENGTH_SHORT);
    }
}
