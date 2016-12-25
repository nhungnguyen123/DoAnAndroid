package com.uiapp.doan.main.report.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.kaopiz.kprogresshud.KProgressHUD;
import com.uiapp.doan.AppConstants;
import com.uiapp.doan.MainApplication;
import com.uiapp.doan.R;
import com.uiapp.doan.base.fragment.BaseFragment;
import com.uiapp.doan.dto.Report;
import com.uiapp.doan.injection.component.ApplicationComponent;
import com.uiapp.doan.main.allorder.adapter.AdapterOrder;
import com.uiapp.doan.main.report.adapter.ReportAdapter;
import com.uiapp.doan.main.report.injection.DaggerReprtComponent;
import com.uiapp.doan.main.report.injection.ReportModule;
import com.uiapp.doan.main.report.injection.ReprtComponent;
import com.uiapp.doan.main.report.presenter.ReportPresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;

import static com.uiapp.doan.utils.CommonUtils.showSnackBar;

/**
 * Created by hongnhung on 12/20/16.
 */

public class ReportFragment extends BaseFragment implements IReportView {

    private KProgressHUD mHubAddFood;

    public void showProgress() {
        mHubAddFood = KProgressHUD.create(getContext())
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE);
        mHubAddFood.show();
    }

    @Inject
    ReportPresenter mPresenter;


    @Bind(R.id.btn_tim)
    Button mBtnTim;


    @Bind(R.id.edt_thang)
    EditText mEdtThang;

    @Bind(R.id.edt_nam)
    EditText mEdtNam;

    @Bind(R.id.tv_tong_tien)
    TextView mTvTien;


    public List<Report> mListReport;

    public List<Report> mListReportField;

    ReportAdapter mAdapterReport;
    @Bind(R.id.rv_thong_ke)
    RecyclerView mRvReport;

    public static ReportFragment newInstance() {

        Bundle args = new Bundle();

        ReportFragment fragment = new ReportFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ReprtComponent component = DaggerReprtComponent.builder()
                .applicationComponent(MainApplication.getApplicationComponent(getActivity()))
                .reportModule(new ReportModule())
                .build();

        component.inject(this);
        mPresenter.attachView(this);
        mListReport = new ArrayList<>();
        mListReportField = new ArrayList<>();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.report_fragment;
    }

    @Override
    protected void initData() {
        mRvReport.setHasFixedSize(true);
        mRvReport.setLayoutManager(new GridLayoutManager(getContext(), 1));
        if (mPresenter.getQuyen() == null) {
            showSnackBar(getView(), "Bạn cần đăng nhập để sử dụng tính năng này !", Snackbar.LENGTH_SHORT);

        } else {
            if (mPresenter.getQuyen().equalsIgnoreCase(AppConstants.QUYEN)) {
                mPresenter.getAllOrder();
                showProgress();
                mAdapterReport = new ReportAdapter(mListReport);
                mRvReport.setAdapter(mAdapterReport);
            } else {
                mPresenter.getAllTho();
                showProgress();
                mAdapterReport = new ReportAdapter(mListReport);
                mRvReport.setAdapter(mAdapterReport);

            }
        }


    }

    @Override
    protected void initListener() {

    }

    @Override
    public void allOrderSuccess() {
        Log.e("allReportkhach", mPresenter.mListReportKhach.size() + "");
        mAdapterReport = new ReportAdapter(mPresenter.mListReportKhach);
        mRvReport.setAdapter(mAdapterReport);
        mAdapterReport.notifyDataSetChanged();
        mTvTien.setText(mPresenter.tienkhach + "");
        mHubAddFood.dismiss();
        mBtnTim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListReportField.clear();
                showProgress();
                Log.e("clicksreport", "clcik");
                String thang = mEdtThang.getText().toString();
                String nam = mEdtNam.getText().toString();
                String tong = thang + "/" + nam;
                Log.e("thongtime", tong + "");
                for (int i = 0; i < mPresenter.mListReportKhach.size(); i++) {

                    //TODO cần xem lại phần này.
                    Log.e("ngayhave", mPresenter.mListReportKhach.get(i).getNgaylam() + "");
                    String stringhave = mPresenter.mListReportKhach.get(i).getNgaylam().substring(3);
                    Log.e("stringhavereport", stringhave);

                    if (stringhave.equalsIgnoreCase(tong)) {
                        mListReportField.add(mPresenter.mListReportKhach.get(i));
                    }
                }

                mAdapterReport = new ReportAdapter(mListReportField);
                mRvReport.setAdapter(mAdapterReport);
                mAdapterReport.notifyDataSetChanged();
                int tien = 0;
                for (int i = 0; i < mListReportField.size(); i++) {
                    tien = tien + Integer.parseInt(mListReportField.get(i).getTien().toString());
                }
                mTvTien.setText(tien + "");
                mHubAddFood.dismiss();
                Log.e("Size", mListReportField.size() + "");
            }


        });


    }

    @Override
    public void allOrderError(String message) {
        mHubAddFood.dismiss();
        showSnackBar(getView(), "Đã có lỗi kết nối , hãy thử lại  !", Snackbar.LENGTH_SHORT);
    }

    @Override
    public void allOrderThoSuccess() {

        Log.e("allReportTho", mPresenter.mListReportTho.size() + "");
        mAdapterReport = new ReportAdapter(mPresenter.mListReportTho);
        mRvReport.setAdapter(mAdapterReport);
        mTvTien.setText(mPresenter.tientho + "");
        mAdapterReport.notifyDataSetChanged();
        mHubAddFood.dismiss();
        mBtnTim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("clicksreport", "clcik");
                showProgress();
                mListReportField.clear();
                String thang = mEdtThang.getText().toString();
                String nam = mEdtNam.getText().toString();
                String tong = thang + "/" + nam;
                Log.e("thongtime", tong + "");
                for (int i = 0; i < mPresenter.mListReportTho.size(); i++) {

                    //TODO cần xem lại phần này.
                    Log.e("ngayhave", mPresenter.mListReportTho.get(i).getNgaylam() + "");
                    String stringhave = mPresenter.mListReportTho.get(i).getNgaylam().substring(3);
                    Log.e("stringhavereport", stringhave);

                    if (stringhave.equalsIgnoreCase(tong)) {
                        mListReportField.add(mPresenter.mListReportTho.get(i));
                    }
                }

                mAdapterReport = new ReportAdapter(mListReportField);
                mRvReport.setAdapter(mAdapterReport);
                int tien = 0;
                for (int i = 0; i < mListReportField.size(); i++) {
                    tien = tien + Integer.parseInt(mListReportField.get(i).getTien().toString());
                }
                mTvTien.setText(tien + "");
                mHubAddFood.dismiss();


                mAdapterReport.notifyDataSetChanged();
                Log.e("Size", mListReportField.size() + "");
            }


        });
    }

    @Override
    public void allOrderThoError(String message) {

        mHubAddFood.dismiss();
        showSnackBar(getView(), "Đã có lỗi kết nối , hãy thử lại  !", Snackbar.LENGTH_SHORT);
    }

    @Override
    public void getallThosuccess() {

        mPresenter.getAllOrderTho();
        mAdapterReport = new ReportAdapter(mPresenter.mListReportTho);
        mRvReport.setAdapter(mAdapterReport);
        mHubAddFood.dismiss();
    }
}
