package com.nho_pc.contentproviderdemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nho_pc.contentproviderdemo.R;
import com.nho_pc.contentproviderdemo.holder.BookmarkHolder;
import com.nho_pc.contentproviderdemo.model.MyBookmark;

import java.util.List;

public class BookmarkAdapter extends RecyclerView.Adapter<BookmarkHolder> {

    private Context context;
    private List<MyBookmark> myBookmarks;

    public BookmarkAdapter(Context context, List<MyBookmark> myBookmarks) {
        this.context = context;
        this.myBookmarks = myBookmarks;
    }

    @NonNull
    @Override
    public BookmarkHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_bookmark,parent,false);
        return new BookmarkHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookmarkHolder holder, int position) {

        holder.tvTitle.setText(myBookmarks.get(position).title);
        holder.tvUrl.setText(myBookmarks.get(position).url);

    }

    @Override
    public int getItemCount() {
        if (myBookmarks==null){
            return 0;
        }
        return myBookmarks.size();
    }
}
