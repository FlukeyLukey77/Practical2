package com.example.practical2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.nio.channels.SelectionKey;

public class ThirdActivity extends AppCompatActivity
{
    TextView unitFeedbackMessage;
    TextView massUnits;
    TextView heightUnits;
    SeekBar weightSlider;
    SeekBar heightSlider;
    EditText weightInputText;
    EditText heightInputText;
    Button ui3Next;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thirdui);

        unitFeedbackMessage = findViewById(R.id.unitFeedbackMessage);
        massUnits = findViewById(R.id.massUnits);
        heightUnits = findViewById(R.id.heightUnits);
        weightSlider = findViewById(R.id.weightSlider);
        heightSlider = findViewById(R.id.heightSlider);
        weightInputText = findViewById(R.id.weightInputText);
        heightInputText = findViewById(R.id.heightInputText);
        ui3Next = findViewById(R.id.ui1Yes);

        Intent intent = getIntent();

        int numberSystem = intent.getIntExtra("numberSystem", 0);
        weightSlider.setOnSeekBarChangeListener(weightSliderChangeListener);

        if (numberSystem == 0)
        {
            unitFeedbackMessage.setText("You have chosen the metric system");
            massUnits.setText("kg");
            heightUnits.setText("cm");

        } else if (numberSystem == 1)
        {
            unitFeedbackMessage.setText("You have chosen the imperial system");
            massUnits.setText("lb");
            heightUnits.setText("in");
        }

        int weightSlideInput;
        weightSlideInput = weightSlider.getProgress();
    }

    SeekBar.OnSeekBarChangeListener weightSliderChangeListener = new SeekBar.OnSeekBarChangeListener()
    {
        @Override
        public void onProgressChanged(SeekBar weightSlide, int weightSlideInput, boolean b)
        {
            //massUnits.setText(weightSlideInput);
        }

        @Override
        public void onStartTrackingTouch(SeekBar weightInput)
        {

        }

        @Override
        public void onStopTrackingTouch(SeekBar weightInput)
        {

        }
    };
}
