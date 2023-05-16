package com.mirea.kt.android.a2_12;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;
import android.util.Log;

import java.util.ArrayList;

public class DBManager {
    public SQLiteOpenHelper sqLiteOpenHelper;

    public DBManager() {
    }

    public DBManager(SQLiteOpenHelper sqLiteOpenHelper) {
        this.sqLiteOpenHelper = sqLiteOpenHelper;
    }



    public boolean savePhineToDatabase(Phones phone){
        SQLiteDatabase db = this.sqLiteOpenHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("model", phone.getModel());
        cv.put("serial_number", phone.getSerialNumber());
        cv.put("price", phone.getPrice());
        long rowId = db.insert("TABLE_PHONES", null, cv);
        cv.clear();
        db.close();
        Log.i("simple_app_tag", "save phone to database");
        return rowId !=1;
    }

    public ArrayList<Phones> loadAllPhonesFromDatabase(){
        ArrayList<Phones> phones = new ArrayList<>();
        SQLiteDatabase db = this.sqLiteOpenHelper.getWritableDatabase();
        Cursor dbCursor = db.query("TABLE_PHONES", null, null, null, null, null, null);
        if(dbCursor.moveToFirst()){
            do{
                String model = dbCursor.getString(dbCursor.getColumnIndexOrThrow("model"));
                String sNumber = dbCursor.getString(dbCursor.getColumnIndexOrThrow("serial_number"));
                int price = dbCursor.getInt(dbCursor.getColumnIndexOrThrow("price"));
                phones.add(new Phones(model, sNumber, price));
            }while (dbCursor.moveToNext());


        }
        Log.i("simple_app_tag", "load phones from database");
        dbCursor.close();
        db.close();
        return phones;
    }

}
