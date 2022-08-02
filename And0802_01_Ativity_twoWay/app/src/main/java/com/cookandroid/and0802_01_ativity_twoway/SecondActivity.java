package com.cookandroid.and0802_01_ativity_twoway;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {
    Button btnReturn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        btnReturn =findViewById(R.id.btnReturn);

        Intent in =getIntent();
        int x =in.getIntExtra("Num1",0);
        int y =in.getIntExtra("Num2",0);
        String op =in.getStringExtra("op");
        int sum =0;

        switch (op){
            case "+":sum=x+y; break;
            case "-":sum=x-y; break;
            case "*":sum=x*y; break;
            case "/":sum=x/y; break;
            default: sum=0;
        }

        int finalSum = sum;
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent out = new Intent(getApplicationContext(),MainActivity.class);
                out.putExtra("sum", finalSum); //객체로 데이터 전송
                setResult(RESULT_OK, out);
                finish();
            }
        });

    }
}