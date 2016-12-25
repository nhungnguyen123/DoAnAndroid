package com.uiapp.doan.main.allorder.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.uiapp.doan.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hongnhung on 11/5/16.
 */

public class OrderHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.tv_ngaydat)
    TextView mTvNgayDat;

    @Bind(R.id.ln_order_item)
    LinearLayout mLnOrderItem;


    @Bind(R.id.tv_tentho_order)
    TextView mTvTenTho;

    @Bind(R.id.tv_tenkh_order)
    TextView mTvTenKhachhang;

    @Bind(R.id.tv_mota_order)
    TextView mTvMota;

    @Bind(R.id.tv_gio_bat_dau_order)
    TextView mTvGioBatDau;

    @Bind(R.id.tv_gio_ket_thuc_order)
    TextView mTvGioKetThuc;

    @Bind(R.id.tv_dien_thoai_khach_order)
    TextView mTvsoKhachHang;

    @Bind(R.id.tv_dien_thoai_tho_order)
    TextView mTvSotho;
    @Bind(R.id.tv_position)
    TextView mTvPo;


    public OrderHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
