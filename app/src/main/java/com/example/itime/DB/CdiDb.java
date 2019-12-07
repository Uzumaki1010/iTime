package com.example.itime.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.itime.MainActivity;

public class CdiDb {
    public static MainActivity context;
    static SQLiteDatabase db;
    static DataBaseHelper dataBaseHelper;

    public CdiDb(){
        if(db!=null)
            db.close();
        db=new DataBaseHelper(context,"Cdi.db",null,5).getWritableDatabase();
    }

    public Cursor getCursor(){
        db=new DataBaseHelper(context,"Cdi.db",null,5).getWritableDatabase();
        Cursor cursor=db.query("Cdi",null, null,
                null, null, null, null);
        return cursor;
    }

    public void insertCdi(String title,String note,String repeat,String tag,int year,int month,int day,int imageId){
        ContentValues values=new ContentValues();
        values.put("title",title);
        values.put("note",note);
        values.put("repeat",repeat);
        values.put("tag",tag);
        values.put("year",year);
        values.put("month",month);
        values.put("day",day);
        values.put("imageId",imageId);
        db=new DataBaseHelper(context,"Cdi.db",null,5).getWritableDatabase();
        db.insert("Cdi",null,values);
    }

    public void updateCdi(int id,String title,String note,String repeat,String tag,int year,int month,int day,int imageId){
        ContentValues values=new ContentValues();
        values.put("title",title);
        values.put("note",note);
        values.put("repeat",repeat);
        values.put("tag",tag);
        values.put("year",year);
        values.put("month",month);
        values.put("day",day);
        values.put("imageId",imageId);
        db=new DataBaseHelper(context,"Cdi.db",null,5).getWritableDatabase();
        db.update("Cdi",values,"_id=?",new String[]{String.valueOf(id)});
    }

    public void deleteCdi(int id){
        db=new DataBaseHelper(context,"Cdi.db",null,5).getWritableDatabase();
        db.delete("Cdi","_id=?",new String[]{String.valueOf(id)});
    }
}
