package com.example.sqldemoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayUsers extends AppCompatActivity {
    TextView textView;
    DBHelper db;
    Cursor cur;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_users);
        db = new DBHelper(this);
        textView = findViewById(R.id.display);
        cur = db.selectAll();
        StringBuilder data = new StringBuilder();
        if (cur.moveToFirst()){
            while(!cur.isAfterLast()){
                data.append("Name: " + cur.getString(cur.getColumnIndex("name")));
                data.append("\nNumber: "+cur.getString(cur.getColumnIndex("number")));
                data.append("\n\n");
                // do what ever you want here
                cur.moveToNext();
            }
        }
        cur.close();
        textView.setText(data);
    }
}