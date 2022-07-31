package com.cookandroid.and0725_03_keylisn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt=findViewById(R.id.edt);
        edt.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int j, KeyEvent keyEvent) {
                if (keyEvent.getAction() == KeyEvent.ACTION_UP) {
                    Toast.makeText(getApplicationContext(), edt.getText().toString(), Toast.LENGTH_SHORT).show();
                }
                if (keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                    int n = Integer.parseInt(edt.getText().toString());
                    int s = 0;
                    for (int i = 1; i <= n; i++) s += i;
                    String str = "결과:1~" + n + "까지 합=" + s;
                    Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
                }
                return  false;
            }
        });
    }
}