package com.uiapp.doan.main.aboutus;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.uiapp.doan.R;
import com.uiapp.doan.base.fragment.BaseFragment;
import com.uiapp.doan.utils.LogUtils;

import org.w3c.dom.Text;

import butterknife.Bind;

/**
 * Created by hongnhung on 10/24/16.
 */

public class AboutUsFragment extends BaseFragment {

    @Bind(R.id.tv_policy)
    Button mTvPolicy;

    @Bind(R.id.tv_contact)
    Button mTvContact;

    @Bind(R.id.tv_pay)
    Button mTvPay;

    @Bind(R.id.tv_question)
    Button mTvQuestion;

    @Bind(R.id.tv_service)
    Button mTvService;


    public static AboutUsFragment newInstance() {

        Bundle args = new Bundle();

        AboutUsFragment fragment = new AboutUsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_about_us;
    }

    @Override
    protected void initData() {
        mTvPolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogUtils.logE(TAG, "policy");
                openDialogPolicy();
            }
        });


        mTvPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogUtils.logE(TAG, "Pay");
                openDialogPay();
            }
        });

        mTvQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogUtils.logE(TAG, "question");
                openDialogQuestion();
            }
        });
        mTvService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogUtils.logE(TAG, "service");
                openDialogService();
            }
        });
        mTvContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialogContact();
                LogUtils.logE(TAG, "pay");
            }
        });

    }

    @Override
    protected void initListener() {

    }


    public void openDialogPolicy() {
        final Dialog dialog = new Dialog(getContext()); // Context, this, etc.
        dialog.setContentView(R.layout.fragment_dialog_policy);
        dialog.setTitle(R.string.policy);
        dialog.show();
    }


    public void openDialogContact() {
        final Dialog dialog = new Dialog(getContext()); // Context, this, etc.
        dialog.setContentView(R.layout.fragment_dialog_contact);
//        dialog.setTitle(R.string.check_password);
        dialog.setTitle(R.string.contact);
        dialog.show();
    }

    public void openDialogQuestion() {
        final Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.fragment_dialog_question);
        dialog.setTitle(R.string.contact);
        dialog.show();
    }

    public void openDialogPay() {
        final Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.fragment_dialog_pay);
        dialog.setTitle(R.string.bang_gia);
        dialog.show();
    }

    public void openDialogService() {
        final Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.fragment_dialog_dich_vi);
        dialog.setTitle(R.string.dich_vu);
        dialog.show();
    }

}
