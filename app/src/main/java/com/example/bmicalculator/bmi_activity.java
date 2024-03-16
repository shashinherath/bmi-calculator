package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class bmi_activity extends AppCompatActivity {

    android.widget.Button recalculateBmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        getSupportActionBar().hide();
        recalculateBmi =  findViewById(R.id.recalculatebmi);

        recalculateBmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(bmi_activity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}