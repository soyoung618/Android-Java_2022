package com.cookandroid.viewfilptest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    ViewFlipper viewFlilp;
    Button btnPre, btnNext, btnStrat, btnStop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("소영잉[뷰플리퍼 실습]");
        viewFlilp=findViewById(R.id.viewFlip);
        btnPre=findViewById(R.id.btnPre);
        btnNext=findViewById(R.id.btnNext);
        btnStrat=findViewById(R.id.btnStrat);
        btnStop=findViewById(R.id.btnStop);

        btnPre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewFlilp.showPrevious();
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewFlilp.showNext();
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewFlilp.setFlipInterval(200);
                viewFlilp.startFlipping();
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewFlilp.startFlipping();
            }
        });
    }
}

