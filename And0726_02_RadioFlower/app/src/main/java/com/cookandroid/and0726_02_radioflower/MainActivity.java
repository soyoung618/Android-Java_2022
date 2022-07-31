package com.cookandroid.and0726_02_radioflower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg;
    RadioButton flo1,flo2,flo3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg =findViewById(R.id.rg);
        flo1 =findViewById(R.id.flo1);
        flo2 =findViewById(R.id.flo2);
        flo3 =findViewById(R.id.flo3);
    }

    public void onRadioBtn(View view) {
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.flo1 : Toast.makeText(getApplicationContext(), "장미", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.flo2 : Toast.makeText(getApplicationContext(), "팬지", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.flo3 : Toast.makeText(getApplicationContext(), "백합", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
}