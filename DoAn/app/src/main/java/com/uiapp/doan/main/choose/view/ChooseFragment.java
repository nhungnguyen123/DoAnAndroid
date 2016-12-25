package com.uiapp.doan.main.choose.view;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.kaopiz.kprogresshud.KProgressHUD;
import com.uiapp.doan.MainApplication;
import com.uiapp.doan.MainListener;
import com.uiapp.doan.R;
import com.uiapp.doan.base.fragment.BaseFragment;
import com.uiapp.doan.dto.Order;
import com.uiapp.doan.interactor.api.network.ApiClient;
import com.uiapp.doan.interactor.api.network.RestCallback;
import com.uiapp.doan.interactor.api.network.RestError;
import com.uiapp.doan.interactor.api.response.DichVuResponse;
import com.uiapp.doan.interactor.api.response.QuanResponse;
import com.uiapp.doan.main.choose.injection.ChooseModule;
import com.uiapp.doan.main.choose.injection.DaggerIChooseComponent;
import com.uiapp.doan.main.choose.injection.IChooseComponent;
import com.uiapp.doan.main.choose.presenter.ChoosePresenter;
import com.uiapp.doan.utils.LogUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.uiapp.doan.utils.CommonUtils.showSnackBar;


public class ChooseFragment extends BaseFragment implements IChooseView {


    private KProgressHUD mHubAddFood;

    public void showProgress() {
        mHubAddFood = KProgressHUD.create(getContext())
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE);
        mHubAddFood.show();
    }

    public final static int REQUEST_CODE_DIALOG = 200;
    @Bind(R.id.pick_time_from)
    TextView mBtnTimeFrom;

    @Bind(R.id.pick_time_to)
    TextView mBtnTimeTo;

    @Bind(R.id.pick_day)
    TextView mBtnPickDay;

    @Bind(R.id.spn_choose_dich_vu)
    Spinner mSpDichVu;

    @Bind(R.id.spn_choose_district)
    Spinner mSpQuan;

    @Bind(R.id.btn_tim_kiem)
    Button mBtnTimKiem;

    Calendar cal;

    public static String ngaychon;
    public static int giobatdau = 0;
    public static int gioketthuc = 0;
    public static String quanchon;
    public static String dichvuchon;
    public static String ngaydatyeucau;
    public int gia = 0;


    @Inject
    ChoosePresenter mPresenter;
    public ArrayAdapter<String> quanAdapter;
    public ArrayAdapter<String> dichvuAdapter;

    MainListener mParentListener;

    private static TextView mTvDayChoice;
    private static TextView mTvTimeFrom;
    private static TextView mTvTimeTo;

    public boolean okNgay, okGioBatDau, okGioKetThuc, okDichVu, okQuan;


    public static ChooseFragment newInstance() {
        Bundle args = new Bundle();
        ChooseFragment fragment = new ChooseFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        IChooseComponent conChooseComponent = DaggerIChooseComponent.builder()
                .applicationComponent(MainApplication.getApplicationComponent(getActivity()))
                .chooseModule(new ChooseModule())
                .build();
        conChooseComponent.inject(this);
        mPresenter.attachView(this);


    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_choose;
    }

    @Override
    protected void initData() {

        mPresenter.getAllDichVu();
        mPresenter.getAllQuan();
        showProgress();
        dichvuAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, mPresenter.listdichvu);
        dichvuAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpDichVu.setAdapter(dichvuAdapter);

        mSpDichVu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                gia = mPresenter.dichVuResponse.getDichVus().get(position).getPhiTheoGio();
                Log.e("giadichvu", gia + "");

                dichvuchon = item;

                Toast.makeText(parent.getContext(), "dich vu: " + item, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        quanAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, mPresenter.listquan);
        quanAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpQuan.setAdapter(quanAdapter);
        mSpQuan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                quanchon = item;
                Toast.makeText(parent.getContext(), "Quan: " + item, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        cal = Calendar.getInstance();
        SimpleDateFormat dft = null;
        dft = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        ngaydatyeucau = dft.format(cal.getTime());

        Log.e("ngayhientai", ngaydatyeucau + "");

        mTvDayChoice = (TextView) getActivity().findViewById(R.id.tv_day_choice);
        mTvTimeFrom = (TextView) getActivity().findViewById(R.id.tv_time_from);
        mTvTimeTo = (TextView) getActivity().findViewById(R.id.tv_time_to);
        mBtnPickDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerFragment mDatePicker = new DatePickerFragment();
                FragmentManager fm = getActivity().getSupportFragmentManager();
                mDatePicker.show(fm, "select");
            }
        });

        mBtnTimeFrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TimePicker mTimePickerFrom = new TimePicker();
                FragmentManager fm = getActivity().getSupportFragmentManager();
                mTimePickerFrom.show(fm, "time from");
            }
        });

        mBtnTimeTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerTo timePickerTo = new TimePickerTo();
                FragmentManager fm = getActivity().getSupportFragmentManager();
                timePickerTo.show(fm, "time to");
            }
        });



        mBtnTimKiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.e("ngaychon", ngaychon + "");
                Log.e("mgiobatdau", giobatdau + "");
                Log.e("mgioketthuc", gioketthuc + "");
                Log.e("dichvuchon", dichvuchon + "");
                Log.e("quanchon", quanchon + "");

                okDichVu = checkDichVu();
                okQuan = checkQuan();
                okGioBatDau = checkGioBatDau();
                okGioKetThuc = checkGioKetThuc();
                okNgay = checkNgay();
                Order order = new Order();

                if (okDichVu && okQuan && okGioBatDau && okGioKetThuc && okNgay) {

                    for (int i = 0; i < mPresenter.quanResponse.getListQuan().size(); i++) {
                        if (mPresenter.quanResponse.getListQuan().get(i).getTenquan().equalsIgnoreCase(quanchon)) {
                            order.setTenkhuvuc(mPresenter.quanResponse.getListQuan().get(i).getTenkhuvuc());
                        }
                    }
                    int giatien = 0;
                    order.setGiobatdau(giobatdau + "");
                    order.setGioketthuc(gioketthuc + "");
                    order.setNgaydatyeucau(ngaydatyeucau);
                    Log.e("Ngaydatyeucauchoose", ngaydatyeucau + "");
                    order.setNgaylam(ngaychon);
                    Log.e("quanchon", quanchon + "");
                    order.setQuan(quanchon);
                    List<String> listdichvu = new ArrayList<String>();
                    listdichvu.add(dichvuchon);
                    order.setDichvuyc(listdichvu);
                    giatien = ((gioketthuc - giobatdau) / 60) * gia;
                    order.setPhidichvu(giatien + "");
                    String request = new Gson().toJson(order);
                    mParentListener.goAllStaff(request);


                } else {
                    showSnackBar(getView(), "Bạn vui lòng xem lại thông tin cần chọn !", Snackbar.LENGTH_SHORT);
                }


            }
        });
    }

    @Override
    protected void initListener() {

    }

    @Override
    public void adddichvu(String all) {
        LogUtils.logE("jsonall", all);
    }

    @Override
    public void getQuanSuccess(QuanResponse quanResponse) {
        Log.e("allQuansize ", mPresenter.quanResponse.getListQuan().size() + "");
        quanAdapter.notifyDataSetChanged();
    }

    @Override
    public void getQuanError(String message) {
        mHubAddFood.dismiss();
        showSnackBar(getView(), "Quá trình lấy dữ liệu thất bạn , hãy check lại đường truyền !", Snackbar.LENGTH_SHORT);

    }

    @Override
    public void getDichVuSuccess(DichVuResponse dichVuResponse) {
        mHubAddFood.dismiss();
        dichvuAdapter.notifyDataSetChanged();
    }

    @Override
    public void getDichVuError(String message) {
        showSnackBar(getView(), "Quá trình lấy dữ liệu thất bạn , hãy check lại đường truyền !", Snackbar.LENGTH_SHORT);


    }


    public static class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar c = Calendar.getInstance();
            final int year = c.get(Calendar.YEAR);
            final int month = c.get(Calendar.MONTH);
            Log.e("monthfinal", month+"");
            final int day = c.get(Calendar.DAY_OF_MONTH);
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            int month = monthOfYear+1;

            ngaychon = dayOfMonth + "/" + month + "/" + year + "";

            Log.e("Ngaycho", ngaychon + "");
            mTvDayChoice.setText(" " + String.valueOf(dayOfMonth) + " - " + String.valueOf(month) + " - " + String.valueOf(year));

        }
    }

    //
    public boolean checkNgay() {
        if (ngaychon == null) {
            showSnackBar(getView(), "Chọn ngày phù hợp !", Snackbar.LENGTH_SHORT);
            return false;
        }
        return true;
    }


    public boolean checkGioBatDau() {
        if (giobatdau == 0) {
            showSnackBar(getView(), "Chon giờ bắt đầy!", Snackbar.LENGTH_SHORT);
            return false;
        }
        return true;
    }


    public boolean checkGioKetThuc() {
        if (gioketthuc == 0) {
            showSnackBar(getView(), "Chon giờ kết thúc!", Snackbar.LENGTH_SHORT);
            return false;
        }
        return true;
    }


    public boolean checkDichVu() {
        if (dichvuchon == null) {
            showSnackBar(getView(), "Chon dịch vụ !", Snackbar.LENGTH_SHORT);
            return false;
        }
        return true;
    }

    public boolean checkQuan() {
        if (quanchon == null) {
            showSnackBar(getView(), "Chon quận !", Snackbar.LENGTH_SHORT);
            return false;
        }
        return true;
    }

    public static class TimePicker extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);
            return new TimePickerDialog(getActivity(), this, hour, minute, DateFormat.is24HourFormat(getActivity()));
        }

        @Override
        public void onTimeSet(android.widget.TimePicker view, int hourOfDay, int minute) {
            Log.e("timeFrom", hourOfDay + "phut" + minute + "");

            if (hourOfDay > 6) {
                if (minute == 30 || minute == 0) {
                    giobatdau = hourOfDay * 60 + minute;
                    mTvTimeFrom.setText(hourOfDay + " : " + minute + "");
                } else {
                    mTvTimeFrom.setText("Bạn vui lòng chọ giờ chẵn hoặc 1/2!");

                }
            } else
                mTvTimeFrom.setText("Bạn vui lòng chọ giờ bắt đầu >6!");


        }
    }

    public static class TimePickerTo extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);
            return new TimePickerDialog(getActivity(), this, hour, minute, DateFormat.is24HourFormat(getActivity()));


        }

        @Override
        public void onTimeSet(android.widget.TimePicker view, int hourOfDay, int minute) {


            if (hourOfDay < 20) {
                if (minute == 30 || minute == 0) {
                    gioketthuc = hourOfDay * 60 + minute;
                    if (giobatdau > gioketthuc) {
                        mTvTimeTo.setText("Bạn cần chọn giờ kết thúc sau giừo bắt đầu");
                        gioketthuc = 0;
                    } else {
                        mTvTimeTo.setText(hourOfDay + " : " + minute + "");

                    }
                } else {
                    mTvTimeTo.setText("Bạn vui lòng chọ giờ chẵn hoặc 1/2!");

                }

            } else {
                mTvTimeTo.setText("Bạn vui lòng chọ giờ kết thúc trước 20");
            }

        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mParentListener = (MainListener) context;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mParentListener = (MainListener) activity;
    }
}
