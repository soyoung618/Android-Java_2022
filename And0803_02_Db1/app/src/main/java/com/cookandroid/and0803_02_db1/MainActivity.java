package com.cookandroid.and0803_02_db1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtGName, edtGNumber;
    TextView txtGNameResult,txtGNumberResult;
    Button btnClear, btnInsert, btnSelect,btnUpdate,btnDelete;
    MyDBHelper myDBHelper;
    SQLiteDatabase sqlDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("소영잉 가수 그룹 관리 DB 실습");
        edtGName =findViewById(R.id.edtGName);
        edtGNumber=findViewById(R.id.edtGNumber);
        txtGNameResult=findViewById(R.id.txtGNameResult);
        txtGNumberResult=findViewById(R.id.txtGNumberResult);
        btnClear=findViewById(R.id.btnClear);
        btnInsert=findViewById(R.id.btnInsert);
        btnSelect=findViewById(R.id.btnSelect);
        btnUpdate=findViewById(R.id.btnUpdate);
        btnDelete=findViewById(R.id.btnDelete);
        myDBHelper = new MyDBHelper(this);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {  //DB의 테이블 삭제 후 다시 생성
                sqlDB =myDBHelper.getWritableDatabase(); //수정 모드 오픈
                myDBHelper.onUpgrade(sqlDB,1,2);  //숫자는 버전의미로 아무거나
                sqlDB.close();
                btnSelect.callOnClick();
            }
        });
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                     String name = edtGName.getText().toString().trim();
                     int num =Integer.parseInt(edtGNumber.getText().toString().trim());

                     if (name.isEmpty()){
                         Toast.makeText(getApplicationContext(),"이름 입력 필수로 해주세요",Toast.LENGTH_SHORT).show();
                     }else{
                         //String s = "이름"+name+"나이"+num;
                         sqlDB =myDBHelper.getWritableDatabase(); //수정 모드 오픈
                         sqlDB.execSQL("insert into groupTBL(gname, GNumber) values(' "+name+" ', "+num+" );"); // ' '->name은 char이기 때문에
                         sqlDB.close();
                         Toast.makeText(getApplicationContext(),"입력성공",Toast.LENGTH_SHORT).show();
                         edtGName.setText("");
                         edtGNumber.setText("");
                         btnSelect.callOnClick(); //btnSelect() 함수 호출
                     }

                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"입력실패",Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlDB = myDBHelper.getReadableDatabase();
                Cursor cursor=sqlDB.rawQuery("select * from groupTBL;",null);
                String strNames = "그룹 이름 \r\n "+"----------------\r\n";
                String strNums = "인원수 \r\n "+"----------------\r\n";
                while (cursor.moveToNext()){
                    strNames+=cursor.getString(0)+"\n";
                    strNums+=cursor.getInt(1)+"\n";

                }
                txtGNameResult.setText(strNames);
                txtGNumberResult.setText(strNums);
                cursor.close();
                sqlDB.close();
                Toast.makeText(getApplicationContext(),"조회성공",Toast.LENGTH_SHORT).show();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View v =View.inflate(getApplicationContext(),R.layout.delete,null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("그룹 삭제");
                dlg.setView(v);
                final  EditText edtDelGName =v.findViewById(R.id.edtDelGName);
                dlg.setPositiveButton("삭제", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        try {
                            sqlDB =myDBHelper.getWritableDatabase();
                            String name = edtDelGName.getText().toString().trim();
                            if(!name.isEmpty()){
                                sqlDB.execSQL("DELETE FROM groupTBL WHERE gName = '" + name + "';");
                                sqlDB.close();
                                Toast.makeText(getApplicationContext(),"삭제됨",Toast.LENGTH_SHORT).show();
                                btnSelect.callOnClick();
                            }else{
                                Toast.makeText(getApplicationContext(),"이름을 입력하세요",Toast.LENGTH_SHORT).show();
                            }

                        }catch (Exception e){
                            Toast.makeText(getApplicationContext(),"삭제실패",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                dlg.setNegativeButton("취소",null);
                dlg.show();
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View v =View.inflate(getApplicationContext(),R.layout.update,null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("그룹 정보 수정");
                dlg.setView(v);
                final  EditText edtUpdateGName =v.findViewById(R.id.edtUpdateGName);
                final  EditText edtUpdateGNumber =v.findViewById(R.id.edtUpdateGNumber);
                dlg.setPositiveButton("수정", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        try {
                            sqlDB =myDBHelper.getWritableDatabase();
                            String name = edtUpdateGName.getText().toString().trim();
                            int number =Integer.parseInt(edtUpdateGNumber.getText().toString().trim());
                            if(!name.isEmpty()){
                                String sql ="UPDATE groupTBL SET gNumber ="+ number+" WHERE gName ='"+name+"'";
                                sqlDB.execSQL(sql);
                                sqlDB.close();
                                Toast.makeText(getApplicationContext(),"수정됨",Toast.LENGTH_SHORT).show();
                                btnSelect.callOnClick();
                            }else{
                                Toast.makeText(getApplicationContext(),"이름과 인원을 입력 하세요.",Toast.LENGTH_SHORT).show();
                            }

                        }catch (Exception e){
                            Toast.makeText(getApplicationContext(),"수정실패",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                dlg.setNegativeButton("취소",null);
                dlg.show();
            }
        });


    }
}




























