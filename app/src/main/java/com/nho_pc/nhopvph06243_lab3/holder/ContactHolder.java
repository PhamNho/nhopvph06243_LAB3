package com.nho_pc.nhopvph06243_lab3.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.nho_pc.nhopvph06243_lab3.R;

public class ContactHolder extends RecyclerView.ViewHolder {
    public final TextView tvName;
    public final TextView tvID;
    public final TextView tvPhone;

    public ContactHolder(View itemView) {
        super(itemView);
        tvName = itemView.findViewById(R.id.tvName);
        tvID = itemView.findViewById(R.id.tvID);
        tvPhone = itemView.findViewById(R.id.tvPhone);
    }
}
