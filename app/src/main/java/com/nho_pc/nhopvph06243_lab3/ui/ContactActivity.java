package com.nho_pc.nhopvph06243_lab3.ui;

import android.content.ContentResolver;
import android.content.CursorLoader;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.nho_pc.nhopvph06243_lab3.R;
import com.nho_pc.nhopvph06243_lab3.adapter.ContactAdapter;
import com.nho_pc.nhopvph06243_lab3.model.MyContact;

import java.util.ArrayList;
import java.util.List;

public class ContactActivity extends AppCompatActivity {
    private Button btnLoadContact;
    private RecyclerView lvListContact;
    private ContactAdapter contactAdapter;
    private List<MyContact> myContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Show all contact");
                          setContentView(R.layout.activity_contact);
        initViews();
//        initData();
//        initActions();
        btnLoadContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getContactList();
            }
        });

    }

//    private void initActions() {
//        btnLoadContact.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Uri uri = Uri.parse("content://contacts/people");
//                myContacts = new ArrayList<>();
//                CursorLoader cursorLoader = new CursorLoader(ContactActivity.this, uri, null, null, null, null);
//                Cursor cursor = cursorLoader.loadInBackground();
//                cursor.moveToFirst();
//                // nếu kiểm tra thấy vị trí cuối cùng không còn dữ liệu thì kết thúc vòng while
//                while (cursor.isAfterLast() == false) {
//                    String column_id= ContactsContract.Contacts._ID;
//                    String column_name= ContactsContract.Contacts.DISPLAY_NAME;
//                    //
//                    int id=cursor.getInt(cursor.getColumnIndex(column_id));
//                    String name=cursor.getString(cursor.getColumnIndex(column_name));
//                    if (cursor.getInt(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)) > 0) {
//                        Cursor c = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
//                                ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
//                                new String[]{id}, null);
//                        while (c.moveToNext()) {
//                            String phoneNumber = c.getString(c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
//                            Log.e("NameUser", "Name: " + name);
//                            Log.e("Phone Number", "Phone Number: " + phoneNumber);
//                        }
//                        c.close();
//                    }
//                    // gán dữ liệu vào MyContact
//                    MyContact myContact=new MyContact();
//                    myContact.name=name;
//                    myContact.ID=""+id;
//                    // gán dữ liệu và o ArrayList
//                    myContacts.add(myContact);
//                    cursor.moveToNext();
//                }
//                cursor.close();
//                contactAdapter = new ContactAdapter(ContactActivity.this, myContacts);
//
//                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ContactActivity.this);
//
//                lvListContact.setLayoutManager(linearLayoutManager);
//                lvListContact.setAdapter(contactAdapter);
//            }
//        });
//    }
    private void getContactList() {
        myContacts = new ArrayList<>();
        ContentResolver cr = getContentResolver();
        Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI,
                null, null, null, null);

        if ((cur != null ? cur.getCount() : 0) > 0) {
            while (cur != null && cur.moveToNext()) {
                String id = cur.getString(cur.getColumnIndex(ContactsContract.Contacts._ID));
                String name = cur.getString(cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));

                if (cur.getInt(cur.getColumnIndex(
                        ContactsContract.Contacts.HAS_PHONE_NUMBER)) > 0) {
                    Cursor pCur = cr.query(
                            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                            null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
                            new String[]{id}, null);
                    while (pCur.moveToNext()) {
                        String phoneNumber= pCur.getString(pCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        myContacts.add(new MyContact(name,id,phoneNumber));
                    }
                    pCur.close();
                }
            }
        }
        if(cur!=null){
            cur.close();
        }
        contactAdapter = new ContactAdapter(ContactActivity.this, myContacts);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ContactActivity.this);

        lvListContact.setLayoutManager(linearLayoutManager);
        lvListContact.setAdapter(contactAdapter);
    }

//    private void initData() {
//        myContacts = new ArrayList<>();
//        for (int i = 0; i < 20; i++) {
//            MyContact myContact = new MyContact();
//            myContact.name = "Nho Pham";
//            myContact.phone = "0962387053";
//
//            myContacts.add(myContact);
//        }
//        contactAdapter = new ContactAdapter(this, myContacts);
//
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//
//        lvListContact.setLayoutManager(linearLayoutManager);
//        lvListContact.setAdapter(contactAdapter);
//    }

    private void initViews() {
        btnLoadContact = (Button) findViewById(R.id.btnLoadContact);
        lvListContact = (RecyclerView) findViewById(R.id.lvListContact);
    }

}
