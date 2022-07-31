package com.cookandroid.project0616;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edt1,edt2;
    Button[] btnNums = new Button[10];
    Integer[] ids={R.id.btn0,R.id.btn1,R.id.btn2,R.id.btn3,R.id.btn4,R.id.btn5,R.id.btn6,R.id.btn7,R.id.btn8,R.id.btn0};
    Button btn10,btn11,btn12;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("소영잉");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1=findViewById(R.id.edt1);
        edt2=findViewById(R.id.edt2);
        btn10=findViewById(R.id.btn10);
        btn11=findViewById(R.id.btn11);
        btn12=findViewById(R.id.btn12);
        text=findViewById(R.id.text);

        for(int i=0; i<btnNums.length;i++) {
            btnNums[i] = findViewById(ids[i]);
            final int index= i;
            btnNums[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(edt1.isFocused()){
                        String s= edt1.getText().toString()+index;
                        edt1.setText(s);
                    }else if(edt2.isFocused()){
                        String s= edt2.getText().toString()+index;
                        edt2.setText(s);
                    }else{
                        Toast.makeText(getApplicationContext(),"에디터부터 선택하세요", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }

        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x =Integer.parseInt(edt1.getText().toString());
                int y =Integer.parseInt(edt2.getText().toString());
                text.setText("계산 결과 : "+ (x+y));
            }
        });
        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x =Integer.parseInt(edt1.getText().toString());
                int y =Integer.parseInt(edt2.getText().toString());
                text.setText("계산 결과 : "+ (x-y));
            }
        });
        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x =Integer.parseInt(edt1.getText().toString());
                int y =Integer.parseInt(edt2.getText().toString());
                text.setText("계산 결과 : "+ (x*y));
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.option, menu); //xml을 메뉴로 생성
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int x =Integer.parseInt(edt1.getText().toString());
        int y =Integer.parseInt(edt2.getText().toString());
        switch (item.getItemId()){
            case R.id.itemAdd :
                text.setText("계산 결과 : "+ (x+y));
                break;
            case R.id.itemMul:
                text.setText("계산 결과 : "+ (x*y));
                break;
            case R.id.itemExit:
                finish();
        }
        return true;
    }
}













