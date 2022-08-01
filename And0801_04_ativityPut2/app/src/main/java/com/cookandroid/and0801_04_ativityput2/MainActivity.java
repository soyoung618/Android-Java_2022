package com.cookandroid.and0801_04_ativityput2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    EditText edtName, edtTel, edtAdd;
    RadioGroup rg;
    Button btn1;

    String name, gender, tel, add ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("메인화면");
        edtName =findViewById(R.id.edtName);
        edtTel =findViewById(R.id.edtTel);
        edtAdd =findViewById(R.id.edtAdd);
        rg =findViewById(R.id.rg);
        btn1 =findViewById(R.id.btn1);

        //rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            //@Override
            //public void onCheckedChanged(RadioGroup radioGroup, int i) {
                //if(rg.getCheckedRadioButtonId()==R.id.rdMan)gender="남자";
                //else gender="여자";
           // }
        //});
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = edtName.getText().toString();
                tel = edtTel.getText().toString();
                add = edtAdd.getText().toString();
                if(rg.getCheckedRadioButtonId()==R.id.rdMan)gender="남자";  //라디오 그룹 안해도 가능
                else gender="여자";
                person p = new person(name,gender,tel,add); //객체 생성
                Intent in = new Intent(getApplicationContext(),ResultActivity2.class);
                in.putExtra("person",p); //객체로 데이터 전송
                startActivity(in);
            }
        });
    }
}