package com.example.practical2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
        ui3Next = findViewById(R.id.ui3Next);

        Intent intent = getIntent();

        int numberSystem = intent.getIntExtra("numberSystem", 0);
        weightSlider.setOnSeekBarChangeListener(weightSliderChangeListener);
        heightSlider.setOnSeekBarChangeListener(heightSliderChangeListener);

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

        ui3Next.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                int finalWeight = 1;
                int finalHeight = 1;
                try
                {
                    finalWeight = Integer.parseInt(weightInputText.getText().toString());
                    finalHeight = Integer.parseInt(heightInputText.getText().toString());

                    Intent activity4Intent = new Intent(ThirdActivity.this, FourthActivity.class);
                    activity4Intent.putExtra("Weight", finalWeight);
                    activity4Intent.putExtra("Height", finalHeight);
                    activity4Intent.putExtra("numberSystem", numberSystem);
                    ThirdActivity.this.startActivity(activity4Intent);
                }
                catch(Exception e)
                {
                    weightInputText.setText("Error");
                    heightInputText.setText("Error");
                }
            }
        });

    }

    SeekBar.OnSeekBarChangeListener weightSliderChangeListener = new SeekBar.OnSeekBarChangeListener()
    {
        @Override
        public void onProgressChanged(SeekBar weightSlide, int weightSlideInput, boolean b)
        {
            weightInputText.setText(Integer.toString(weightSlideInput));
        }
        @Override
        public void onStartTrackingTouch(SeekBar seekBar)
        {

        }
        @Override
        public void onStopTrackingTouch(SeekBar seekBar)
        {

        }
    };

    SeekBar.OnSeekBarChangeListener heightSliderChangeListener = new SeekBar.OnSeekBarChangeListener()
    {
        @Override
        public void onProgressChanged(SeekBar heightSlide, int heightSlideInput, boolean b)
        {
            heightInputText.setText(Integer.toString(heightSlideInput));
        }
        @Override
        public void onStartTrackingTouch(SeekBar seekBar)
        {

        }
        @Override
        public void onStopTrackingTouch(SeekBar seekBar)
        {

        }
    };
}
