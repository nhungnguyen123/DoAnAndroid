package com.uiapp.doan.main.signup.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.kaopiz.kprogresshud.KProgressHUD;
import com.uiapp.doan.MainActivity;
import com.uiapp.doan.MainApplication;
import com.uiapp.doan.R;
import com.uiapp.doan.base.fragment.BaseFragment;
import com.uiapp.doan.dto.KhachHang;
import com.uiapp.doan.interactor.api.response.CreateKhachHangResponse;
import com.uiapp.doan.main.signup.injection.DaggerSignUpComponent;
import com.uiapp.doan.main.signup.injection.SignUpComponent;
import com.uiapp.doan.main.signup.injection.SignUpModule;
import com.uiapp.doan.main.signup.presenter.SignUpPresenter;
import com.uiapp.doan.utils.CommonUtils;

import javax.inject.Inject;

import butterknife.Bind;

import static com.uiapp.doan.utils.CommonUtils.showSnackBar;

/**
 * Created by hongnhung on 10/26/16.
 */

public class SignUpFragment extends BaseFragment implements ISignUpView {
    private KProgressHUD mHubAddFood;

    public void showProgress() {
        mHubAddFood = KProgressHUD.create(getContext())
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE);
        mHubAddFood.show();
    }

    @Bind(R.id.edt_user_name)
    EditText mEdtUserName;


    @Bind(R.id.edt_user_sdt)
    EditText mEdtSdt;

    @Bind(R.id.edt_email)
    EditText mEdtEmail;


    @Bind(R.id.edt_address)
    EditText mEdtAddress;

    @Bind(R.id.edt_code)
    EditText mEdtcode;

    @Bind(R.id.edt_code_again)
    EditText mEdtCodeAgain;


    @Bind(R.id.btn_sign_up)
    Button mBtnSignUp;


    String name, phone, email, address, code, codeagain;
    public boolean okHoten, okPass, okAddress, okPhone, okEmail, okPassAgain;

    @Inject
    SignUpPresenter mPresenter;


    public static SignUpFragment newInstance() {

        Bundle args = new Bundle();

        SignUpFragment fragment = new SignUpFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SignUpComponent component = DaggerSignUpComponent.builder()
                .applicationComponent(MainApplication.getApplicationComponent(getActivity()))
                .signUpModule(new SignUpModule())
                .build();
        component.inject(this);
        mPresenter.attachView(this);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_sign_up;
    }

    @Override
    protected void initData() {

        //TODO goi ma dang ky va thuc hien dang ky
        // Thuc hien kiem tra cac thong tin can thiet truoc khi dang ky
        mBtnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProgress();
                okAddress = checkAddress();
                okEmail = checkEmail();
                okHoten = checkUserName();
                okPhone = checkPhone();
                okPass = checkPassword();
                okPassAgain = checkPassAgain();
                code = mEdtcode.getText().toString();
                codeagain = mEdtCodeAgain.getText().toString().trim();
                if (code.equalsIgnoreCase(codeagain)) {
                    if (okAddress && okEmail && okPhone && okPassAgain && okPass && okHoten) {
//                        mHubAddFood.dismiss();
                        name = mEdtUserName.getText().toString();
                        phone = mEdtSdt.getText().toString();
                        email = mEdtEmail.getText().toString();
                        address = mEdtAddress.getText().toString();
                        code= mEdtcode.getText().toString();
                        KhachHang khachhang = new KhachHang(code, name, phone, address, email);
                        mPresenter.SignUpUser(khachhang);
                    } else {
                        showSnackBar(getView(), "Kiểm tra thông tin lần nữa, please !", Snackbar.LENGTH_SHORT);
                    }
                } else {
                    showSnackBar(getView(), "Kiểm tra lại password, please !", Snackbar.LENGTH_SHORT);
                }


            }
        });
    }

    @Override
    protected void initListener() {

    }

    private boolean checkUserName() {
        String userName = mEdtUserName.getText().toString().trim();
        if (userName.isEmpty() || userName.equals("")) {
            mEdtUserName.setError("User không thể trống");
            return false;
        }
        return true;

    }

    private boolean checkPassword() {
        String password = mEdtcode.getText().toString().trim();
        if (password.isEmpty() || password.equals("")) {
            mEdtcode.setError("Password không thể trống");
            return false;
        }
        return true;
    }

    private boolean checkPassAgain() {
        String passwordAgain = mEdtCodeAgain.getText().toString().trim();
        if (passwordAgain.isEmpty() || passwordAgain.equals("")) {
            mEdtcode.setError("Password Again không thể trống");
            return false;
        }
        return true;
    }

    private boolean checkEmail() {
        String email = mEdtEmail.getText().toString().trim();
        if (email.isEmpty() || email.equals("")) {
            mEdtcode.setError("Email  không thể trống");
            return false;
        }
        return true;
    }


    private boolean checkAddress() {
        String address = mEdtAddress.getText().toString().trim();
        if (address.isEmpty() || address.equals("")) {
            mEdtAddress.setError("Address  không thể trống");
            return false;
        }
        return true;
    }

    private boolean checkPhone() {
        String phone = mEdtSdt.getText().toString().trim();
        if (phone.isEmpty() || phone.equals("")) {
            mEdtSdt.setError("Phone  không thể trống");
            return false;
        }
        return true;
    }

    @Override
    public void createKhachHangSuccesS(CreateKhachHangResponse khachHangResponse) {
        String json = new Gson().toJson(khachHangResponse);
        Log.e("json", json);
        mPresenter.setEmail();
        mPresenter.setHoten();
        mPresenter.setQuyenKhachHang();
        mPresenter.setTaiKhoan();
        mPresenter.setDiachi();
        showSnackBar(getView(), "Đăng ký khách hàng thành công !", Snackbar.LENGTH_LONG);
        mHubAddFood.dismiss();
        Intent intent = new Intent(this.getActivity(), MainActivity.class);
        getActivity().finish();
        startActivity(intent);

    }

    @Override
    public void createKhachHangError(String message) {
        Log.e("errr", message + "");
        showSnackBar(getView(), "Đăng ký khách hàng thất bại . Có lỗi " + message + "", Snackbar.LENGTH_SHORT);
        mHubAddFood.dismiss();
    }
}
