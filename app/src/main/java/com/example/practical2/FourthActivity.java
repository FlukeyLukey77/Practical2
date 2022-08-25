package com.example.practical2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FourthActivity extends AppCompatActivity
{
    TextView weightMessage;
    TextView heightMessage;
    TextView BMINumber;
    TextView classificationText;
    TextView BMIMessage;
    Button zoomOut;
    Button zoomIn;

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
        BMIMessage = findViewById(R.id.BMIMessage);
        zoomIn = findViewById(R.id.zoomIn);
        zoomOut = findViewById(R.id.zoomOut);

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
        String colour = o3Col;

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
            colour = o3Col;
        }

        classificationText.setText(message);
        classificationText.setBackgroundColor(Color.parseColor(colour));

        try
        {
            zoomIn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    increaseText();
                }
            });
            zoomOut.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view) {
                    decreaseText();
                }
            });
        }
        catch(Exception e)
        {
        }
    }

    private void increaseText(){
        float size1 = weightMessage.getTextSize();
        float size2 = heightMessage.getTextSize();
        float size3 = BMINumber.getTextSize();
        float size4 = classificationText.getTextSize();
        float size5 = BMIMessage.getTextSize();
        Log.d("size", "increaseText: "+size1);
        Log.d("size", "increaseText: "+size2);
        Log.d("size", "increaseText: "+size3);
        Log.d("size", "increaseText: "+size4);
        Log.d("size", "increaseText: "+size5);
        weightMessage.setTextSize(TypedValue.COMPLEX_UNIT_PX, size1*1.1F);
        heightMessage.setTextSize(TypedValue.COMPLEX_UNIT_PX, size2*1.1F);
        BMINumber.setTextSize(TypedValue.COMPLEX_UNIT_PX, size3*1.1F);
        classificationText.setTextSize(TypedValue.COMPLEX_UNIT_PX, size4*1.1F);
        BMIMessage.setTextSize(TypedValue.COMPLEX_UNIT_PX, size5*1.1F);
    }

    private void decreaseText(){
        float size1 = weightMessage.getTextSize();
        float size2 = heightMessage.getTextSize();
        float size3 = BMINumber.getTextSize();
        float size4 = classificationText.getTextSize();
        float size5 = BMIMessage.getTextSize();
        Log.d("size", "increaseText: "+size1);
        Log.d("size", "increaseText: "+size2);
        Log.d("size", "increaseText: "+size3);
        Log.d("size", "increaseText: "+size4);
        Log.d("size", "increaseText: "+size5);
        weightMessage.setTextSize(TypedValue.COMPLEX_UNIT_PX, size1*0.9F);
        heightMessage.setTextSize(TypedValue.COMPLEX_UNIT_PX, size2*0.9F);
        BMINumber.setTextSize(TypedValue.COMPLEX_UNIT_PX, size3*0.9F);
        classificationText.setTextSize(TypedValue.COMPLEX_UNIT_PX, size4*0.9F);
        BMIMessage.setTextSize(TypedValue.COMPLEX_UNIT_PX, size5*0.9F);
    }
}
