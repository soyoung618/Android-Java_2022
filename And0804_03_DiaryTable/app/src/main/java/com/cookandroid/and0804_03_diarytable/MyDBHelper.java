package com.cookandroid.and0804_03_diarytable;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDBHelper extends SQLiteOpenHelper {
    public  MyDBHelper(@Nullable Context context) {super(context,"myDiaryDB",null,1);}
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE DiaryTBL (_id integer PRIMARY KEY autoincrement ,"+"diaryDate CHAR(10), content VARCHAR(500))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS DiaryTBL");
        onCreate(sqLiteDatabase);
    }
}
