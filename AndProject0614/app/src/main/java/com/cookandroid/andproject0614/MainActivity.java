package com.cookandroid.andproject0614;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioButton rd2, rd3;
    RadioGroup rg;
    Button btn1,btn2,btn;
    String grade;
    CheckBox chk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("소영잉");
        rg=findViewById(R.id.rg);
        rd2=findViewById(R.id.rd2);
        rd3=findViewById(R.id.rd3);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn=findViewById(R.id.btn);
        chk=findViewById(R.id.chk);

        chk.setChecked(true);
        chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)btn.setEnabled(true);
                else btn.setEnabled(false);
            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==0){
                    grade="2학년";
                }else{
                    grade="3학년";
                }
                if (radioGroup.getCheckedRadioButtonId()==R.id.rd2){
                    grade=rd2.getText().toString();
                }else{
                    grade=rd3.getText().toString();
                }
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"선택한 학년"+grade, Toast.LENGTH_SHORT).show();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rg.clearCheck();
                Toast.makeText(getApplicationContext(),"선택 취소함", Toast.LENGTH_SHORT).show();
            }
        });



    }
}