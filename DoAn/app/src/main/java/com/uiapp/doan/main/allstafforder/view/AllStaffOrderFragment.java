package com.uiapp.doan.main.allstafforder.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.kaopiz.kprogresshud.KProgressHUD;
import com.uiapp.doan.MainApplication;
import com.uiapp.doan.MainListener;
import com.uiapp.doan.R;
import com.uiapp.doan.base.fragment.BaseFragment;
import com.uiapp.doan.main.allstaff.adapter.AdapterAllStaff;
import com.uiapp.doan.main.allstaff.presenter.AllStaffPresenter;
import com.uiapp.doan.main.allstafforder.adapter.AdapterAllStaffOrder;
import com.uiapp.doan.main.allstafforder.adapter.OnClickStaffOrder;
import com.uiapp.doan.main.allstafforder.injection.AllStaffOrderComponent;
import com.uiapp.doan.main.allstafforder.injection.AllStaffOrderModule;
import com.uiapp.doan.main.allstafforder.injection.DaggerAllStaffOrderComponent;
import com.uiapp.doan.main.allstafforder.presenter.AllStaffOrderPresenter;

import javax.inject.Inject;

import butterknife.Bind;

import static com.uiapp.doan.utils.CommonUtils.showSnackBar;

/**
 * Created by hongnhung on 11/22/16.
 */

public class AllStaffOrderFragment extends BaseFragment implements IAllStaffOrderView {

    MainListener mMainListener;

    @Inject
    AllStaffOrderPresenter mPresenter;

    private KProgressHUD mHubAddFood;

    public void showProgress() {
        mHubAddFood = KProgressHUD.create(getContext())
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE);
        mHubAddFood.show();
    }


    @Bind(R.id.all_staff_all)
    RecyclerView mRvAllStaff;

    public AdapterAllStaffOrder adapterAllStaff;

    public static AllStaffOrderFragment newInstance() {

        Bundle args = new Bundle();

        AllStaffOrderFragment fragment = new AllStaffOrderFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AllStaffOrderComponent component = DaggerAllStaffOrderComponent.builder()
                .applicationComponent(MainApplication.getApplicationComponent(getActivity()))
                .allStaffOrderModule(new AllStaffOrderModule())
                .build();
        component.inject(this);
        mPresenter.attachView(this);
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
    protected int getLayoutId() {
        return R.layout.fragment_all_staff_order;
    }

    @Override
    protected void initData() {
        showProgress();
        mPresenter.getAllStaff();
        mRvAllStaff.setHasFixedSize(true);
        mRvAllStaff.setLayoutManager(new GridLayoutManager(getContext(), 1));
        adapterAllStaff = new AdapterAllStaffOrder(mPresenter.listTho, getContext());
        mRvAllStaff.setAdapter(adapterAllStaff);

    }

    @Override
    protected void initListener() {

    }

    @Override
    public void getallstaffordersuccess() {
        adapterAllStaff.notifyDataSetChanged();
        mHubAddFood.dismiss();
        adapterAllStaff.setOnClickStaff(new OnClickStaffOrder() {
            @Override
            public void OnClickDetailStaff(String staffDetail) {
                mMainListener.goStaffDetail(staffDetail, null);
            }
        });

    }

    @Override
    public void getAllOrderError(String message) {
        mHubAddFood.dismiss();
        showSnackBar(getView(), "Lấy thông tin thất bại . !", Snackbar.LENGTH_SHORT);
    }
}
