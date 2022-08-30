package com.cookandroid.and0830_loginsql;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {
    EditText register_id,register_password,register_name,register_age;
    Button register_sign_up;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        register_id=findViewById(R.id.register_id);
        register_password=findViewById(R.id.register_password);
        register_name=findViewById(R.id.register_name);
        register_age=findViewById(R.id.register_age);
        register_sign_up=findViewById(R.id.register_sign_up);
    }
}