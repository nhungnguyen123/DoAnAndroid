package com.uiapp.doan.main.choose.view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.uiapp.doan.R;
import com.uiapp.doan.utils.LogUtils;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by hongnhung on 10/26/16.
 */

public class DatePickerFragment extends DialogFragment {

    DatePicker fromDate;

    public static DatePickerFragment newInstance() {

        Bundle args = new Bundle();

        DatePickerFragment fragment = new DatePickerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View v = getActivity().getLayoutInflater().inflate(R.layout.fragment_pick_day, null, false);

        fromDate = (DatePicker) v.findViewById(R.id.dpr_from);
        return new AlertDialog.Builder(getActivity(), 0)
                .setView(v)
                .setCustomTitle(null)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Date from = new Date(fromDate.getCalendarView().getDate());
                        LogUtils.logE("TAG", "Date: " + from.toString());
                        LogUtils.logE("day", from.toString());

                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity(), "You haven't just chosen date", Toast.LENGTH_SHORT).show();
                    }
                }).create();
    }

}
