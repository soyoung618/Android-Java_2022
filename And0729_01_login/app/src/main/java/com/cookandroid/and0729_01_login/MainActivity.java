package com.cookandroid.and0729_01_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtName, edtNum;
    Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtName = findViewById(R.id.edtName);
        edtNum = findViewById(R.id.edtNum);
        btnlog = findViewById(R.id.btnlog);
        btncan = findViewById(R.id.btncan);
        btnlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("가입 정보 확인");
                dlg.setIcon(R.mipmap.ic_launcher_round);
                dlg.setMessage("아이디: "+edtName.getText() +"\n비밀번호: "+ edtNum.getText());
                dlg.setPositiveButton("확인", null);
                dlg.show();
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "확인을 눌렀네요",
                                Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.show();
            }
        });
        btncan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu p = new PopupMenu(getApplicationContext(), view);
                getMenuInflater().inflate(R.menu.menu_popup, p.getMenu());
                p.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch(menuItem.getItemId()){
                            case R.id.popup_clear:
                                edtId.setText("");
                                edtPw.setText("");
                                return true;

                            case R.id.popup_finish:
                                finish();
                                return true;

                            default: return false;
                        }
                    }
                });
                p.show();
            }
        });
    }

}
