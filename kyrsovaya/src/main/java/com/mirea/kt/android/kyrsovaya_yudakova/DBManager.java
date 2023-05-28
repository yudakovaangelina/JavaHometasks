package com.mirea.kt.android.kyrsovaya_yudakova;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DBManager {
    public SQLiteOpenHelper sqLiteOpenHelper;

    public DBManager() {
    }

    public DBManager(SQLiteOpenHelper sqLiteOpenHelper) {
        this.sqLiteOpenHelper = sqLiteOpenHelper;
    }



    public boolean saveTermToDatabase(Dictionary term){
        SQLiteDatabase db = this.sqLiteOpenHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("term", term.getTerm());
        cv.put("definition", term.getDefinition());

        long rowId = db.insert("TABLE_DICTIONARY", null, cv);
        cv.clear();
        db.close();
        Log.i("simple_app_tag", "save phone to database");
        return rowId !=1;
    }

    public ArrayList<Dictionary> loadAllTermsFromDatabase(){
        ArrayList<Dictionary> terms = new ArrayList<>();
        SQLiteDatabase db = this.sqLiteOpenHelper.getWritableDatabase();
        Cursor dbCursor = db.query("TABLE_DICTIONARY", null, null, null, null, null, null);
        if(dbCursor.moveToFirst()){
            do{
                String term = dbCursor.getString(dbCursor.getColumnIndexOrThrow("term"));
                String definition = dbCursor.getString(dbCursor.getColumnIndexOrThrow("definition"));

                terms.add(new Dictionary(term, definition));
            }while (dbCursor.moveToNext());


        }
        Log.i("simple_app_tag", "load phones from database");
        dbCursor.close();
        db.close();
        return terms;
    }
    public String getDefinition(String term) {
        String definition = "";
        SQLiteDatabase db = this.sqLiteOpenHelper.getReadableDatabase();
        String[] columns = {"definition"};
        String selection = "term=?";
        String[] selectionArgs = {term};
        Cursor cursor = db.query("terms", columns, selection, selectionArgs, null, null, null);
        if (cursor.moveToFirst()) {
            definition = cursor.getString(0);
        }
        cursor.close();
        db.close();
        return definition;
    }



    }

