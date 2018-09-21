package com.nho_pc.contentproviderdemo.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.nho_pc.contentproviderdemo.R;

public class BookmarkHolder extends RecyclerView.ViewHolder {
    public final TextView tvTitle;
    public final TextView tvUrl;

    public BookmarkHolder(View itemView) {
        super(itemView);
        tvTitle=itemView.findViewById(R.id.tvTitle);
        tvUrl=itemView.findViewById(R.id.tvUrl);
    }
}