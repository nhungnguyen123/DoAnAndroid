package com.uiapp.doan.main.order.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.kaopiz.kprogresshud.KProgressHUD;
import com.uiapp.doan.AppConstants;
import com.uiapp.doan.MainActivity;
import com.uiapp.doan.MainApplication;
import com.uiapp.doan.MainListener;
import com.uiapp.doan.R;
import com.uiapp.doan.base.fragment.BaseFragment;
import com.uiapp.doan.dto.Order;
import com.uiapp.doan.main.order.injection.DaggerOrderComponent;
import com.uiapp.doan.main.order.injection.OrderComponent;
import com.uiapp.doan.main.order.injection.OrderModule;
import com.uiapp.doan.main.order.presenter.OrderPresenter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import butterknife.Bind;

import static android.R.attr.order;
import static com.uiapp.doan.utils.CommonUtils.showSnackBar;

/**
 * Created by hongnhung on 11/1/16.
 */

public class OrderFragment extends BaseFragment implements IOrderView {


    private KProgressHUD mHubAddFood;

    public void showProgress() {
        mHubAddFood = KProgressHUD.create(getContext())
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE);
        mHubAddFood.show();
    }


    @Inject
    OrderPresenter mPresenter;


    @Bind(R.id.tv_phone)
    EditText mEdtPhone;

    @Bind(R.id.tv_name)
    TextView medtNameKhachHang;

    @Bind(R.id.tv_address)
    EditText mEdtAddress;

    @Bind(R.id.tv_description_work)
    EditText medtDescriptionWork;

    @Bind(R.id.tv_maYc)
    TextView mTcMayc;


    @Bind(R.id.tv_district)
    EditText mEdtDistrict;

    @Bind(R.id.tv_tentho)
    TextView mTvTenTho;

    @Bind(R.id.tv_day)
    TextView mTvNgay;

    @Bind(R.id.tv_time_start)
    TextView mTvTimeStart;


    @Bind(R.id.tv_time_end)
    TextView mTvTimeEnd;

    @Bind(R.id.tv_service)
    TextView mTvService;


    @Bind(R.id.tv_pay)
    TextView mTvPay;

    @Bind(R.id.tv_cmnd_tho)
    TextView mTvCmndTho;

    MainListener mMainListener;

    @Bind(R.id.tv_sdt_tho)
    TextView mTVSdtTho;

    MainListener mParentListener;
    @Bind(R.id.edt_email_khach)
    EditText mEdtEmailkhach;
    Calendar cal;

    public String ngaydatyeucau, mayc, quan, ngaylam,
            hotenTho, cmndTho, hotenKH, sodt, diachi, mota,
            sdtTho, giobatdau, gioketthuc, phidichvu,
            email, dichvuyeucau;
    public boolean nameOk, diachiOk, quanOk, emailOk, sdtOk;


    @Bind(R.id.btn_create_order)
    Button mBtnCreate;

    public String orderString;
    public Order order;


    public static OrderFragment newInstance() {

        Bundle args = new Bundle();

        OrderFragment fragment = new OrderFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        OrderComponent component = DaggerOrderComponent.builder()
                .applicationComponent(MainApplication.getApplicationComponent(getActivity()))
                .orderModule(new OrderModule())
                .build();
        component.inject(this);
        mPresenter.attachView(this);


        Bundle bundle = this.getArguments();
        orderString = bundle.getString("ORDER");
        Log.e("orderDetailFragment", orderString + "");

        order = new Gson().fromJson(orderString, Order.class);

        Log.e("orderfragmentquan", order.getQuan() + "");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_order;
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
    protected void initData() {

        Log.e("emailKhach", mPresenter.getEmail() + "");
        Log.e("taikhoan", mPresenter.getTaiKhoan() + "");
        if (mPresenter.getTaiKhoan() == null) {

        } else {
            mEdtPhone.setText(mPresenter.getTaiKhoan());
        }
        if (mPresenter.getDiaChi() == null) {

        } else {
            mEdtAddress.setText(mPresenter.getDiaChi());
        }

        if (mPresenter.getHoTenKhachHang() == null) {

        } else {
            medtNameKhachHang.setText(mPresenter.getHoTenKhachHang());
        }
        if (mPresenter.getEmail() == null) {

        } else {
            Log.e("emailKhachkhacnull", mPresenter.getEmail() + "");
            mEdtEmailkhach.setText(mPresenter.getEmail());
        }
        int batdau = Integer.parseInt(order.getGiobatdau());
        int ketthuc = Integer.parseInt(order.getGioketthuc());

        int giobatdautest = batdau / 60;
        int giotest = ketthuc / 60;

        if (giobatdautest * 60 == batdau) {
            mTvTimeStart.setText(batdau / 60 + "");
        } else {
            mTvTimeStart.setText((batdau / 60) + ": 30");
        }

        if (giotest * 60 == ketthuc) {
            mTvTimeEnd.setText(ketthuc / 60 + "");
        } else {
            mTvTimeEnd.setText((ketthuc / 60) + ": 30");
        }
        mTvTenTho.setText(order.getHotenTho());
        mTvNgay.setText(order.getNgaylam());


        mTvCmndTho.setText(order.getCmndTho());
        mTvPay.setText(order.getPhidichvu() + "");

        String dichvu = order.getDichvuyc().get(0).toString();

        mTvService.setText(dichvu);


        //TODO Create order
        mBtnCreate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                showProgress();
                nameOk = checkTenKhachHang();
                diachiOk = checkDiaChiKhachHang();
                emailOk = checkEmailKhach();
                sdtOk = checkPhoneKhachHang();

                if (nameOk && diachiOk && emailOk && sdtOk) {
                    quan = order.getQuan();
                    ngaylam = mTvNgay.getText().toString();
                    hotenTho = mTvTenTho.getText().toString();
                    cmndTho = mTvCmndTho.getText().toString();
                    hotenKH = medtNameKhachHang.getText().toString();
                    sodt = mEdtPhone.getText().toString();

                    diachi = mEdtAddress.getText().toString();
                    mota = medtDescriptionWork.getText().toString();
                    sdtTho = mTVSdtTho.getText().toString();
                    giobatdau = order.getGiobatdau();
                    gioketthuc = order.getGioketthuc();
                    phidichvu = mTvPay.getText().toString();
                    email = mEdtEmailkhach.getText().toString();

                    //TODO dich vu yeu cau la mot danh sacch
                    dichvuyeucau = mTvService.getText().toString();
                    Calendar c = GregorianCalendar.getInstance();

                    int thisyear = c.get(Calendar.YEAR);
                    int thismonth = c.get(Calendar.MONTH);
                    int today = c.get(Calendar.DATE);
                    cal = Calendar.getInstance();
                    SimpleDateFormat dft = null;
                    //Định dạng ngày / tháng /năm
                    dft = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                    ngaydatyeucau = dft.format(cal.getTime());

                    Log.e("ngayhientai", ngaydatyeucau + "");


                    order.setNgaydatyeucau(ngaydatyeucau);
                    order.setMayc(mayc + "");
                    order.setQuan(quan + "");
                    order.setNgaylam(ngaylam + "");
                    order.setHotenTho(hotenTho + "");
                    order.setCmndTho(cmndTho + "");
                    order.setGiobatdau(giobatdau + "");
                    order.setGioketthuc(gioketthuc + "");
                    order.setHotenKH(hotenKH);
                    order.setAccountKH(mPresenter.getTaiKhoan());
                    order.setTrangthai(AppConstants.TRANGTHAIBATDAU);
                    order.setSodt(sodt);
                    order.setDiachi(diachi);
                    order.setTrangthai(AppConstants.TRANGTHAIBATDAU);
                    order.setMota(mota);
                    order.setPhidichvu(phidichvu);
                    order.setEmail(email);
                    List<String> lishdichvu = new ArrayList<String>();
                    lishdichvu.add(dichvuyeucau);
                    order.setDichvuyc(lishdichvu);

                    String ordichvu = new Gson().toJson(order);
                    Log.e("ordichvu", ordichvu + "");

                    mPresenter.createOrder(order);
                } else {
                    showSnackBar(getView(), "Kiểm tra thông tin lần nữa, please !", Snackbar.LENGTH_SHORT);
                }


            }
        });
    }

    @Override
    protected void initListener() {

    }

    @Override
    public void getidYcSuccess(String messageYc) {
        Log.e("messageYc", messageYc);
        mTcMayc.setText(messageYc + "");
        mayc = messageYc;
    }

    @Override
    public void getidYcError(String message) {
        Log.e("error", message);
    }

    @Override
    public void createOrderSuccess() {
        Log.e("create order", "success");
        mHubAddFood.dismiss();

        if (mPresenter.getQuyen() == "") {
            showSnackBar(getView(), "Đơn hàng của bạn đã tạo thành công, chúng tôi sẽ sớm liên hệ lại với bạn!", Snackbar.LENGTH_SHORT);
        } else {
            mMainListener.goAllOrder("");


        }
//        this.getActivity().finish();
//        Intent intent = new Intent(this.getActivity(), MainActivity.class);
//        startActivity(intent);
    }

    @Override
    public void createOrderError(String message) {
        mHubAddFood.dismiss();
        Log.e("error create", message + "");
    }


    private boolean checkPhoneKhachHang() {
        String phoneKhachHang = mEdtPhone.getText().toString().trim();
        if (phoneKhachHang.isEmpty() || phoneKhachHang == null) {
            mEdtPhone.setError("Phone không thể trống");
            return false;
        }
        return true;
    }


    private boolean checkTenKhachHang() {
        String tenKhachHang = medtNameKhachHang.getText().toString().trim();
        if (tenKhachHang.isEmpty() || tenKhachHang == null) {
            medtNameKhachHang.setError("Tên khách hàng không thể trống");
            return false;
        }
        return true;
    }

    private boolean checkDiaChiKhachHang() {
        String diaChiKhachHang = mEdtAddress.getText().toString().trim();
        if (diaChiKhachHang.isEmpty() || diaChiKhachHang == null) {
            mEdtAddress.setError("Địa chỉ khách hàng không thể trống");
            return false;
        }
        return true;
    }

    private boolean checkEmailKhach() {
        String checkEmailKhach = mEdtEmailkhach.getText().toString().trim();
        if (checkEmailKhach.isEmpty() || checkEmailKhach == null) {
            mEdtEmailkhach.setError("Email khách hàng không thể trống");
            return false;
        }
        return true;
    }


}
