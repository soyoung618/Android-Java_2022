package com.cookandroid.and0726_05_chkfruit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    CheckBox[] chk = new CheckBox[4];
    Integer[] chk1 ={R.id.fr1, R.id.fr2,R.id.fr3,R.id.fr4};
    Button btn;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=findViewById(R.id.btn);
        result=findViewById(R.id.result);
        for(int i=0; i<chk.length;i++)chk[i]=findViewById(chk1[i]);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str="";
                for(int i=0; i<chk.length; i++) {
                    if(chk[i].isChecked()==true){

                        str+=str+ chk[i].getText().toString() + " ";
                    }

                }if(result.equals(""))result.setText("선택하지 않았습니다.");
                else result.setText("선택 결과: "+ result );
            }
        });

        for(int i=0;i<chk.length;i++){
            final int k=i;
            chk[i].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    btn.performClick();  //btn의 onclick 함수 호출
                }
            });
        }



    }
}