package com.uiapp.doan.main.choosedetail.view;

import android.os.Bundle;

import com.uiapp.doan.R;
import com.uiapp.doan.base.fragment.BaseFragment;



public class ChooseDetailFragment extends BaseFragment {

    public static ChooseDetailFragment newInstance() {

        Bundle args = new Bundle();

        ChooseDetailFragment fragment = new ChooseDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_choose_detail;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }
}
