package com.cookandroid.and0726_03_radioidol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg;
    RadioButton id1,id2,id3;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg =findViewById(R.id.rg);
        id1 =findViewById(R.id.id1);
        id2 =findViewById(R.id.id2);
        id3 =findViewById(R.id.id3);
        btn =findViewById(R.id.btn);

    }

    public void onRadioBtn(View view) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (rg.getCheckedRadioButtonId()){
                    case R.id.id1 : Toast.makeText(getApplicationContext(), "우주소년을 선택하셨습니다", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.id2 : Toast.makeText(getApplicationContext(), "방탄소년단을 선택하셨습니다.", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.id3 : Toast.makeText(getApplicationContext(), "세븐틴을 선택하셨습니다.", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
}

