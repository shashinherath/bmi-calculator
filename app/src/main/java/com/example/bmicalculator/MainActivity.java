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
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    android.widget.Button calculateBmi;

    TextView currentHeight;
    TextView currentAge, currentWeight;
    ImageView incrementAge, incrementWeight, decrementAge, decrementWeight;
    SeekBar seekBarForHeight;
    RelativeLayout male, female;

    int weight = 55;
    int age = 22;
    int currentProgress;
    String inProgress = "170";
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
        seekBarForHeight = findViewById(R.id.seekbarforheight);
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

        seekBarForHeight.setMax(300);
        seekBarForHeight.setProgress(170);
        seekBarForHeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                currentProgress = i;
                inProgress = String.valueOf(currentProgress);
                currentHeight.setText(inProgress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        incrementAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                age = age + 1;
                age2 = String.valueOf(age);
                currentAge.setText(age2);
            }
        });

        decrementAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                age = age - 1;
                age2 = String.valueOf(age);
                currentAge.setText(age2);
            }
        });

        incrementWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                weight = weight + 1;
                weight2 = String.valueOf(weight);
                currentWeight.setText(weight2);
            }
        });

        decrementWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                weight = weight - 1;
                weight2 = String.valueOf(weight);
                currentWeight.setText(weight2);
            }
        });

        calculateBmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (typeOfUser.equals("0")) {
                    Toast.makeText(getApplicationContext(), "Select Your Gender First", Toast.LENGTH_SHORT).show();
                }

                else if (inProgress.equals("0")) {
                    Toast.makeText(getApplicationContext(), "Select Your Height First", Toast.LENGTH_SHORT).show();
                }

                else if (age == 0 || age < 0) {
                    Toast.makeText(getApplicationContext(), "Age Is Incorrect", Toast.LENGTH_SHORT).show();
                }

                else if (weight == 0 || weight < 0) {
                    Toast.makeText(getApplicationContext(), "Weight Is Incorrect", Toast.LENGTH_SHORT).show();
                }

                else {
                    Intent intent = new Intent(MainActivity.this, bmi_activity.class);
                    intent.putExtra("gender", typeOfUser);
                    intent.putExtra("height", inProgress);
                    intent.putExtra("weight", weight2);
                    intent.putExtra("age", age2);

                    startActivity(intent);
                }
            }
        });
    }
}