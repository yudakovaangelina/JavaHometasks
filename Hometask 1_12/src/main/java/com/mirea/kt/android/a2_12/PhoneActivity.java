package com.mirea.kt.android.a2_12;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class PhoneActivity extends AppCompatActivity {
    private  DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);
        this.dbManager = new DBManager(new MyAppSQLiteHelper(this, "my_database.db", null, 1));

        RecyclerView rcView = findViewById(R.id.recyclerView);
        PhoneAdapter adapter = new PhoneAdapter(dbManager.loadAllPhonesFromDatabase());
        Log.i("simple_app_tag", "Получение записей из базы данных");
        rcView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false));
        rcView.setAdapter(adapter);
        Log.i("simple_app_tag", "Отображение в виде списка");


    }
}