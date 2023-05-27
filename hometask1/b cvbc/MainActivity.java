package com.mirea.kt.android.kyrsovaya_yudakova;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private  DBManager dbManager;


    int result;
    JSONArray data;
    private JSONObject jsonObject;
    private JSONArray jSONObject;
    private SQLiteDatabase database;
    private MyAppSQLiteHelper sqLiteHelper;
    private SharedPreferences sharedPreferences;
    private static final String IS_FIRST_LAUNCH = "is_first_launch";
   /* private JSONArray getData() throws IOException, JSONException {

        Button btnStart = findViewById(R.id.btnEnter);
        EditText inpupLog = findViewById(R.id.etLogin);
        EditText inputPswd = findViewById(R.id.etPassword);

            String login = inpupLog.getText().toString();
            String pswd = inputPswd.getText().toString();
        String server = "https://android-for-students.ru";
        String serverPath = "/coursework/login.php";
        HashMap<String,String> map = new HashMap();
        map.put("lgn", login);
        map.put("pwd", pswd);
        map.put("g", "RIBO-02-21");
        HTTPRunnable hTTPRunnable = new HTTPRunnable(server + serverPath, map);
        Thread th = new Thread(hTTPRunnable);
        th.start();

        try{
            th.join();
        }catch(InterruptedException ex){
            Log.d("FalseMain","Ошибка при ожидании потока",ex);
        }
        finally {

            try {
                JSONObject jSONObject = new JSONObject(hTTPRunnable.getResponseBody());




            } catch (JSONException e) {
                Log.d("FalseMain","Ошибка при обработке JSON",e);
            }catch (NullPointerException e){
                Log.d("FalseMain","Ошибка нулевого значения",e);
            }
            finally {
                return jsonObject.getJSONArray("data");
            }


        }


    }
    private void loadTermsFromServer() {
        SQLiteDatabase database = sqLiteHelper.getWritableDatabase();

        try {
            JSONArray jsonArray = getData();

            for (int i = 0; i < data.length(); i++) {
                JSONObject jsonObject = data.getJSONObject(i);
                String term = jsonObject.getString("term");
                String definition = jsonObject.getString("definition");

                ContentValues contentValues = new ContentValues();
                contentValues.put("term", term);
                contentValues.put("definition", definition);
                database.insertOrThrow("terms", null, contentValues);
            }
        } catch ( JSONException | SQLiteException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            database.close();
        }
    }
*\

    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sqLiteHelper = new MyAppSQLiteHelper(this, "my_database.db", null, 1);
        database = sqLiteHelper.getWritableDatabase();
        Log.i("NotesProduct","Erros :(");
        Button btnStart = findViewById(R.id.btnEnter);
        EditText inpupLog = findViewById(R.id.etLogin);
        EditText inputPswd = findViewById(R.id.etPassword);

      /*  sharedPreferences = getSharedPreferences("my_preferences", MODE_PRIVATE);
        boolean isFirstLaunch = sharedPreferences.getBoolean(IS_FIRST_LAUNCH, true);
        if (isFirstLaunch) {
            loadTermsFromServer();
            sharedPreferences.edit().putBoolean(IS_FIRST_LAUNCH, false).apply();
        }
*\

       */
        btnStart.setOnClickListener(v ->{
            String login = inpupLog.getText().toString();
            String pswd = inputPswd.getText().toString();

            if(!login.isEmpty() && !pswd.isEmpty()){
                String server = "https://android-for-students.ru";
                String serverPath = "/coursework/login.php";
                HashMap<String,String> map = new HashMap();
                map.put("lgn", login);
                map.put("pwd", pswd);
                map.put("g", "RIBO-02-21");
                HTTPRunnable hTTPRunnable = new HTTPRunnable(server + serverPath, map);
                Thread th = new Thread(hTTPRunnable);
                th.start();

                try{
                    th.join();
                }catch(InterruptedException ex){
                    Log.d("FalseMain","Ошибка при ожидании потока",ex);
                }
                finally {

                    try {
                        JSONObject jSONObject = new JSONObject(hTTPRunnable.getResponseBody());
                        result = jSONObject.getInt("result_code");
                        data = jSONObject.getJSONArray("data");





                    } catch (JSONException e) {
                        Log.d("FalseMain","Ошибка при обработке JSON",e);
                    }catch (NullPointerException e){
                        Log.d("FalseMain","Ошибка нулевого значения",e);
                    }
                    finally {
                        if(result == 1){
                            Intent actIntent = new Intent(getApplicationContext(),HomeActivity.class);
                            startActivity(actIntent);
                        }else {
                            Toast.makeText(getApplicationContext(),"Неверный пароль или логин",Toast.LENGTH_LONG).show();
                        }
                    }

                }
            }else {
                Toast.makeText(getApplicationContext(),"Необходимо заполнить оба поля",Toast.LENGTH_LONG).show();
            }


        });

    }

}
