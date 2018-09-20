package com.nho_pc.contentproviderdemo.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.nho_pc.contentproviderdemo.R;

public class ContactHolder extends RecyclerView.ViewHolder {
    public final TextView tvName;
    public final TextView tvPhone;

    public ContactHolder(View itemView) {
        super(itemView);
        tvName = itemView.findViewById(R.id.tvName);
        tvPhone = itemView.findViewById(R.id.tvPhone);
    }
}
