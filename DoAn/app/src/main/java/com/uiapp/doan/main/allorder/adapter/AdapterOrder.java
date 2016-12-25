package com.uiapp.doan.main.allorder.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.uiapp.doan.R;
import com.uiapp.doan.dto.Order;

import java.util.List;

/**
 * Created by hongnhung on 11/5/16.
 */

public class AdapterOrder extends RecyclerView.Adapter {

    List<Order> mListOrder;

    ClickOrderDetail mClickOrderDetail;


    public AdapterOrder(List<Order> mListOrder) {
        this.mListOrder = mListOrder;

    }

    public void setOrderDetail(ClickOrderDetail clickOrderDetail) {
        this.mClickOrderDetail = clickOrderDetail;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View order = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_order, null);
        return new OrderHolder(order);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final OrderHolder orderHolder = (OrderHolder) holder;


        final Order order = mListOrder.get(position);

        String orderKhachHangeAdapter = new Gson().toJson(order);
        Log.e("orderKhachHangeAdapter", orderKhachHangeAdapter);
        if (order.getGiobatdau() == null) {

        } else {
            int intbatdau = Integer.parseInt(order.getGiobatdau());
            int giobatdautest = intbatdau / 60;
            if (giobatdautest * 60 == intbatdau) {
                Log.e("giobatdau", intbatdau + "");
                orderHolder.mTvGioBatDau.setText(intbatdau / 60 + "");
            } else {
                Log.e("giobatdauhon", intbatdau + "");

                orderHolder.mTvGioBatDau.setText(intbatdau / 60 + " : 30");
            }

        }

        orderHolder.mTvPo.setText(position + 1 + "");

        if (order.getGioketthuc() == null) {

        } else {
            int intketthuc = Integer.parseInt(order.getGioketthuc());
            int giotest = intketthuc / 60;
            if (giotest * 60 == intketthuc) {
                orderHolder.mTvGioKetThuc.setText(intketthuc / 60 + "");
            } else {
                orderHolder.mTvGioKetThuc.setText(intketthuc / 60 + " : 30");
            }
        }


        orderHolder.mTvSotho.setText(order.getSdtTho());
        orderHolder.mTvsoKhachHang.setText(order.getSodt());
        orderHolder.mTvMota.setText(order.getMota());
        orderHolder.mTvNgayDat.setText(order.getNgaydatyeucau());
        orderHolder.mTvTenKhachhang.setText(order.getHotenKH());
        orderHolder.mTvTenTho.setText(order.getHotenTho() + "");
        Log.e("hotenthoLog", order.getHotenTho() + "");

        orderHolder.mLnOrderItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String orderDetail = new Gson().toJson(order);
                mClickOrderDetail.orderDetail(orderDetail);
            }
        });


    }

    @Override
    public int getItemCount() {
        return mListOrder.size();
    }


}
