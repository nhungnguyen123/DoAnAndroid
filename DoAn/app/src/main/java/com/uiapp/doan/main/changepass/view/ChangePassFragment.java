package com.uiapp.doan.main.changepass.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.widget.EditText;

import com.kaopiz.kprogresshud.KProgressHUD;
import com.uiapp.doan.MainActivity;
import com.uiapp.doan.MainApplication;
import com.uiapp.doan.MainListener;
import com.uiapp.doan.R;
import com.uiapp.doan.base.fragment.BaseFragment;
import com.uiapp.doan.interactor.api.request.ChangePassRequest;
import com.uiapp.doan.main.changepass.injection.ChangePassComponent;
import com.uiapp.doan.main.changepass.injection.ChangePassModule;
import com.uiapp.doan.main.changepass.injection.DaggerChangePassComponent;
import com.uiapp.doan.main.changepass.presenter.ChangePassPresenter;
import com.uiapp.doan.main.welcom.WelcomeActivity;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.OnClick;

import static com.uiapp.doan.utils.CommonUtils.showSnackBar;

/**
 * Created by hongnhung on 12/15/16.
 */

public class ChangePassFragment extends BaseFragment implements IViewChange {
    private KProgressHUD mHubAddFood;

    public void showProgress() {
        mHubAddFood = KProgressHUD.create(getContext())
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE);
        mHubAddFood.show();
    }

    MainListener mMainListener;
    @Bind(R.id.edt_pass_again)
    EditText mEdtPassAgein;

    @Bind(R.id.edt_pass)
    EditText mEdtPass;

    public String pass, passagain;


    @Inject
    ChangePassPresenter mPresenter;


    public static ChangePassFragment newInstance() {

        Bundle args = new Bundle();

        ChangePassFragment fragment = new ChangePassFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ChangePassComponent component = DaggerChangePassComponent.builder()
                .applicationComponent(MainApplication.getApplicationComponent(this.getActivity()))
                .changePassModule(new ChangePassModule())
                .build();
        component.inject(this);
        mPresenter.attachView(this);
        mPresenter.getCmnd();

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_change_pass;
    }

    @OnClick(R.id.btn_change_pass_tho)
    public void ClickChangePass() {
        pass = mEdtPass.getText().toString().trim();
        passagain = mEdtPassAgein.getText().toString().trim();
        if (passagain.equalsIgnoreCase(pass)) {


            ChangePassRequest changePassRequest = new ChangePassRequest();
            changePassRequest.setCmnd(mPresenter.getCmnd());
            changePassRequest.setQuyen(mPresenter.getQuyen());
            changePassRequest.setUsername(mPresenter.getUsername());
            changePassRequest.setPasswork(pass);
            mPresenter.changePassTho(changePassRequest);
            showProgress();
        } else {
            Log.e("pass", "khong trung");

        }

    }

    @Override
    protected void initData() {
        Log.e("cmnd", mPresenter.getCmnd());
        Log.e("dispay", mPresenter.getUsername());
        Log.e("qyuyen", mPresenter.getQuyen());
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
    protected void initListener() {

    }

    @Override
    public void changePasstThoSuccess() {
        Log.e("doipass", "thanhcong");
        //TODO thực hiện đăng nhập lại .
        mHubAddFood.dismiss();
        showSnackBar(getView(), "Đổi mật khẩu thành công  !", Snackbar.LENGTH_SHORT);
        mPresenter.goLogOut();
        Intent intent = new Intent(getActivity(), WelcomeActivity.class);
        startActivity(intent);
        getActivity().finish();

    }

    @Override
    public void changePassThoError() {
        mHubAddFood.dismiss();
        showSnackBar(getView(), "Đổi mật khẩu không thành công  !", Snackbar.LENGTH_SHORT);
        Log.e("doipass", "thatbai");
    }

    private boolean checkPass() {
        String passWord = mEdtPass.getText().toString().trim();
        if (passWord.isEmpty() || passWord.equals("")) {
            mEdtPass.setError("Password không thể trống");
            return false;
        }
        return true;
    }


    private boolean checkPassAgain() {
        String passWord = mEdtPassAgein.getText().toString().trim();
        if (passWord.isEmpty() || passWord.equals("")) {
            mEdtPassAgein.setError("Password không thể trống");
            return false;
        }
        return true;
    }
}
