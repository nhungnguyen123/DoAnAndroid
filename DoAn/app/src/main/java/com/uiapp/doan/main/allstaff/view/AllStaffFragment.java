package com.uiapp.doan.main.allstaff.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;

import com.google.gson.Gson;
import com.kaopiz.kprogresshud.KProgressHUD;
import com.uiapp.doan.MainApplication;
import com.uiapp.doan.MainListener;
import com.uiapp.doan.R;
import com.uiapp.doan.base.fragment.BaseFragment;
import com.uiapp.doan.dto.Order;
import com.uiapp.doan.dto.Tho;
import com.uiapp.doan.main.allstaff.adapter.AdapterAllStaff;
import com.uiapp.doan.main.allstaff.adapter.OnClickStaff;
import com.uiapp.doan.main.allstaff.injection.AllStaffComponent;
import com.uiapp.doan.main.allstaff.injection.AllStaffModule;
import com.uiapp.doan.main.allstaff.injection.DaggerAllStaffComponent;
import com.uiapp.doan.main.allstaff.presenter.AllStaffPresenter;
import com.uiapp.doan.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;

import static com.uiapp.doan.utils.CommonUtils.showSnackBar;

/**
 * Created by hongnhung on 10/25/16.
 */

public class AllStaffFragment extends BaseFragment implements IAllStaffView {
    private KProgressHUD mHubAddFood;
    MainListener mMainListener;
    public AdapterAllStaff adapterAllStaff;
    @Bind(R.id.rv_all_staff)
    RecyclerView mRvAllStaff;

    public Order order = new Order();
    public String orderString = "";


    public List<Tho> listThoYeuCau = new ArrayList<>();
    public List<Tho> listthoFinal = new ArrayList<>();


    @Inject
    AllStaffPresenter mPresenter;

    public static AllStaffFragment newInstance() {

        Bundle args = new Bundle();

        AllStaffFragment fragment = new AllStaffFragment();
        fragment.setArguments(args);
        return fragment;
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
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AllStaffComponent component = DaggerAllStaffComponent.builder()
                .applicationComponent(MainApplication.getApplicationComponent(getActivity()))
                .allStaffModule(new AllStaffModule())
                .build();
        component.inject(this);
        mPresenter.attachView(this);
        listThoYeuCau = new ArrayList<>();
        listthoFinal = new ArrayList<>();


        Bundle bundle = this.getArguments();
        orderString = bundle.getString("REQUEST");
        Log.e("REQUEST", orderString + "");

        Log.e("QuanOrderString", orderString + "");
        order = new Gson().fromJson(orderString, Order.class);
        Log.e("quanchoall", order.getQuan() + "");
        Log.e("khuvucorder", order.getTenkhuvuc() + "");

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_all_staff;
    }

    @Override
    protected void initData() {
        showProgress();
        mPresenter.getallstaff();
        mPresenter.getAllLicBantho();

        mRvAllStaff.setHasFixedSize(true);
        mRvAllStaff.setLayoutManager(new GridLayoutManager(getContext(), 1));

        adapterAllStaff = new AdapterAllStaff(listThoYeuCau, getContext());
        mRvAllStaff.setAdapter(adapterAllStaff);


    }

    @Override
    protected void initListener() {

    }

    @Override
    public void getallstaffsuccess() {

        for (int i = 0; i < mPresenter.listTho.size(); i++) {
            Tho tho = mPresenter.listTho.get(i);
            Log.e("sotruongsize", tho.getSotruong().size() + "");
            for (int j = 0; j < mPresenter.listTho.get(i).getSotruong().size(); j++) {
                if (mPresenter.listTho.get(i).getSotruong().get(j).equalsIgnoreCase(order.getDichvuyc().get(0))) {
                    if (tho.getDiachi().getTenkhuvuc().equalsIgnoreCase(order.getTenkhuvuc())) {
                        listThoYeuCau.add(tho);
                    }
                }
            }
        }

        for (int i = 0; i < mPresenter.listLichBanTho.size(); i++) {
            if (mPresenter.listLichBanTho.get(i).getNgay().equalsIgnoreCase(order.getNgaylam())) {
                int start = Integer.parseInt(order.getGiobatdau());
                int end = Integer.parseInt(order.getGioketthuc());
                int db = mPresenter.listLichBanTho.get(i).getGiobd();
                int kt = mPresenter.listLichBanTho.get(i).getGiokt();
                if (kiemtrathoigian(start, end, db, kt)) {
                    for (int k = 0; k < listThoYeuCau.size(); k++) {
                        if (listThoYeuCau.get(k).getCmnd().equalsIgnoreCase(mPresenter.listLichBanTho.get(i).getCmnd()))
                            listthoFinal.add(listThoYeuCau.get(k));
                    }
                } else {

                }

            } else {
                for (int k = 0; k < listThoYeuCau.size(); k++) {
                    if (listThoYeuCau.get(k).getCmnd().equalsIgnoreCase(mPresenter.listLichBanTho.get(i).getCmnd()))
                        listthoFinal.add(listThoYeuCau.get(k));

                }

            }
        }
        mHubAddFood.dismiss();


        //TODO set lai

        adapterAllStaff.notifyDataSetChanged();
        if (listThoYeuCau.size() == 0) {
            Log.e("listthoyeucau", "0");
            showSnackBar(getView(), "Không có thợ nào thoã mãn yêu cầu của bạn. Hãy thực hiện lại lựa chọn khác!", Snackbar.LENGTH_SHORT);
        } else {
            for (int i = 0; i < listThoYeuCau.size(); i++) {
                Log.e("Khuvuxtho", listThoYeuCau.get(i).getDiachi().getTenkhuvuc() + "");
            }
            adapterAllStaff = new AdapterAllStaff(listThoYeuCau, getContext());
            Log.e("diachitenkhuvuc", listThoYeuCau.get(0).getDiachi().getTenkhuvuc() + "");
            mRvAllStaff.setAdapter(adapterAllStaff);

        }

        adapterAllStaff.setOnClickStaff(new OnClickStaff() {
            @Override
            public void OnClickDetailStaff(String detail) {
                //TODO gửi thợ qua
                mMainListener.goStaffDetail(detail, orderString);
            }

            @Override
            public void OnClickOrderStaff(String idStaff) {
                LogUtils.logE(TAG, "idStaff hide" + idStaff);
                Log.e("staffdetail", idStaff);

                Tho tho = new Gson().fromJson(idStaff, Tho.class);
                order.setHotenTho(tho.getHoten());
                order.setCmndTho(tho.getCmnd());
                order.setSdtTho(tho.getSodt());
                Log.e("quanchoallorder", order.getQuan() + "");
                String orderFinal = new Gson().toJson(order);
                mMainListener.goOrderFragment(orderFinal);


            }
        });
    }

    @Override
    public String getallstafferror(String message) {
        LogUtils.logE(TAG, "error" + message);
        return message;
    }

    @Override
    public void getAllLichBanThoSuccess() {
        Log.e("success", "lichbantho");
        Log.e("lichbanhthosuccess", mPresenter.listLichBanTho.size() + "");

    }

    @Override
    public void getAllLichBanThoError(String message) {
        LogUtils.logE(TAG, "getallLichBanThoerror" + message);
        showSnackBar(getView(), "Đã có lỗi kết nối , hãy thử lại  !", Snackbar.LENGTH_SHORT);
    }


    public boolean checkNgay(String ngaykhach, String ngaytho) {
        if (ngaykhach.equalsIgnoreCase(ngaytho)) {
            return false;
        } else {
            return true;
        }
    }

    public boolean kiemtrathoigian(int start, int end, int bd, int kt) {
        if (start < bd && end < kt && end > start) return false;
        if (start > bd && end > kt && start < kt) return false;
        if (start < bd && end > kt) return false;
        return true;
    }

    public void showProgress() {
        mHubAddFood = KProgressHUD.create(getContext())
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE);
        mHubAddFood.show();
    }
}
