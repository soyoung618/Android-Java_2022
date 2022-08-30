package com.cookandroid.and0804_03_diarytable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class list extends AppCompatActivity {
    ListView list;
    MyDBHelper myDBHelper;
    Cursor cursor;
    SQLiteDatabase sqlDB;
    DiaryAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        list=findViewById(R.id.list);
        myDBHelper = new MyDBHelper(this);
        sqlDB =myDBHelper.getReadableDatabase();
        cursor=sqlDB.rawQuery("SELECT * FROM DiaryTBL order by diaryDate desc;",null);
        if (cursor.getCount()>0){
            adapter=new DiaryAdapter(list.this,cursor,true);
            list.setAdapter(adapter);
        }else{
            adapter=null;
            list.setAdapter(adapter);
            Toast.makeText(getApplicationContext(),"일기 없음",Toast.LENGTH_SHORT).show();
        }
        sqlDB.close();
       list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               TextView txtName =view.findViewById(R.id.txtName);
               Intent in = new Intent(getApplicationContext(),Diary_1.class);
               in.putExtra("fname",txtName.getText().toString());
               startActivity(in);
               finish();
           }
       });
    }
}