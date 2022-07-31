package com.cookandroid.and0728_04_contextmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView txtName, txtTel;
    Button btnEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtName = findViewById(R.id.txtName);
        txtTel = findViewById(R.id.txtTel);
        btnEnd = findViewById(R.id.btnEnd);
        registerForContextMenu(btnEnd);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.menu, menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.num:
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("전화번호 등록");
                dlg.setIcon(R.mipmap.ic_launcher_round);
                final View dlgView =(View)View.inflate(MainActivity.this,R.layout.dlg,null);
                dlg.setView(dlgView);
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText edtName = dlgView.findViewById(R.id.edtName);
                        EditText edtTel = dlgView.findViewById(R.id.edtTel);
                        String str1 = txtName.getText().toString()+"\n";
                        txtName.setText(str1+edtName.getText().toString());
                        String str2 = txtTel.getText().toString()+"\n";
                        txtTel.setText(str2+edtTel.getText().toString());
                        Toast.makeText(getApplicationContext(),"전화번호",Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.show();
                return true;

            case R.id.item1:
                txtName.setTextColor(Color.BLUE);
                txtTel.setTextColor(Color.BLUE);
                return true;

            case R.id.item2:
                txtName.setTextColor(Color.GREEN);
                txtTel.setTextColor(Color.GREEN);
                return true;

            case R.id.item3:
                txtName.setTextColor(Color.BLACK);
                txtTel.setTextColor(Color.BLACK);
                return true;

            default: Toast.makeText(getApplicationContext(), "선택 안됨", Toast.LENGTH_SHORT).show();
                return false;
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        if(v==btnEnd){
            menu.setHeaderTitle("메뉴 선택 ");
            menuInflater.inflate(R.menu.mwnu_context, menu);

        }
    }
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item4:
                txtName.setText("");
                txtTel.setText("");
                return true;
            case R.id.item5:
                finish(); return true;
        }
    return false;
    }
}