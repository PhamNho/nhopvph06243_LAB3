package com.nho_pc.nhopvph06243_lab3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.nho_pc.nhopvph06243_lab3.ui.BookmarkActivity;
import com.nho_pc.nhopvph06243_lab3.ui.ContactActivity;

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

    public void backHome(View view) {
        finish();
    }
}
