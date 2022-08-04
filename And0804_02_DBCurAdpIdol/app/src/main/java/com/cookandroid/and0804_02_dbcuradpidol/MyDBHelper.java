package com.cookandroid.and0804_02_dbcuradpidol;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDBHelper extends SQLiteOpenHelper {
    public MyDBHelper(@Nullable Context context) {
        super(context,"groupDB.db",null,1);
        //데이터 베이스 이름 : groupDB
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //데이블 생성
        String str = "CREATE TABLE groupTBL(_id integer primary key autoincrement, gName char(20),gNumber integer);";
        sqLiteDatabase.execSQL(str);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists groupTBL");  //테이블 삭제
        onCreate(sqLiteDatabase);  //테이블 생성
    }
}
