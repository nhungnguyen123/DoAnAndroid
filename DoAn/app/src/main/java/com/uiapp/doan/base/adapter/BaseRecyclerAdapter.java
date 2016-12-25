package com.uiapp.doan.base.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by hongnhung on 10/23/16.
 */

public class BaseRecyclerAdapter extends RecyclerView.Adapter {


    protected ArrayList<IRecyclerItem> mItems;
    protected OnItemClickListener listener;


    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mItems != null ? mItems.size() : 0;
    }

    @Override
    public int getItemViewType(int position) {
        if (mItems.size() > 0) {
            return mItems.get(position).getItemViewType();
        }
        return -1;
    }
}
