package com.mirea.kt.android.a2_12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener{
    private EditText editTextModel, editTextSerialNumber, editTextPrice;
    private  DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        this.dbManager = new DBManager(new MyAppSQLiteHelper(this, "my_database.db", null, 1));
        editTextModel = findViewById(R.id.etModel);
        Log.i("simple_app_tag", "editTextMode " + String.valueOf(editTextModel));
        editTextSerialNumber = findViewById(R.id.etSerialNumber);
        Log.i("simple_app_tag", "editTextSerialNumber " + String.valueOf(editTextSerialNumber));
        editTextPrice = findViewById(R.id.etPrice);
        Log.i("simple_app_tag", "editTextPrice " + String.valueOf(editTextPrice));
        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnContinue = findViewById(R.id.btnСontinue);
        btnAdd.setOnClickListener(this);
        btnContinue.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Log.i("simple_app_tag", "Нажатие на кнопку");
        if(v.getId() == R.id.btnAdd){
            if(this.dbManager != null){
                String model = editTextModel.getText().toString();
                String sNumber = editTextSerialNumber.getText().toString();
                String price = editTextPrice.getText().toString();
                if(!model.isEmpty() && !sNumber.isEmpty() && !price.isEmpty()){
                    boolean result = dbManager.savePhineToDatabase(new Phones(model, sNumber, Integer.parseInt(price)));
                    if(result){
                        Toast.makeText(this, "Запись успешно добавлена", Toast.LENGTH_LONG).show();
                        Log.i("simple_app_tag", "Запись успешно добавлена");
                    }else {
                        Toast.makeText(this, "При добавлении произошла ошибка", Toast.LENGTH_LONG).show();
                        Log.i("simple_app_tag", "При добавлении произошла ошибка");
                    }
                }else {
                    Toast.makeText(this, "Вы ввели некорректное значение", Toast.LENGTH_LONG).show();
                    Log.i("simple_app_tag", "Вы ввели некорректное значение");
                }
            }
        }else if(v.getId() == R.id.btnСontinue){
            startActivity(new Intent(this, PhoneActivity.class));
            Log.i("simple_app_tag", "Открытие activity с элементами");
        }
    }
}