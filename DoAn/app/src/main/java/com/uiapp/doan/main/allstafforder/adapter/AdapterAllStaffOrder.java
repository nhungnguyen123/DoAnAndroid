package com.uiapp.doan.main.allstafforder.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.uiapp.doan.R;
import com.uiapp.doan.dto.Tho;
import com.uiapp.doan.main.allstaff.adapter.AllStaffHolder;
import com.uiapp.doan.main.allstaff.adapter.OnClickStaff;

import java.util.List;

/**
 * Created by hongnhung on 11/22/16.
 */

public class AdapterAllStaffOrder extends RecyclerView.Adapter {


    public List<Tho> listTho;
    public Context mContext;

    OnClickStaffOrder mOnClickStaff;

    public void setOnClickStaff(OnClickStaffOrder mOnClickStaff) {
        this.mOnClickStaff = mOnClickStaff;
    }


    public AdapterAllStaffOrder(List<Tho> listTho, Context mContext) {
        this.listTho = listTho;
        this.mContext = mContext;


    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewall = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_all_staff_order, null);
        return new AllStaffOrderHolder(viewall);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        final AllStaffOrderHolder allStaffHolder = (AllStaffOrderHolder) holder;

        final Tho tho = listTho.get(position);
        String jsonAllTho = new Gson().toJson(tho);
        Log.e("jaonAllTho", jsonAllTho);
//        if (tho.getXacnhan() == true && tho.getXacnhan() != null) {
            allStaffHolder.mTvName.setText(tho.getHoten());
            allStaffHolder.mTvDescription.setText(tho.getMotakinhnghiem());
            allStaffHolder.mTvBirthDay.setText(tho.getNgaysinh());
            allStaffHolder.mTvYear.setText(tho.getSonamkinhnghiem() + "");


        String hinhanh = "https://baocao.herokuapp.com/"+tho.getHinhanh()+"";
            Glide.with(mContext).load(hinhanh).centerCrop().into(allStaffHolder.imgAvtOrder);
            allStaffHolder.mBtnDetail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e("detail", position + "");

                    String staffDetail = new Gson().toJson(tho);

                    mOnClickStaff.OnClickDetailStaff(staffDetail);
                }
            });


//        } else {
//
//        }


    }

    @Override
    public int getItemCount() {
        if (listTho == null) {
            return 0;
        } else
            return listTho.size();
    }
}

