package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    android.widget.Button calculateBmi;

    TextView currentHeight;
    TextView currentAge, currentWeight;
    ImageView incrementAge, incrementWeight, decrementAge, decrementWeight;
    SeekBar seekBarForHeight;
    RelativeLayout male, female;

    int weight;
    int age = 22;
    int currentProgress;
    String minProgress = "170";
    String typeOfUser = "0";
    String weight2 = "55";
    String age2 = "22";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        calculateBmi = findViewById(R.id.calculatebmi);
        currentAge = findViewById(R.id.currentage);
        currentWeight = findViewById(R.id.currentweight);
        currentHeight = findViewById(R.id.currentheight);
        incrementAge = findViewById(R.id.incrementage);
        decrementAge = findViewById(R.id.decrementage);
        incrementWeight = findViewById(R.id.incrementweight);
        decrementWeight = findViewById(R.id.decrementweight);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);

        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                male.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.male_female_focus));
                female.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.male_female_not_focus));
                typeOfUser = "Male";
            }
        });

        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                female.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.male_female_focus));
                male.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.male_female_not_focus));
                typeOfUser = "Female";
            }
        });

        

        calculateBmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, bmi_activity.class);
                startActivity(intent);
            }
        });
    }
}