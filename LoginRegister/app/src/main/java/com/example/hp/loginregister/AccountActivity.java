package com.example.hp.loginregister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class AccountActivity extends AppCompatActivity {


    Storage s;
    ListView listView;
    ArrayList<String> notes;
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        listView = findViewById(R.id.abc);
        s = new Storage(getApplicationContext());
        Intent intent = getIntent();
        String username = intent.getStringExtra("Username");


        notes = s.show(username);
        arrayAdapter = new ArrayAdapter<>(AccountActivity.this, android.R.layout.simple_list_item_1,notes);

        listView.setAdapter(arrayAdapter);

    }
}
