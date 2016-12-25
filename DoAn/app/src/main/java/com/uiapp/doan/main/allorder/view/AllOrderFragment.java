package com.uiapp.doan.main.allorder.view;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IntegerRes;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.kaopiz.kprogresshud.KProgressHUD;
import com.uiapp.doan.AppConstants;
import com.uiapp.doan.MainApplication;
import com.uiapp.doan.MainListener;
import com.uiapp.doan.R;
import com.uiapp.doan.base.fragment.BaseFragment;
import com.uiapp.doan.main.allorder.adapter.AdapterOrder;
import com.uiapp.doan.main.allorder.adapter.ClickOrderDetail;
import com.uiapp.doan.main.allorder.injection.AllOrderComponent;
import com.uiapp.doan.main.allorder.injection.AllOrderModule;
import com.uiapp.doan.main.allorder.injection.DaggerAllOrderComponent;
import com.uiapp.doan.main.allorder.presenter.AllOrderPresenter;

import javax.inject.Inject;

import butterknife.Bind;

import static com.uiapp.doan.utils.CommonUtils.showSnackBar;

/**
 * Created by hongnhung on 10/25/16.
 */

public class AllOrderFragment extends BaseFragment implements IAllOrderView {

    private KProgressHUD mHubAddFood;
    public void showProgress() {
        mHubAddFood = KProgressHUD.create(getContext())
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE);
        mHubAddFood.show();
    }
    @Inject
    AllOrderPresenter mPresenter;

    MainListener mMainListener;

    @Bind(R.id.rv_all_order)
    RecyclerView mRvAllOrder;

    AdapterOrder mAdapterOrder;

    public String orderTho;
    public String orderKhach;
    public String cmndTho;


    public static AllOrderFragment newInstance() {

        Bundle args = new Bundle();

        AllOrderFragment fragment = new AllOrderFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mMainListener = (MainListener) context;
        } catch (Exception e) {
            throw new ClassCastException(context.toString() + " must implement " + MainListener.class.getSimpleName());
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mMainListener = (MainListener) activity;
        } catch (Exception e) {
            throw new ClassCastException(activity.toString() + " must implement " + MainListener.class.getSimpleName());
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AllOrderComponent component = DaggerAllOrderComponent.builder()
                .applicationComponent(MainApplication.getApplicationComponent(getActivity()))
                .allOrderModule(new AllOrderModule())
                .build();
        Bundle bundle = this.getArguments();
        orderTho = bundle.getString("ALLORDERDETAIL");


        component.inject(this);
        mPresenter.attachView(this);

//        Log.e("cmndPre", mPresenter.getKeyCmnd());

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_all_order;
    }

    @Override
    protected void initData() {
        showProgress();


        if (mPresenter.getQuyen() == null) {
            showSnackBar(getView(), "Bạn cần đăng nhập để sử dụng tính năng này !", Snackbar.LENGTH_SHORT);

        } else {
            if (mPresenter.getQuyen().equalsIgnoreCase(AppConstants.QUYEN)) {
                mPresenter.getAllOrder();
                Log.e("quyen", "KhachHang");
                mRvAllOrder.setHasFixedSize(true);
                mRvAllOrder.setLayoutManager(new GridLayoutManager(getContext(), 1));
                mAdapterOrder = new AdapterOrder(mPresenter.mListOrderKhachHangSort);
                mRvAllOrder.setAdapter(mAdapterOrder);
            } else {
                mPresenter.getAllOrderTho();
                mRvAllOrder.setHasFixedSize(true);
                mRvAllOrder.setLayoutManager(new GridLayoutManager(getContext(), 1));
                mAdapterOrder = new AdapterOrder(mPresenter.mListOrderThoSort);
                mRvAllOrder.setAdapter(mAdapterOrder);
            }
        }


    }

    @Override
    protected void initListener() {

    }

    @Override
    public void allOrderSuccess() {
        mHubAddFood.dismiss();
        mAdapterOrder = new AdapterOrder(mPresenter.mListOrderKhachHangSort);
        mRvAllOrder.setAdapter(mAdapterOrder);
        mAdapterOrder.notifyDataSetChanged();
        mAdapterOrder.setOrderDetail(new ClickOrderDetail() {
            @Override
            public void orderDetail(String orderDetail) {
                Log.e("clickorderDetail", orderDetail + "");
                mMainListener.goOrderDetail(orderDetail);
            }
        });


    }

    @Override
    public void allOrderError(String message) {
        mHubAddFood.dismiss();
        showSnackBar(getView(), "Lấy thông tin thất bại . !", Snackbar.LENGTH_SHORT);
        Log.e("error", message + "");
    }

    @Override
    public void allOrderThoSuccess() {
        mHubAddFood.dismiss();
        mAdapterOrder.notifyDataSetChanged();
        mAdapterOrder.setOrderDetail(new ClickOrderDetail() {
            @Override
            public void orderDetail(String orderDetail) {
                Log.e("clickorderDetail", orderDetail + "");
                mMainListener.goOrderDetail(orderDetail);
            }
        });
    }

    @Override
    public void allOrderThoError(String message) {
        Log.e("errorallTho", message + "");
        showSnackBar(getView(), "Lấy thông tin thất bại . !", Snackbar.LENGTH_SHORT);
        mHubAddFood.dismiss();
    }

//    @Override
//    public void allOrderKhachHangSueecss() {
//        mAdapterOrder.notifyDataSetChanged();
//        mAdapterOrder.setOrderDetail(new ClickOrderDetail() {
//            @Override
//            public void orderDetail(String orderDetail) {
//                Log.e("clickorderDetail", orderDetail + "");
//                mMainListener.goOrderDetail(orderDetail);
//            }
//        });
//    }
//
//    @Override
//    public void allOrderKhachHangError(String message) {
//        Log.e("errorallkhachhang", message + "");
//    }
}
