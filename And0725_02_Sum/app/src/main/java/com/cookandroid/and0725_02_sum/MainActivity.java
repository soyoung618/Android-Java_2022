package com.cookandroid.and0725_02_sum;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText num;
    Button sum1;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num=findViewById(R.id.num);
        sum1=findViewById(R.id.sum1);
        result=findViewById(R.id.result);
        setTitle("소영잉");
        sum1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n = Integer.parseInt(num.getText().toString());
                int s=0;
                for(int i=1; i<=n;i++)s+=i;
                result.setText("결과 : 1~"+n+"까지 합"+s);
                num.setText("");

            }
        });

    }
}