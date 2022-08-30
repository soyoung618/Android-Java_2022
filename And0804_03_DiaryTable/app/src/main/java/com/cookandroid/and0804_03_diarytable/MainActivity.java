package com.cookandroid.and0804_03_diarytable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnWrite,btnList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnWrite=findViewById(R.id.btnWrite);
        btnList=findViewById(R.id.btnList);

        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cYear = Calendar.getInstance().get(Calendar.YEAR);
                int cMonth = Calendar.getInstance().get(Calendar.MONTH);
                int cDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
                String fileName = (cYear) + "_" + (cMonth + 1) + "_" + (cDay);
                Intent in = new Intent(getApplicationContext(), Diary_1.class);
                in.putExtra("fname", fileName);
                in.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(in);
            }

        });
        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(), list.class);
                startActivity(in);
            }
        });
    }
}