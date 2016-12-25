package com.uiapp.doan.main.report.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.uiapp.doan.R;
import com.uiapp.doan.dto.Order;
import com.uiapp.doan.dto.Report;
import com.uiapp.doan.main.allorder.adapter.OrderHolder;

import java.util.List;

/**
 * Created by hongnhung on 12/20/16.
 */

public class ReportAdapter extends RecyclerView.Adapter {

    List<Report> mListReport;

    public ReportAdapter(List<Report> mList) {
        this.mListReport = mList;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View order = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_report, null);
        return new ReportHolder(order);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ReportHolder holderreport = (ReportHolder) holder;
        final Report report = mListReport.get(position);
        String reportHave = new Gson().toJson(report);
        Log.e("reportHave", reportHave);

        holderreport.mTvTenDichVu.setText(report.getDichvu());
        holderreport.mTvNgayLam.setText(report.getNgaylam());

        int batdau = Integer.parseInt(report.getGiobatdau());
        int ketthu = Integer.parseInt(report.getGioketthuc());

        int chiabatdau = batdau/60;
        int chiaketthuc= ketthu/60;

        if (chiabatdau*60==batdau)
        {
            holderreport.mTbGioGtDau.setText(chiabatdau + "");
        }else {
            holderreport.mTbGioGtDau.setText(chiabatdau + ": 30");
        }

        if (chiaketthuc *60== ketthu)
        {
            holderreport.mTvgioKetThuc.setText(chiaketthuc + "");
        }else {
            holderreport.mTvgioKetThuc.setText(chiaketthuc + " : 30");
        }

        holderreport.mTvTien.setText(report.getTien());
    }

    @Override
    public int getItemCount() {
        if (mListReport == null) {
            return 0;
        } else {
            return mListReport.size();
        }
    }
}
