package com.cookandroid.and0801_02_ativityone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg;
    RadioButton rbSecond,rbThird;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rbSecond =findViewById(R.id.rbSecond);
        rbThird =findViewById(R.id.rbThird);
        btn =findViewById(R.id.btn);
        rg=findViewById(R.id.rg);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rg.getCheckedRadioButtonId()==R.id.rbSecond){
                    Intent in  = new Intent(getApplicationContext(),SecondActivity.class);
                    startActivity(in);
                }else{
                    Intent in  = new Intent(getApplicationContext(),ThirdActivity.class);
                    startActivity(in);
                }

            }
        });

    }
}