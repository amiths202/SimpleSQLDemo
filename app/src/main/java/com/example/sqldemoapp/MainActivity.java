package com.example.sqldemoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DBHelper db;
    EditText name,number;
    Button submit,delete,display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DBHelper(this);
        name = findViewById(R.id.nameMain);
        number = findViewById(R.id.numberMain);
        display = findViewById(R.id.viewMain);
        delete = findViewById(R.id.deleteMain);
        submit = findViewById(R.id.submitMain);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean foo = db.addData(name.getText().toString(),number.getText().toString());
                if(!foo){
                    Toast.makeText(getApplicationContext(),"Failed! Try Again",Toast.LENGTH_SHORT).show();
                }else{
                Toast.makeText(getApplicationContext(),"Added Sucessfully",Toast.LENGTH_SHORT).show();
                }
                name.setText("");
                number.setText("");
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent delete = new Intent(MainActivity.this,DeleteUser.class);
                startActivity(delete);
            }
        });
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent display = new Intent(MainActivity.this,DisplayUsers.class);
                startActivity(display);
            }
        });

    }
}