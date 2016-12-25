package com.uiapp.doan.main.menucontainer.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.uiapp.doan.AppConstants;
import com.uiapp.doan.MainApplication;
import com.uiapp.doan.MainListener;
import com.uiapp.doan.R;
import com.uiapp.doan.base.fragment.BaseFragment;
import com.uiapp.doan.base.presenter.IView;
import com.uiapp.doan.main.allorder.injection.DaggerAllOrderComponent;
import com.uiapp.doan.main.menucontainer.injection.DaggerMenuContainerComponent;
import com.uiapp.doan.main.menucontainer.injection.MenuContainerComponent;
import com.uiapp.doan.main.menucontainer.presenter.MenuContainerPresenter;
import com.uiapp.doan.main.welcom.WelcomeActivity;
import com.uiapp.doan.utils.LogUtils;

import javax.inject.Inject;

import butterknife.Bind;

/**
 * Created by hongnhung on 10/23/16.
 */

public class MenuContainerFragment extends BaseFragment implements IMenuContainerView {


    @Bind(R.id.ln_dang_xuat)
    LinearLayout mLnDangXuat;

    @Bind(R.id.tv_nguoi_sua)
    TextView mTvNguoiSua;

    @Bind(R.id.tv_quan_ly_giao_dich)
    TextView mTvQuanLyGiaoDich;

    @Bind(R.id.tv_all_staff)
    TextView mTvAllStaff;

    @Bind(R.id.tv_information_support)
    TextView mTvInformationSupport;

    @Bind(R.id.ln_feed_back)
    LinearLayout mLnChangPass;

    @Bind(R.id.ln_thong_ke)
    LinearLayout mLnThongKe;

    @Inject
    MenuContainerPresenter mPresenter;

    public MainListener mParentListener;


    public static MenuContainerFragment newInstance() {

        Bundle args = new Bundle();

        MenuContainerFragment fragment = new MenuContainerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MenuContainerComponent containerComponent = DaggerMenuContainerComponent.builder()
                .applicationComponent(MainApplication.getApplicationComponent(getActivity()))
                .build();
        containerComponent.inject(this);
        mPresenter.attachView(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_menu_container;
    }

    @Override
    protected void initData() {
        if (mPresenter.getQuyen().equalsIgnoreCase("")) {
//            mLnThongKe.setVisibility(View.GONE);
            mLnThongKe.setVisibility(View.VISIBLE);

        } else {
            mLnChangPass.setVisibility(View.VISIBLE);

        }

        if (mPresenter.getQuyen().equalsIgnoreCase("Tho")) {
//            mLnThongKe.setVisibility(View.GONE);
            mLnChangPass.setVisibility(View.VISIBLE);

//            mLnThongKe.setVisibility(View.VISIBLE);

        } else {
            mLnChangPass.setVisibility(View.GONE);

        }


        mLnThongKe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mParentListener.goReport();
            }
        });
        mLnDangXuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.goLogOut();
                Intent intent = new Intent(getActivity(), WelcomeActivity.class);
                startActivity(intent);
                getActivity().finish();
                Log.e("Dang nhap", "click");

            }
        });

        mTvNguoiSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("Click", "tim nguwoi");
                mParentListener.goChoose();
            }
        });

        mTvQuanLyGiaoDich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mParentListener.goAllOrder("");
                Log.e("all order", "ok");
            }
        });

        mTvAllStaff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                mParentListener.goAllStaff(null);
                mParentListener.goAllSaffOrder();
                LogUtils.logE(TAG, "all staff");
            }
        });
        mTvInformationSupport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mParentListener.goAboutUs();
                LogUtils.logE(TAG, "about us");
            }
        });

        mLnChangPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mParentListener.goChangePass();
                Log.e("clickchange", "Pass");
            }
        });

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mParentListener = (MainListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement " + MainListener.class.getSimpleName());
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mParentListener = null;
    }
//    @Override
//    public void onResume() {
//        super.onResume();
//        mPresenter.onResume();
//    }
//    @Override
//    public void onPause() {
//        super.onPause();
//        mPresenter.onPause();
//    }
//

    @Override
    public void onDestroy() {
        super.onDestroy();
//        mPresenter.detachView();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mParentListener = (MainListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement " + MainListener.class.getSimpleName());

        }
    }

    @Override
    protected void initListener() {

    }

    @Override
    public void goLogin() {
        mParentListener.goLogin();
    }

    @Override
    public void goThongTin() {
        mParentListener.goAboutUs();
    }

    @Override
    public void goAllStaff() {

    }

    @Override
    public void goAllOrder() {

    }

    @Override
    public void goChoose() {

    }
}
