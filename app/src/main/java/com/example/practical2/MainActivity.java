package com.example.practical2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity
{
    Button ui1Yes;
    Button ui1No;
    TextView ageQuestion;
    ConstraintLayout mainView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstui);

        ui1Yes = findViewById(R.id.ui1Yes);
        ui1No = findViewById(R.id.ui1No);
        ageQuestion = findViewById(R.id.ageQuestion);
        mainView = findViewById(R.id.Main);


        Snackbar ageMessage = Snackbar.make(mainView, "Age too low! Results will not be valid.", BaseTransientBottomBar.LENGTH_SHORT);

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
                ageMessage.show();
            }
        });

    }


}