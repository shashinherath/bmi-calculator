package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class bmi_activity extends AppCompatActivity {

    android.widget.Button recalculateBmi;

    TextView bmiDisplay, bmiCategory, gender;
    Intent intent;
    ImageView imageView;
    String bmi;
    float intBmi;

    String height;
    String weight;
    float intHeight, intWeight;
    RelativeLayout background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle(Html.fromHtml("<font color\"white\"></font>"));
        getSupportActionBar().setTitle("Result");
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#1E1D1D"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);

        intent = getIntent();

        bmiDisplay = findViewById(R.id.bmidisplay);
        bmiCategory = findViewById(R.id.bmicategory);
        gender = findViewById(R.id.genderdisplay);
        background = findViewById(R.id.contentlayout);

        intHeight = Float.parseFloat(height);
        intWeight = Float.parseFloat(weight);

        intHeight = intHeight / 100;

        intBmi = intWeight / (intHeight*intHeight);

        bmi = Float.toString(intBmi);
        

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