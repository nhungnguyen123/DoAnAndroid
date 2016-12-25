package com.uiapp.doan;

import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.uiapp.doan.base.activity.BaseActivity;
import com.uiapp.doan.main.aboutus.AboutUsFragment;
import com.uiapp.doan.main.allorder.view.AllOrderFragment;
import com.uiapp.doan.main.allstaff.view.AllStaffFragment;
import com.uiapp.doan.main.allstafforder.view.AllStaffOrderFragment;
import com.uiapp.doan.main.changepass.view.ChangePassFragment;
import com.uiapp.doan.main.choose.view.ChooseFragment;
import com.uiapp.doan.main.login.view.LoginFragment;
import com.uiapp.doan.main.menucontainer.view.MenuContainerFragment;
import com.uiapp.doan.main.order.view.OrderFragment;
import com.uiapp.doan.main.orderdetail.view.OrderDetailFragment;
import com.uiapp.doan.main.ordersuccess.OrderSuccessFragment;
import com.uiapp.doan.main.report.view.ReportFragment;
import com.uiapp.doan.main.signupstaff.view.SignUpStaffFragment;
import com.uiapp.doan.main.staffdetail.view.StaffDetailFragment;

import butterknife.Bind;

public class MainActivity extends BaseActivity implements MainListener {

    @Bind(R.id.drw_container_main)
    DrawerLayout mDlFrmContainerMain;

    @Bind(R.id.fl_container_main)
    FrameLayout mFlContainerMain;

    @Bind(R.id.fl_menu_container)
    FrameLayout mFlMenuContainer;


    ChooseFragment mChooseFragment;

    MenuContainerFragment mMenuContainer;

    @Override
    protected Fragment onCreateFragment(Bundle bundle) {


        String role = MainApplication.getApplicationComponent(this).getPreferManager().getKeyValueByKeyName(AppConstants.KEY_ROLE_USER);
        String taikhoan = MainApplication.getApplicationComponent(this).getPreferManager().getKeyValueByKeyName(AppConstants.KEY_TAI_KHOAN);
        if (role == null) {
            mChooseFragment = ChooseFragment.newInstance();
        } else {
            if (role.equalsIgnoreCase("tho")) {
                Log.e("logtho", role + "");
                return AllOrderFragment.newInstance();
            } else {
                mChooseFragment = ChooseFragment.newInstance();
            }
        }
        return mChooseFragment;
    }

    @Override
    protected int getContainerId() {
        return R.id.fl_container_main;
    }

    @Override
    protected void initData() {
        super.initData();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_menu_container, mMenuContainer.newInstance()).commit();

        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    private long exitTimer = Long.MIN_VALUE;

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        mDlFrmContainerMain.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
        if (event.getAction() == KeyEvent.ACTION_DOWN
                && event.getKeyCode() == KeyEvent.KEYCODE_BACK
                && event.getRepeatCount() == 0) {
            if (mFragmentTagStack.size() == 1) {
                if ((exitTimer + AppConstants.EXIT_INTERVAL) < System.currentTimeMillis()) {
                    Toast.makeText(this, getString(R.string.confirm_exit), Toast.LENGTH_SHORT).show();
                    exitTimer = System.currentTimeMillis();
                } else {
                    finish();
                }
                return true;
            }
        }
        return super.dispatchKeyEvent(event);
    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void setSupportToolBar(Toolbar toolBar) {
        setSupportActionBar(toolBar);
    }

    @Override
    public void onBackScreen() {
        mDlFrmContainerMain.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
        onBackPressed();
    }

    private void hideContainerMenu() {
        Log.e("TAG", "Close Container");
        mDlFrmContainerMain.closeDrawer(Gravity.LEFT);
        mDlFrmContainerMain.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
    }

    @Override
    public void openMenuContainer() {
        mDlFrmContainerMain.openDrawer(Gravity.LEFT);
    }

    @Override
    public void goLogin() {
        hideContainerMenu();
        LoginFragment fragment = LoginFragment.newInstance();
        showFragment(R.id.fl_container_main, fragment);
    }

    @Override
    public void goAboutUs() {
        hideContainerMenu();
        AboutUsFragment fragment = AboutUsFragment.newInstance();
        showFragment(R.id.fl_container_main, fragment);
    }

    @Override
    public void goAllSaffOrder() {
        hideContainerMenu();
        AllStaffOrderFragment allStaffOrderFragment = AllStaffOrderFragment.newInstance();
        showFragment(R.id.fl_container_main, allStaffOrderFragment);
    }

    @Override
    public void goAllStaff(String request) {
        hideContainerMenu();

        Bundle bundle = new Bundle();
        bundle.putString("REQUEST", request);
        AllStaffFragment fragment = AllStaffFragment.newInstance();
        fragment.setArguments(bundle);
        showFragment(fragment);
    }

    @Override
    public void goAllOrder(String orderThoKhach) {

        hideContainerMenu();

        Bundle bundle = new Bundle();
        bundle.putString("ALLORDERDETAIL", orderThoKhach);
        AllOrderFragment fragment = AllOrderFragment.newInstance();
        fragment.setArguments(bundle);
        showFragment(fragment);
    }

    @Override
    public void goChangePass() {
        hideContainerMenu();
        ChangePassFragment changePassFragment = ChangePassFragment.newInstance();
        showFragment(changePassFragment);

    }

    @Override
    public void goOrderSuccess(String message) {
        hideContainerMenu();
        Bundle bundle = new Bundle();
        bundle.putString("ORDERMESSAGE", message);
        OrderSuccessFragment orderSuccessFragment = OrderSuccessFragment.newInstance();
        orderSuccessFragment.setArguments(bundle);
        showFragment(orderSuccessFragment);
    }

    @Override
    public void goChoose() {
        hideContainerMenu();
        ChooseFragment fragment = ChooseFragment.newInstance();
        showFragment(R.id.fl_container_main, fragment);
    }

    @Override
    public void goReport() {
        hideContainerMenu();
        ReportFragment reportFragment = ReportFragment.newInstance();
        showFragment(reportFragment);
    }

    @Override
    public void goSignup(Fragment fragment) {
        showFragment(R.id.fl_container_main, fragment);
    }

    @Override
    public void goStaffDetail(String detail, String order) {
        hideContainerMenu();
        Bundle bundle = new Bundle();
        bundle.putString("STAFFDETAIL", detail);
        bundle.putString("ORDER", order);
        StaffDetailFragment staffDetailFragment = StaffDetailFragment.newInstance();
        staffDetailFragment.setArguments(bundle);
        showFragment(staffDetailFragment);
    }

    @Override
    public void goOrderFragment(String message) {
        hideContainerMenu();
        Bundle bundle = new Bundle();
        bundle.putString("ORDER", message);
        OrderFragment orderFragment = OrderFragment.newInstance();
        orderFragment.setArguments(bundle);
        showFragment(orderFragment);
    }

    @Override
    public void goSignUpStaff() {
        hideContainerMenu();
        SignUpStaffFragment signUpStaffFragment = SignUpStaffFragment.newInstance();
        showFragment(signUpStaffFragment);
    }

    @Override
    public void goOrderDetail(String orderDetail) {
        hideContainerMenu();
        Bundle bundle = new Bundle();
        bundle.putString("ORDERDETAIL", orderDetail);
        OrderDetailFragment orderDetailFragment = OrderDetailFragment.newInstance();
        orderDetailFragment.setArguments(bundle);
        showFragment(orderDetailFragment);
    }


    private void hideContainermenu() {
        mDlFrmContainerMain.closeDrawer(Gravity.LEFT);
        mDlFrmContainerMain.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);

    }
}
