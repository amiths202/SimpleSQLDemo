package com.example.sqldemoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteUser extends AppCompatActivity {
    DBHelper db;
    EditText number;
    Button del;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_user);

        db = new DBHelper(this);
        number = findViewById(R.id.numberDelete);
        del = findViewById(R.id.submitDelete);


        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!db.deleteData(number.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Failed! Try Again", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Deleted", Toast.LENGTH_SHORT).show();
                }
                number.setText("");
            }
        });
    }
}