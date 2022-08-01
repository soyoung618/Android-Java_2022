package com.cookandroid.and0801_04_ativityput2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity2 extends AppCompatActivity {
    TextView txtContent;
    Button btnReturn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result2);
        txtContent =findViewById(R.id.txtContent);
        btnReturn =findViewById(R.id.btnReturn);
        Intent in = getIntent();
        person p =(person) in.getSerializableExtra("person");
        String str = "이름: "+p.getName()+"\n 성별 : "+p.getGender()+"\n 전화번호 : "+p.getTel()+"\n 주소 : "+p.getAdd();
        txtContent.setText(str);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}