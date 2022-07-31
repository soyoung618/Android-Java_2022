package com.cookandroid.and0728_02_menudlgtest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn,btn1;
    EditText edt, edt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);
        btn1 = findViewById(R.id.btn1);
        edt = findViewById(R.id.edt);
        edt1 = findViewById(R.id.edt1);
        setTitle("소영잉");

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu p = new PopupMenu(getApplicationContext(),view);
                getMenuInflater().inflate(R.menu.menu_pop_up,p.getMenu());
                p.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            case R.id.context_man :
                                edt1.setText("남자");
                                return true;
                            case R.id.context_wonman :
                                edt1.setText("여자");
                                return true;
                            default:
                                Toast.makeText(getApplicationContext(),"선택 안됨",Toast.LENGTH_SHORT).show();
                                return false;
                        }
                    }
                });
                p.show(); //팝업 출력
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                        AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                        dlg.setTitle("가입정보 확인");
                        dlg.setIcon(R.mipmap.ic_launcher_round);
                        dlg.setMessage("전화번호 : "+ edt.getText()+"\r\n성별 : "+ edt1.getText().toString());
                        dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getApplicationContext(),"가입 완료~~",Toast.LENGTH_SHORT).show();
                            }
                        });
                        dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getApplicationContext(),"가입 취소하였습니다",Toast.LENGTH_SHORT).show();
                            }
                        });
                        dlg.show();
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.menu_option,menu);

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.option_login :
                Toast.makeText(getApplicationContext(),"초기화",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.option_loginOut :
                Toast.makeText(getApplicationContext(),"종료",Toast.LENGTH_SHORT).show();
                return true;

            default:
                Toast.makeText(getApplicationContext(),"선택 안됨",Toast.LENGTH_SHORT).show();
                return false;
        }

    }

}