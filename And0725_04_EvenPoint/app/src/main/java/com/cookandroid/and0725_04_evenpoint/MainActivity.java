package com.cookandroid.and0725_04_evenpoint;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edt_num, edt_point;
    Button btn_sum, btn_point;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_num = findViewById(R.id.edt_num);
        edt_point = findViewById(R.id.edt_point);
        btn_sum = findViewById(R.id.btn_sum);
        btn_point = findViewById(R.id.btn_point);
        result = findViewById(R.id.result);

        btn_sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int f = Integer.parseInt(edt_num.getText().toString());
                int l = Integer.parseInt(edt_point.getText().toString());
                int sum = 0;

                for (int i=f; i<l; i++){
                    if(i%2 == 0) {
                        sum = sum+i;
                    }
                }

                result.setText("짝수의 합 결과는 "+sum+"입니다");
            }
        });

        btn_point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int f = Integer.parseInt(edt_num.getText().toString());
                int l = Integer.parseInt(edt_point.getText().toString());

                int x = l - (l % f);

                result.setText("사용가능 포인트는 "+x+"입니다");
            }
        });
    }
}