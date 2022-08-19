package com.example.practical2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity
{
    Button ui2Metric;
    Button ui2Imperial;

    int systemChoice = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondui);

        ui2Metric = findViewById(R.id.ui1Yes);
        ui2Imperial = findViewById(R.id.ui1No);

        Intent intent1 = getIntent();

        ui2Metric.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
               systemChoice = 0;
               startThirdActivity(systemChoice);
            }
        });

        ui2Imperial.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                systemChoice = 1;
                startThirdActivity(systemChoice);
            }
        });

    }
    void startThirdActivity(int systemChoice)
    {
        Intent activity3Intent = new Intent(SecondActivity.this, ThirdActivity.class);
        activity3Intent.putExtra("numberSystem", systemChoice);
        SecondActivity.this.startActivity(activity3Intent);
    }
}
