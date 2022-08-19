package com.example.practical2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    Button ui1Yes;
    Button ui1No;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstui);

        ui1Yes = findViewById(R.id.ui1Yes);
        ui1No = findViewById(R.id.ui1No);

        ui1Yes.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent activity2Intent = new Intent(MainActivity.this, SecondActivity.class);
                MainActivity.this.startActivity(activity2Intent);
            }
        });

        ui1No.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                setContentView(R.layout.thirdui);
            }
        });

    }


}