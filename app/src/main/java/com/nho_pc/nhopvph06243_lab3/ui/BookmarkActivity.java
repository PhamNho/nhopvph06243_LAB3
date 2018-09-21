package com.nho_pc.nhopvph06243_lab3.ui;

import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.nho_pc.nhopvph06243_lab3.R;
import com.nho_pc.nhopvph06243_lab3.adapter.BookmarkAdapter;
import com.nho_pc.nhopvph06243_lab3.model.MyBookmark;

import java.util.ArrayList;
import java.util.List;


public class BookmarkActivity extends AppCompatActivity {
    private Button btnLoadBookmark;
    private RecyclerView lvListBookmark;
    private BookmarkAdapter bookmarkAdapter;
    private List<MyBookmark> myBookmarks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Show all bookmark");
        setContentView(R.layout.activity_bookmark);
        initViews();
        initActions();
    }

    private void initActions() {
        btnLoadBookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myBookmarks = new ArrayList<>();
                String column_title = "title";
                String column_url = "url";
                String[] projection = {column_title, column_url,};
                Cursor cursor = getContentResolver().query(Uri.parse("content://browser/bookmarks/"), projection, null, null, null);
                cursor.moveToFirst();
                while (cursor.isAfterLast() == false) {
                    String title = cursor.getString(cursor.getColumnIndex(column_title));
                    String url = cursor.getString(cursor.getColumnIndex(column_url));
                    // gán dữ liệu vào MyContact
                    MyBookmark myBookmark = new MyBookmark();
                    myBookmark.title = title;
                    myBookmark.url = url;
                    // gán dữ liệu vào ArrayList
                    myBookmarks.add(myBookmark);
                    cursor.moveToNext();
                }
                cursor.close();
                bookmarkAdapter = new BookmarkAdapter(BookmarkActivity.this, myBookmarks);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(BookmarkActivity.this);
                lvListBookmark.setLayoutManager(linearLayoutManager);
                lvListBookmark.setAdapter(bookmarkAdapter);
            }
        });
    }

    private void initViews() {
        btnLoadBookmark = (Button) findViewById(R.id.btnLoadBookmark);
        lvListBookmark = (RecyclerView) findViewById(R.id.lvListBookmark);
    }
}
