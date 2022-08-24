package com.example.practical2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FourthActivity extends AppCompatActivity
{
    TextView weightMessage;
    TextView heightMessage;
    TextView BMINumber;
    TextView classificationText;

    final String underweightCol = "#FDD835";
    final float healthy = 18.5F;
    final String healthyCol = "#43A047";
    final float overweightNotObese = 25.0F;
    final String overweightCol = "#FDD835";
    final float obese1 = 30.0F;
    final String o1Col = "#FFB300";
    final float obese2 = 35.0F;
    final String o2Col = "#FB8C00";
    final float obese3 = 40.0F;
    final String o3Col = "#F4511E";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fourthui);

        Intent intent = getIntent();

        int numberSystem = intent.getIntExtra("numberSystem", 0);
        int weight = intent.getIntExtra("Weight", 0);
        int height = intent.getIntExtra("Height", 0);

        float BMI = 0;

        weightMessage = findViewById(R.id.weightMessage);
        heightMessage = findViewById(R.id.heightMessage);
        BMINumber = findViewById(R.id.BMINumber);
        classificationText = findViewById(R.id.classificationText);

        if(numberSystem == 0)
        {
            weightMessage.setText("Your weight is " + weight + "kg");
            heightMessage.setText("Your height is " + height + "cm");

            BMI = (float)weight/(((float)height/100) * ((float)height/100));
        }
        else if(numberSystem == 1)
        {
            weightMessage.setText("Your weight is " + weight + "lb");
            heightMessage.setText("Your height is " + height + "in");

            BMI = ((float)weight/(((float)height) * ((float)height))) * 703;
        }
        else
        {
            weightMessage.setText("Your weight is " + weight + "UNIT ERROR");
            heightMessage.setText("Your height is " + height + "UNIT ERROR");
        }

        BMINumber.setText(String.format("%.2f", BMI));

        String message = "";
        String colour = "";

        if(BMI < healthy)
        {
            message = "Underweight";
            colour = underweightCol;
        }
        else if(healthy < BMI && BMI < overweightNotObese)
        {
            message = "Healthy";
            colour = healthyCol;
        }
        else if(overweightNotObese < BMI && BMI < obese1)
        {
            message = "Overweight but not obese";
            colour = overweightCol;
        }
        else if(obese1 < BMI && BMI < obese2)
        {
            message = "Obese class 1";
            colour = o1Col;
        }
        else if(obese2 < BMI && BMI < obese3)
        {
            message = "Obese class 2";
            colour = o2Col;
        }
        else if(obese3 < BMI)
        {
            message = "Obese class 4";
            colour = o3Col;
        }
        else
        {
            message = "ERROR";
        }

        classificationText.setText(message);
        classificationText.setBackgroundColor(Color.parseColor(colour));
    }
}
