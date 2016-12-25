package com.uiapp.doan.main.staffdetail.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.uiapp.doan.MainApplication;
import com.uiapp.doan.MainListener;
import com.uiapp.doan.R;
import com.uiapp.doan.base.fragment.BaseFragment;
import com.uiapp.doan.dto.Order;
import com.uiapp.doan.dto.Tho;
import com.uiapp.doan.main.allstaff.presenter.AllStaffPresenter;
import com.uiapp.doan.main.staffdetail.injection.DaggerStaffDetailComponent;
import com.uiapp.doan.main.staffdetail.injection.StaffDetailComponent;
import com.uiapp.doan.main.staffdetail.injection.StaffDetailModule;
import com.uiapp.doan.main.staffdetail.presenter.StaffDetailPresenter;
import com.uiapp.doan.utils.LogUtils;

import javax.inject.Inject;

import butterknife.Bind;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by hongnhung on 11/1/16.
 */

public class StaffDetailFragment extends BaseFragment implements IStaffDetailView {

    public String staffDetail;
    public String orderDetail;


    @Bind(R.id.tv_name)
    TextView mTvName;


    @Bind(R.id.tv_description_detail)
    TextView mTvDescription;

    @Bind(R.id.tv_address)
    TextView mTvAddress;


    @Bind(R.id.tv_time_experience)
    TextView mTvTimeExperience;


    @Bind(R.id.tv_gender)
    TextView mTvGender;


    @Bind(R.id.tv_birth_day)
    TextView mTvBirthDay;

    @Bind(R.id.tv_study)
    TextView mTvStudy;

    @Bind(R.id.tv_good)
    TextView mTvGood;

    @Bind(R.id.tv_review)
    TextView mTvReview;


    @Bind(R.id.img_avt)
     ImageView mImgavt;

    @Bind(R.id.btn_order_staff)
    Button mBtnOrderStaff;


    public Order order = new Order();
    public Tho tho = new Tho();
    @Inject
    StaffDetailPresenter mPresenter;

    MainListener mParentListener;

    public static StaffDetailFragment newInstance() {

        Bundle args = new Bundle();

        StaffDetailFragment fragment = new StaffDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();

        StaffDetailComponent component = DaggerStaffDetailComponent.builder()
                .applicationComponent(MainApplication.getApplicationComponent(getActivity()))
                .staffDetailModule(new StaffDetailModule())
                .build();
        component.inject(this);
        mPresenter.attachView(this);
        staffDetail = bundle.getString("STAFFDETAIL");
        orderDetail = bundle.getString("ORDER");
        order = new Gson().fromJson(orderDetail, Order.class);

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mParentListener = (MainListener) context;
        } catch (Exception e) {
            throw new ClassCastException(context.toString() + " must implement " + MainListener.class.getSimpleName());
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mParentListener = (MainListener) activity;
        } catch (Exception e) {
            throw new ClassCastException(activity.toString() + " must implement " + MainListener.class.getSimpleName());
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_staff_detail;
    }

    @Override
    protected void initData() {


        if (orderDetail == null) {

            mBtnOrderStaff.setVisibility(View.GONE);
        } else {
            Log.e("orderDetail", orderDetail);
        }

        tho = new Gson().fromJson(staffDetail, Tho.class);

        String sotruong="" ;
        for (int i=0;i<tho.getSotruong().size();i++)
        {
            sotruong= sotruong + tho.getSotruong().get(i).toString()+" ,";

        }

        mTvName.setText(tho.getHoten() + "");
        mTvAddress.setText(tho.getQuequan());
        mTvBirthDay.setText(tho.getNgaysinh());
        mTvGender.setText(tho.getGioitinh());
        mTvGood.setText(sotruong + "");
        mTvDescription.setText(tho.getMotakinhnghiem());
        if (tho.getSonamkinhnghiem()==null)
        {
            mTvTimeExperience.setText("");

        }else {
            mTvTimeExperience.setText(tho.getSonamkinhnghiem() + "");

        }
        mTvReview.setText(tho.getDanhgia());
        mTvStudy.setText(tho.getTrinhdohocvan());

        String hinhanh = "https://baocao.herokuapp.com/"+tho.getHinhanh()+"";
        Glide.with(getActivity()).load(hinhanh).centerCrop().into(mImgavt);
        LogUtils.logE(TAG, "detail: " + staffDetail + "");

        mBtnOrderStaff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO set order fragment
                //TODO thực hiện bổ sung thông tin thợ


                order.setHotenTho(tho.getHoten());
                order.setSdtTho(tho.getSodt());
                order.setCmndTho(tho.getCmnd());

                String setOrderDetail = new Gson().toJson(order);
                mParentListener.goOrderFragment(setOrderDetail);
            }
        });
    }

    @Override
    protected void initListener() {

    }
}
