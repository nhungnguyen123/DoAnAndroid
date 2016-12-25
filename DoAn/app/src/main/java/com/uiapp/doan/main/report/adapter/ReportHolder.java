package com.uiapp.doan.main.report.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.uiapp.doan.R;

import org.w3c.dom.Text;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hongnhung on 12/20/16.
 */

public class ReportHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.tv_ten_dich_vu)
    public TextView mTvTenDichVu;

    @Bind(R.id.tv_ngay_lam)
    public TextView mTvNgayLam;

    @Bind(R.id.gio_bat_dau)
    public TextView mTbGioGtDau;


    @Bind(R.id.tv_gio_ket_thu)
    public TextView mTvgioKetThuc;

    @Bind(R.id.tv_tien)
    public TextView mTvTien;


    public ReportHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
