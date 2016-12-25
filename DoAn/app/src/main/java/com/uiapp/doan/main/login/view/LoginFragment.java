package com.uiapp.doan.main.login.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.kaopiz.kprogresshud.KProgressHUD;
import com.uiapp.doan.AppConstants;
import com.uiapp.doan.MainActivity;
import com.uiapp.doan.MainApplication;
import com.uiapp.doan.MainListener;
import com.uiapp.doan.R;
import com.uiapp.doan.base.fragment.BaseFragment;
import com.uiapp.doan.interactor.api.request.LoginKhachHangRequest;
import com.uiapp.doan.interactor.api.response.LoginKhachHangResponse;
import com.uiapp.doan.interactor.api.response.LoginResponse;
import com.uiapp.doan.main.acsignup.SignUpActivity;
import com.uiapp.doan.main.login.injection.DaggerILoginComponent;
import com.uiapp.doan.main.login.injection.ILoginComponent;
import com.uiapp.doan.main.login.injection.LoginModule;
import com.uiapp.doan.main.login.presenter.LoginPresenter;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.OnClick;

import static com.uiapp.doan.utils.CommonUtils.showSnackBar;

/**
 * Created by hongnhung on 10/24/16.
 */

public class LoginFragment extends BaseFragment implements ILoginView {

//
//    private KProgressHUD mHubAddFood;
//
//    private KProgressHUD mHubTho;
//    public void showProgresstho() {
//        mHubTho = KProgressHUD.create(getContext())
//                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE);
//        mHubTho.show();
//    }

    @Bind(R.id.edt_use_name)
    EditText mEdtUseName;

    @Bind(R.id.edt_password)
    EditText mEdtPassword;

    @Bind(R.id.btn_login_nhan_vien)
    Button mBtnDangNhapNhanVien;

    @Bind(R.id.btn_register)
    Button mBtnDangKy;
    private KProgressHUD mHub;

    @Bind(R.id.btn_dang_nhap_khach_hang)
    Button mBtnLoginKhachHang;


    public String username, password;
    public boolean okUser, okPass;

    MainListener mParentListener;


    @Inject
    LoginPresenter loginPresenter;

    public static LoginFragment newInstance() {

        Bundle args = new Bundle();

        LoginFragment fragment = new LoginFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ILoginComponent component = DaggerILoginComponent.builder()
                .applicationComponent(MainApplication.getApplicationComponent(getActivity()))
                .loginModule(new LoginModule())
                .build();
        component.inject(this);
        loginPresenter.attachView(this);
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_login;
    }

    @Override
    protected void initData() {

        mBtnLoginKhachHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                showProgress();
                okPass = checkPassWord();
                okUser = checkUserName();

                if (okPass && okPass) {
                    username = mEdtUseName.getText().toString();
                    password = mEdtPassword.getText().toString();
                    LoginKhachHangRequest loginKhachHangRequest = new LoginKhachHangRequest(username, password);
                    loginPresenter.loginkhachhang(loginKhachHangRequest);
                } else {
                    showSnackBar(getView(), "Check info, please !", Snackbar.LENGTH_SHORT);
                }
            }
        });


    }

    @OnClick(R.id.btn_sign_up_staff)
    public void ClickSignUpStafF() {

        Intent intent = new Intent(this.getActivity(), SignUpActivity.class);
        intent.putExtra(AppConstants.STARTACTIVITY, AppConstants.SIGNUPSTAFF);
        startActivity(intent);
    }

    @OnClick(R.id.btn_register)
    public void ClickSignUp() {

        Intent intent = new Intent(this.getActivity(), SignUpActivity.class);
        intent.putExtra(AppConstants.STARTACTIVITY, AppConstants.SIGNUP);
        startActivity(intent);
    }

    @Override
    protected void initListener() {

    }


    @Override
    public void loginSuccess(LoginResponse res) {
        showSnackBar(getView(), "Đăng nhập  thành công  !", Snackbar.LENGTH_SHORT);
//        mHubAddFood.dismiss();
        loginPresenter.setCmnd();
        loginPresenter.setQuyen();
        loginPresenter.setUserNameTho();
        Intent intent = new Intent(this.getActivity(), MainActivity.class);
        getActivity().finish();
        startActivity(intent);

    }

    @Override
    public void loginError(String message) {
        showSnackBar(getView(), "Đăng nhập không thành công , hãy thử lại  !"+message, Snackbar.LENGTH_SHORT);
        Log.e("login error", message + "");
//        mHubAddFood.dismiss();
    }

    @Override
    public void loginKhachSuccess(LoginKhachHangResponse createKhachHangResponse) {
        loginPresenter.setTaiKhoan();
        loginPresenter.setQuyenKhachHang();
        loginPresenter.setEmail();
        loginPresenter.setDiachi();
        loginPresenter.setHoten();
        showSnackBar(getView(), "Đăng nhập  thành công .", Snackbar.LENGTH_SHORT);

        Intent intent = new Intent(this.getActivity(), MainActivity.class);
        getActivity().finish();
        startActivity(intent);

    }

    @Override
    public void loginKhachHangError(String message) {
        loginPresenter.loginNhanVien(username, password);
        showSnackBar(getView(), "Đăng nhập không thành công , hãy thử lại  !", Snackbar.LENGTH_SHORT);
//        mHubAddFood.dismiss();
    }

    private boolean checkUserName() {
        String userName = mEdtUseName.getText().toString().trim();
        if (userName.isEmpty() || userName.equals("")) {
            mEdtUseName.setError("User không thể trống");
            return false;
        }
        return true;
    }

    private boolean checkPassWord() {
        String passWord = mEdtPassword.getText().toString().trim();
        if (passWord.isEmpty() || passWord.equals("")) {
            mEdtPassword.setError("Password không thể trống");
            return false;
        }
        return true;
    }

//    public void showProgress() {
//        mHub = KProgressHUD.create(getContext())
//                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE);
//        mHub.show();
//    }

    @OnClick(R.id.tv_chi_dung_dich_vu)
    void onClickDungDichVu() {
        loginPresenter.setQuyenChiDatHang();
        Intent intent = new Intent(this.getActivity(), MainActivity.class);
        getActivity().finish();
        startActivity(intent);
    }

}
