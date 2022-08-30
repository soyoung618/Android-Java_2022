package com.cookandroid.and0830_loginsql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText main_id,main_password;
    Button main_login,main_sign_up;
    SQLiteDatabase sqlDB;
    MyDBHelper myDBHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main_id=findViewById(R.id.main_id);
        main_password=findViewById(R.id.main_password);
        main_login=findViewById(R.id.main_login);
        main_sign_up=findViewById(R.id.main_sign_up);
        myDBHelper = new MyDBHelper(this);
        main_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(in);
            }
        });
        main_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userID = main_id.getText().toString().trim();
                String userPass = main_password.getText().toString().trim();
                sqlDB=myDBHelper.getReadableDatabase();
                Cursor cursor;
                cursor = sqlDB.rawQuery("SELECT userID, userPass FROM user where userID='"+userID+"' and userPass='"+userPass+"';", null);
                if (cursor.moveToFirst()){
                    Intent in = new Intent(MainActivity.this,LoginOKActivity.class);
                    in.putExtra("userID",userID);
                    in.putExtra("userPass",userPass);
                    startActivity(in);
                }
                else{
                    Toast.makeText(getApplicationContext(),"로그인 실패(id, pw확인)",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}