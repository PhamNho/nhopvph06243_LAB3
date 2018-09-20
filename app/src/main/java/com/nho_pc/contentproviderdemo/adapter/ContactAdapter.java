package com.nho_pc.contentproviderdemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nho_pc.contentproviderdemo.R;
import com.nho_pc.contentproviderdemo.holder.ContactHolder;
import com.nho_pc.contentproviderdemo.model.MyContact;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactHolder> {

    private Context context;
    private List<MyContact> myContacts;

    public ContactAdapter(Context context, List<MyContact> myContacts) {
        this.context = context;
        this.myContacts = myContacts;
    }

    @NonNull
    @Override
    public ContactHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_contact,parent,false);
        return new ContactHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactHolder holder, int position) {

        holder.tvName.setText(myContacts.get(position).name);
        holder.tvPhone.setText(myContacts.get(position).phone);

    }

    @Override
    public int getItemCount() {
        if (myContacts==null){
            return 0;
        }
        return myContacts.size();
    }
}