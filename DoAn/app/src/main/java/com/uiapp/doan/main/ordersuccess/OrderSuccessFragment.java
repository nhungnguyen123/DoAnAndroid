package com.uiapp.doan.main.ordersuccess;

import android.os.Bundle;

import com.uiapp.doan.R;
import com.uiapp.doan.base.fragment.BaseFragment;

/**
 * Created by hongnhung on 12/4/16.
 */

public class OrderSuccessFragment extends BaseFragment {

    public static OrderSuccessFragment newInstance() {

        Bundle args = new Bundle();

        OrderSuccessFragment fragment = new OrderSuccessFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_order_success;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }
}
