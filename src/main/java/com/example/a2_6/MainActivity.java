package com.example.a2_6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText editTextMonths;
    private EditText editTextPercent;
    private EditText editTextStartSum;
    private Button btnCalc;
    private TextView textViewFinalIncome;
    private TextView textViewMonthlyIncome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextMonths = findViewById(R.id.etMonths);
        editTextPercent = findViewById(R.id.etPercent);
        editTextStartSum = findViewById(R.id.etStartSum);
        textViewFinalIncome = findViewById(R.id.tvFinalIncome);
        textViewMonthlyIncome = findViewById(R.id.tvMonthlyIncome);
        btnCalc = findViewById(R.id.btnCount);
        btnCalc.setOnClickListener(this);
            Log.i("simple_app_tag", "Click on count button");

            String monthsTermStr = editTextMonths.getText().toString();
            String percentTermStr = editTextPercent.getText().toString();
            String startSumTermStr = editTextStartSum.getText().toString();


    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnCount){

            String monthsTermStr = editTextMonths.getText().toString();
            String percentTermStr = editTextPercent.getText().toString();
            String startSumTermStr = editTextStartSum.getText().toString();


            if(!monthsTermStr.isEmpty() && !percentTermStr.isEmpty() && !startSumTermStr.isEmpty()){

                int months = Integer.parseInt(monthsTermStr);
                double percent = Double.parseDouble(percentTermStr);
                int startSum = Integer.parseInt(startSumTermStr);

                int days = months * 30;
                double finalIncome =0;
                for (int i=0; i<days; i++){
                    finalIncome += (startSum * percent) / (365 * 100);
                }
                double monthsIncome = 30 * (startSum * percent) / (365 * 100);

                Log.i("simple_app_tag", "Final income is " + finalIncome);
                Log.i("simple_app_tag", "Months income is " + monthsIncome);

                textViewFinalIncome.setText(String.valueOf(finalIncome));
                textViewMonthlyIncome.setText(String.valueOf(monthsIncome));

            }else{
                Log.w("simple_app_tag", "Empty term");
                Toast.makeText(getApplicationContext(), "Invalid terms", Toast.LENGTH_LONG).show();
            }


        }
    }
}