package com.cookandroid.frametest;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button [] btns = new Button[3]; //객체배열
    Integer[] btnIds ={R.id.btn1,R.id.btn2,R.id.btn3};
    TextView[] txts = new TextView[3]; //객체배열
    Integer[] txtIds ={R.id.txt1,R.id.txt2,R.id.txt3};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("소영잉");
        for(int i=0;i<btns.length;i++){
            btns[i] = findViewById(btnIds[i]);
            txts[i] = findViewById(txtIds[i]);
        }
        txts[1].setVisibility(View.INVISIBLE);
        txts[2].setVisibility(View.INVISIBLE);

        for(int i=0;i<btns.length;i++) {
            btns[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch (view.getId()){
                        case R.id.btn1:
                            txts[0].setVisibility(View.VISIBLE);
                            txts[1].setVisibility(View.INVISIBLE);
                            txts[2].setVisibility(View.INVISIBLE);
                            btns[0].setBackgroundColor((Color.rgb(248,202,218)));
                            btns[1].setBackgroundColor(Color.rgb(255,180,206));
                            btns[2].setBackgroundColor((Color.rgb(245,151,184)));
                            break;
                        case R.id.btn2:
                            txts[1].setVisibility(View.VISIBLE);
                            txts[0].setVisibility(View.INVISIBLE);
                            txts[2].setVisibility(View.INVISIBLE);
                            btns[1].setBackgroundColor((Color.rgb(248,202,218)));
                            btns[0].setBackgroundColor(Color.rgb(255,180,206));
                            btns[2].setBackgroundColor((Color.rgb(245,151,184)));
                            break;
                        case R.id.btn3:
                            txts[2].setVisibility(View.VISIBLE);
                            txts[1].setVisibility(View.INVISIBLE);
                            txts[0].setVisibility(View.INVISIBLE);
                            btns[2].setBackgroundColor((Color.rgb(248,202,218)));
                            btns[1].setBackgroundColor(Color.rgb(255,180,206));
                            btns[0].setBackgroundColor((Color.rgb(245,151,184)));
                            break;

                    }
                }
            });
        }
    }
}