package com.cookandroid.and0727_04_framebank;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn1,btn2,btn3,lbtn1,lbtn2,lbtn3;
    LinearLayout line1,line2,line3;
    EditText edt1,edt2;
    TextView txt;
    int total=10000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);

        lbtn2=findViewById(R.id.lbtn2);
        lbtn3=findViewById(R.id.lbtn3);
        line1=findViewById(R.id.line1);
        line2=findViewById(R.id.line2);
        line3=findViewById(R.id.line3);
        edt1=findViewById(R.id.edt1);
        edt2=findViewById(R.id.edt2);
        txt=findViewById(R.id.txt);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn1.setBackgroundColor(Color.parseColor("#F4F47F"));
                btn2.setBackgroundColor(Color.parseColor("#E1DDDD"));
                btn3.setBackgroundColor(Color.parseColor("#E1DDDD"));
                line1.setVisibility(View.VISIBLE);
                line2.setVisibility(View.INVISIBLE);
                line3.setVisibility(View.INVISIBLE);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn1.setBackgroundColor(Color.parseColor("#E1DDDD"));
                btn2.setBackgroundColor(Color.parseColor("#F4F47F"));
                btn3.setBackgroundColor(Color.parseColor("#E1DDDD"));
                line1.setVisibility(View.INVISIBLE);
                line2.setVisibility(View.VISIBLE);
                line3.setVisibility(View.INVISIBLE);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn1.setBackgroundColor(Color.parseColor("#E1DDDD"));
                btn2.setBackgroundColor(Color.parseColor("#E1DDDD"));
                btn3.setBackgroundColor(Color.parseColor("#F4F47F"));
                line1.setVisibility(View.INVISIBLE);
                line2.setVisibility(View.INVISIBLE);
                line3.setVisibility(View.VISIBLE);
            }
        });
        lbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n = Integer.parseInt(edt1.getText().toString());
                total +=n; txt.setText("잔액: "+total);
                Toast.makeText(getApplicationContext(),n+"원 입금하였습니다.", Toast.LENGTH_SHORT).show();
                edt1.setText("0");
            }
        });
        lbtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n = Integer.parseInt(edt2.getText().toString());
                total -=n; txt.setText("잔액: "+total);
                Toast.makeText(getApplicationContext(),n+"원 출금하였습니다.", Toast.LENGTH_SHORT).show();
                edt2.setText("0");
            }
        });



    }
}