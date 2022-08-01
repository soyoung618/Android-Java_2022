package com.cookandroid.and0801_03_ativityput;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView edtName,edtAge;
    CheckBox chkGame,chkMusic,chkSport;
    Button btn1;
    String name;
    int age;
    ArrayList<String> hobby = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtName =findViewById(R.id.edtName);
        edtAge =findViewById(R.id.edtAge);
        chkGame =findViewById(R.id.chkGame);
        chkMusic =findViewById(R.id.chkMusic);
        chkSport =findViewById(R.id.chkSport);
        btn1 =findViewById(R.id.btn1);

        chkGame.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    hobby.add(chkGame.getText().toString());
                }else{
                    hobby.remove((hobby.indexOf(chkGame.getText().toString())));
                }
            }
        });
        chkMusic.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    hobby.add(chkMusic.getText().toString());
                }else{
                    hobby.remove((hobby.indexOf(chkMusic.getText().toString())));
                }
            }
        });
        chkSport.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    hobby.add(chkSport.getText().toString());
                }else{
                    hobby.remove((hobby.indexOf(chkSport.getText().toString())));
                }
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name =edtName.getText().toString();
                try {
                    age = Integer.parseInt(edtAge.getText().toString());
                }catch (Exception e){

                }
                Intent in = new Intent(getApplicationContext(),MainActivity2.class);
                in.putExtra("name",name);
                in.putExtra("age",age);
                in.putExtra("hobby",hobby);
                startActivity(in);
            }
        });
    }
}