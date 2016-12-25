package com.uiapp.doan.main.welcom;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.kaopiz.kprogresshud.KProgressHUD;
import com.uiapp.doan.AppConstants;
import com.uiapp.doan.R;
import com.uiapp.doan.base.activity.BaseActivity;
import com.uiapp.doan.main.login.view.LoginFragment;

public class WelcomeActivity extends BaseActivity {

    private long exitTimer = Long.MIN_VALUE;
    @Override
    protected Fragment onCreateFragment(Bundle bundle) {
        return LoginFragment.newInstance();
    }

    @Override
    protected int getContainerId() {
        return R.id.frm_container_welcome;
    }



    @Override
    protected int getLayoutId() {
        return R.layout.activity_welcome;
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void initData() {
        super.initData();
        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        mProgressBar = KProgressHUD.create(this)
                .setLabel(getResources().getString(R.string.no_internet))
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE).setCancellable(false);
    }

    @Override
    protected void setSupportToolBar(Toolbar toolBar) {

    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        View v = getCurrentFocus();
        if (v != null &&
                (ev.getAction() == MotionEvent.ACTION_UP || ev.getAction() == MotionEvent.ACTION_MOVE) &&
                v instanceof EditText && !v.getClass().getName().startsWith("android.webkit.")) {
            if (ev.getRawX() < v.getLeft() || ev.getRawX() > v.getRight() || ev.getRawY() < v.getTop() || ev.getRawY() > v.getBottom()) {
                hideKeyboard();
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
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
}
