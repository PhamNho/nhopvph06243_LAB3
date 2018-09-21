package com.nho_pc.contentproviderdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.nho_pc.contentproviderdemo.ui.BookmarkActivity;
import com.nho_pc.contentproviderdemo.ui.ContactActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showBai1(View view) {
        startActivity(new Intent(MainActivity.this, ContactActivity.class));
    }

    public void showBai2(View view) {
        startActivity(new Intent(MainActivity.this, BookmarkActivity.class));
    }
}
