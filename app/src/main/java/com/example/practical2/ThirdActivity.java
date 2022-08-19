package com.example.practical2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity
{
    TextView unitFeedbackMessage;
    Button ui3Next;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thirdui);

        unitFeedbackMessage = findViewById(R.id.unitFeedbackMessage);
        ui3Next = findViewById(R.id.ui1Yes);

        Intent intent = getIntent();

        int numberSystem = 0;//intent.getIntExtra("numberSystem");

        if (numberSystem == 0)
        {
            unitFeedbackMessage.setText("You have chosen the metric system");
        }
        else if (numberSystem == 1)
        {
            unitFeedbackMessage.setText("You have chosen the imperial system");
        }
    }
}
