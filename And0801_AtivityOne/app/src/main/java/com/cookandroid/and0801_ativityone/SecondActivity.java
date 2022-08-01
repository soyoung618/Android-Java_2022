package com.cookandroid.and0801_ativityone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {
    Button btnSecond;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        setTitle("소영잉 두번째 화면");
        btnSecond =findViewById(R.id.btnSecond);
        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent in  = new Intent(getApplicationContext(),MainActivity.class);
                //startActivity(in);  //SecondActivity 화면에 열기
                finish();
            }
        });
    }
}