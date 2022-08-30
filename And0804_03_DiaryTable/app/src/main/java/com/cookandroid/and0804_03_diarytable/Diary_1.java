package com.cookandroid.and0804_03_diarytable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.util.Calendar;
import java.util.List;

public class Diary_1 extends AppCompatActivity {
    DatePicker dataPicker1;
    EditText edtDiary;
    Button btnDWrite ,btnDel;

    String fileName;
    MyDBHelper myDBHelper;
    SQLiteDatabase sqlDB;

    int cYear,cMonth,cDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_1);
        setTitle("일기장 SQLite 소영잉");
        dataPicker1 = findViewById(R.id.dataPicker1);
        edtDiary = findViewById(R.id.edtDiary);
        btnDWrite = findViewById(R.id.btnDWrite);
        btnDel = findViewById(R.id.btnDel);

        Intent in =getIntent();
        String fname =in.getStringExtra("fname");  //2022_08_05>>{"2022","08","05"}
        String[] arr =fname.split("_"); //"_" 문자로 분리>> 문자 배열 처리
        cYear=Integer.parseInt(arr[0]);  //2022
        cMonth=Integer.parseInt(arr[1])-1; //08 >>자바에서 월은 0부터 시작
        cDay=Integer.parseInt(arr[2]);  //05

        myDBHelper =new MyDBHelper(this);
        fileName = (cYear) + "_" + (cMonth + 1) + "_" + (cDay);  //숫자+문자 >> 문자열로 자동 형변환
        String str =readDiary(fileName);
        edtDiary.setText(str);

        dataPicker1.init(cYear, cMonth, cDay, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int y, int m, int d) {
                fileName =  y + "_" + (m + 1) + "_" + d;
                String str = readDiary(fileName);//일기 있으면 읽어오기
                edtDiary.setText(str);
            }
        });
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    sqlDB=myDBHelper.getWritableDatabase();
                    sqlDB.execSQL("delete form DiaryTBL where diaryDate ='"+fileName+"';");
                    sqlDB.close();
                    Toast.makeText(getApplicationContext(),"삭제됨",Toast.LENGTH_SHORT).show();
                    edtDiary.setText("");
                    btnDWrite.setText("새로 저장");
                    btnDel.setVisibility(View.GONE);
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"삭제 실패",Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnDWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btnDWrite.getText().toString().equals("새로저장")){  //insert 처리
                    sqlDB=myDBHelper.getWritableDatabase();
                    sqlDB.execSQL("INSERT INTO DiaryTBL(diaryDate, content)"+"VALUES('"+fileName+"','"+edtDiary.getText().toString()+"');");
                    sqlDB.close();
                    Toast.makeText(getApplicationContext(),"입력됨",Toast.LENGTH_SHORT).show();
                    btnDWrite.setText("수정하기");
                    btnDel.setVisibility(View.VISIBLE);
                }else{ //update 처리
                    sqlDB=myDBHelper.getWritableDatabase();
                    sqlDB.execSQL("UPDATE DiaryTBL SET content = '"+edtDiary.getText().toString()+"'WHERE diaryDate ='"+fileName+"';");
                    sqlDB.close();
                    Toast.makeText(getApplicationContext(),"수정됨",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    public String readDiary(String fName){
        String diartStr = null;//일기 내용 저장하는 변수
        sqlDB=myDBHelper.getReadableDatabase();
        Cursor cursor;
        cursor=sqlDB.rawQuery("SELECT * FROM DiaryTBL WHERE diaryDate ='"+fName+"';",null);
        if (cursor.moveToFirst() == true){
            diartStr = cursor.getString(2);
            btnDWrite.setText("수정하기");
            btnDel.setVisibility(View.VISIBLE);  //삭제 버튼 보이도록 처리
        }else{
            btnDel.setVisibility(View.GONE);  //삭제 버튼 어뵤애기
            btnDWrite.setText("새로저장");
        }
        cursor.close();
        sqlDB.close();
        return diartStr;
        }
    }























