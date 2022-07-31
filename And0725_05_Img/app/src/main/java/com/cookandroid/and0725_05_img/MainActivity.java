package com.cookandroid.and0725_05_img;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    int imgType=2;
    Button btn1,btn2;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        img=findViewById(R.id.img);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(imgType==1){
                    img.setImageResource(R.drawable.cat); imgType=2;
                }else{
                    img.setImageResource(R.drawable.fox2); imgType=1;
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(img.getVisibility()==View.VISIBLE) {
                    img.setVisibility(View.VISIBLE);
                    img.setVisibility(View.INVISIBLE);
                    btn2.setText("보이기");
                }else{
                    img.setVisibility(View.VISIBLE);
                    btn2.setText("숨기기");
                }
            }
        });
    }
}