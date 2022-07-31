package com.cookandroid.and0727_03_gridtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView img;
    RadioGroup gr;
    RadioButton rdb1,rdb2,rdb3;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = findViewById(R.id.img);
        gr = findViewById(R.id.gr);
        rdb1 = findViewById(R.id.rdb1);
        rdb2 = findViewById(R.id.rdb2);
        rdb3 = findViewById(R.id.rdb3);
        btn = findViewById(R.id.btn);

        gr.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rdb1: img.setImageResource(R.drawable.renoir03);
                        break;

                    case R.id.rdb2: img.setImageResource(R.drawable.renoir04);
                        break;

                    case R.id.rdb3: img.setImageResource(R.drawable.renoir05);
                        break;
                }
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (gr.getCheckedRadioButtonId()){
                    case R.id.rdb1 : Toast.makeText(getApplicationContext(), "해물 파스타(9500원) 주문하셨습니다.", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rdb2 : Toast.makeText(getApplicationContext(), "토마토 파스타(9000원) 주문하셨습니다.", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rdb3 : Toast.makeText(getApplicationContext(), "까르보나라(9500원) 주문하셨습니다.", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

    }
}