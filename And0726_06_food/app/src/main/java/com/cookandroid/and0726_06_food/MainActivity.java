package com.cookandroid.and0726_06_food;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    CheckBox chk;
    RadioButton rd1,rd2,rd3,rd4;
    RadioGroup rg;
    Button btn;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chk=findViewById(R.id.chk);
        rg=findViewById(R.id.rg);
        rd1=findViewById(R.id.rd1);
        rd2=findViewById(R.id.rd2);
        rd3=findViewById(R.id.rd3);
        rd4=findViewById(R.id.rd4);
        btn=findViewById(R.id.btn);
        img=findViewById(R.id.img);

        chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(chk.isChecked()==true){
                    rd1.setVisibility(View.VISIBLE);
                    rd2.setVisibility(View.VISIBLE);
                    rd3.setVisibility(View.VISIBLE);
                    rd4.setVisibility(View.VISIBLE);
                    btn.setVisibility(View.VISIBLE);
                    img.setVisibility(View.VISIBLE);
                }else{
                    rd1.setVisibility(View.INVISIBLE);
                    rd2.setVisibility(View.INVISIBLE);
                    rd3.setVisibility(View.INVISIBLE);
                    rd4.setVisibility(View.INVISIBLE);
                    btn.setVisibility(View.INVISIBLE);
                    img.setVisibility(View.INVISIBLE);
                }
            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rd1: img.setImageResource(R.drawable.mov01);
                        break;

                    case R.id.rd2: img.setImageResource(R.drawable.mov07);
                        break;

                    case R.id.rd3: img.setImageResource(R.drawable.mov08);
                        break;

                    case R.id.rd4: img.setImageResource(R.drawable.mov12);
                        break;
                }
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            rg.clearCheck();
            img.setImageResource(0);
            }
        });

    }
}