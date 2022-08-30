package com.cookandroid.and0830_loginsql;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class LoginOKActivity extends AppCompatActivity {
    TextView login_id,login_password;
    Button login_end;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_o_k);
        login_id=findViewById(R.id.login_id);
        login_password=findViewById(R.id.login_password);
        login_end=findViewById(R.id.login_end);
    }
}