package com.mirea.kt.android.a2_12;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyAppSQLiteHelper extends SQLiteOpenHelper {
    public MyAppSQLiteHelper( Context c,  String name, SQLiteDatabase.CursorFactory f, int version) {
        super(c, name, f, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i("simple_app_tag", "Создание базы данных");
        db.execSQL("create table " + "TABLE_PHONES" + "("
        + "_id integer primary key autoincrement,"
        + "model String,"
        + "serial_number String,"
        + "price integer" + ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
