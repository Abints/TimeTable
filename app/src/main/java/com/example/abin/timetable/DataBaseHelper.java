package com.example.abin.timetable;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by abin on 6/7/17.
 */

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String Database_name="Time2";
    public static final String Tname="Student2";
    public static final String col1="day";
    public static final String col2="period1";
    public static final String col3="period2";
    public static final String col4="period3";
    public static final String col5="period4";
    public static final String col6="period5";
    public static final String col7="period6";
    public DataBaseHelper(Context context)
    {
        super(context,Database_name,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+Tname+"(day text primary key,Period1 text,Period2 text,Period3 text,Period4 text,Period5 text,period6 text)");

    }

    Cursor showT(String day)
    {
        SQLiteDatabase db=getWritableDatabase();
        Cursor c=db.rawQuery("select * from Student2 where day='"+day+"'",null);
        c.moveToFirst();
        return c;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists"+Tname);
        onCreate(db);
    }
    public void clearAll()
    {
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL("delete from "+Tname);
    }
    public boolean insertData(String day,String per1,String per2,String per3,String per4,String per5,String per6) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col1, day);
        contentValues.put(col2, per1);
        contentValues.put(col3, per2);
        contentValues.put(col4, per3);
        contentValues.put(col5, per4);
        contentValues.put(col6, per5);
        contentValues.put(col7, per6);
        long result = db.insert(Tname, null, contentValues);
        if (result == -1) {
            return false;

        } else
            return true;
    }
}
