package com.cookandroid.and0804_02_dbcuradpidol;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtGName, edtGNumber;
    TextView txtGNameResult, txtGNumberResult;
    Button btnClear, btnInsert, btnSelect;

    MyDBHelper myDBHelper;
    ListView listView;
    SQLiteDatabase sqlDB;
    IdolAdaper cAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("소영잉 가수 그룹 관리 DB 실습");
        edtGName = findViewById(R.id.edtGName);
        edtGNumber = findViewById(R.id.edtGNumber);
        txtGNameResult = findViewById(R.id.txtGNameResult);
        txtGNumberResult = findViewById(R.id.txtGNumberResult);
        btnClear = findViewById(R.id.btnClear);
        btnInsert = findViewById(R.id.btnInsert);
        btnSelect = findViewById(R.id.btnSelect);
        listView = findViewById(R.id.listView);
        myDBHelper = new MyDBHelper(this);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView txtName = view.findViewById(R.id.txtGNameResult);
                TextView txtTel = view.findViewById(R.id.txtGNumberResult);
                String out = "그룹명 : " + txtName.getText().toString();
                out += "\n 인원수 : " + txtTel.getText().toString();
                Toast.makeText(getApplicationContext(), out, Toast.LENGTH_SHORT).show();
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {  //DB의 테이블 삭제 후 다시 생성
                sqlDB = myDBHelper.getWritableDatabase(); //수정 모드 오픈
                myDBHelper.onUpgrade(sqlDB, 1, 2);  //숫자는 버전의미로 아무거나
                sqlDB.close();
                btnSelect.callOnClick();
            }
        });

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String name = edtGName.getText().toString().trim();
                    int num = Integer.parseInt(edtGNumber.getText().toString().trim());

                    if (name.isEmpty()) {
                        Toast.makeText(getApplicationContext(), "이름 입력 필수로 해주세요", Toast.LENGTH_SHORT).show();
                    } else {
                        //String s = "이름"+name+"나이"+num;
                        sqlDB = myDBHelper.getWritableDatabase(); //수정 모드 오픈
                        sqlDB.execSQL("insert into groupTBL(gname, GNumber) values('" + name + "', " + num + " );"); // ' '->name은 char이기 때문에
                        sqlDB.close();
                        Toast.makeText(getApplicationContext(), "입력성공", Toast.LENGTH_SHORT).show();
                        edtGName.setText("");
                        edtGNumber.setText("");
                        btnSelect.callOnClick(); //btnSelect() 함수 호출
                    }

                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "입력실패", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlDB=myDBHelper.getReadableDatabase();
                Cursor cursor =sqlDB.rawQuery("SELECT * FROM groupTBL;",null);
                if (cursor.getCount()>0){
                    cAdapter = new IdolAdaper(MainActivity.this, cursor ,true);
                    listView.setAdapter(cAdapter);
                }else{ //초기화 되어 테이블이 없는 경우 adapter 초기화 시킴
                    cAdapter=null;
                    listView.setAdapter(cAdapter);
                }
                sqlDB.close();
                Toast.makeText(getApplicationContext(),"조회됨",Toast.LENGTH_SHORT).show();
            }
        });
    }
}





















