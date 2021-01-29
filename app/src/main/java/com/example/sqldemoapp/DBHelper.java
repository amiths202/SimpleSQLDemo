package com.example.sqldemoapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBName = "sampleDB";
    public static final String TBName = "sampleTable";
    public static final int version = 1;

    public DBHelper(@Nullable Context context) {
        super(context, DBName, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TBName + "(name text, number text primary key);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TBName);
        onCreate(sqLiteDatabase);
    }

    public boolean addData(String name,String number){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name",name);
        cv.put("number",number);
        long result = sqLiteDatabase.insert(TBName,null,cv);
        if(result==-1){
            sqLiteDatabase.close();
            return false;
        }
        sqLiteDatabase.close();
        return true;
    }

    public boolean deleteData(String number){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        long result = sqLiteDatabase.delete(TBName,"number=?",new String[]{number});
        if(result==-1){
            sqLiteDatabase.close();
            return false;
        }
        sqLiteDatabase.close();
        return true;
    }

    public boolean updateData(String nameNew,String number){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name",nameNew);
        cv.put("number",number);
        long result = sqLiteDatabase.update(TBName,cv,"number=?",new String[]{number});
        if(result==-1){
            sqLiteDatabase.close();
            return false;
        }
        sqLiteDatabase.close();
        return true;
    }

    public Cursor selectAll(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor;
        cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TBName +" ;",null);
        return cursor;
    }


}
