package com.mirea.kt.android.kyrsovaya_yudakova;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MyAppSQLiteHelper extends SQLiteOpenHelper {
    private static MyAppSQLiteHelper instance;
    private static final String TABLE_FAVORITES = "favorites";
    private static final String COLUMN_FAVORITE_ID = "_id";
    private static final String COLUMN_FAVORITE_TERM_ID = "term";

    public MyAppSQLiteHelper( Context c,  String name, SQLiteDatabase.CursorFactory f, int version) {
        super(c, name, f, version);

    }
    private static final String CREATE_FAVORITES_TABLE = "CREATE TABLE " + TABLE_FAVORITES + " ("
            + COLUMN_FAVORITE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_FAVORITE_TERM_ID + " INTEGER, "
            + " FOREIGN KEY ("+ COLUMN_FAVORITE_TERM_ID +") REFERENCES "+"TABLE_DICTIONARY"+"("+"term"+"));";

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i("simple_app_tag", "Создание базы данных");
        db.execSQL("create table " + "TABLE_DICTIONARY" + "("
                + "_id integer primary key autoincrement,"
                + "term String,"
                + "definition String,"
                + "id String" + ");");

        db.execSQL("create table " + "TABLE_FAVORITES" + "("
                + "_id integer primary key autoincrement,"
                + "term String,"
                + "definition String"
                 + ");");

        String CREATE_TABLE_FAVORITES = "CREATE TABLE " + "TABLE_FAVORITES" + "("
                + "_id" + " INTEGER PRIMARY KEY,"
                + "term" + " TEXT,"
                + "definition" + " TEXT" + ")";

        db.execSQL(CREATE_TABLE_FAVORITES);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void deleteTerm(String term) {
        // Получаем объект базы данных.
        SQLiteDatabase db = this.getWritableDatabase();

        // Удаляем строку с переданным термином.
        db.delete("TABLE_DICTIONARY", "term=?", new String[]{term});

        // Закрываем соединение с базой данных.
        db.close();
    }
/*
    public boolean isFavorite(Dictionary term) {
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_FAVORITES +
                " WHERE " + "term" + " = ?";
        Cursor cursor = db.rawQuery(query, new String[]{term.getTerm()});
        boolean isFavorite = cursor.moveToFirst();
        cursor.close();
        db.close();
        return isFavorite;
    }
    public void removeFavorite(Dictionary term) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete("TABLE_FAVORITES", "term" + " = ?", new String[] {term.getTerm()});
        db.close();
    }
    public void addFavorite(int termId) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", termId);
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert("TABLE_FAVORITES", null, contentValues);
        db.close();
    }

 */

}

