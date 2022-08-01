package com.cookandroid.and0801_02_ativityone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg;
    Button btn;
    EditText edtContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn =findViewById(R.id.btn);
        rg=findViewById(R.id.rg);
        edtContent=findViewById(R.id.edtContent);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str =edtContent.getText().toString(); //넘겨줄 값 가져오기
                if(rg.getCheckedRadioButtonId()==R.id.rbSecond){
                    Intent in  = new Intent(getApplicationContext(),SecondActivity.class);
                    in.putExtra("Content",str); //SecondActivity 화면에 열기
                    startActivity(in);
                }else{
                    Intent in  = new Intent(getApplicationContext(),ThirdActivity.class);
                    in.putExtra("Content",str); //ThirdActivity 화면에 열기
                    startActivity(in);
                }

            }
        });

    }
}