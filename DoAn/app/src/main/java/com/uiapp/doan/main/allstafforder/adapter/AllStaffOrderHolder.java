package com.uiapp.doan.main.allstafforder.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.uiapp.doan.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by hongnhung on 11/22/16.
 */

public class AllStaffOrderHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.tv_name)
    TextView mTvName;


    @Bind(R.id.tv_description)
    TextView mTvDescription;


    @Bind(R.id.tv_year)
    TextView mTvYear;

    @Bind(R.id.tv_ngay_sinh)
    TextView mTvBirthDay;


    @Bind(R.id.btn_detail)
    Button mBtnDetail;


    @Bind(R.id.img_avt_order)
    public ImageView imgAvtOrder;


    public AllStaffOrderHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
