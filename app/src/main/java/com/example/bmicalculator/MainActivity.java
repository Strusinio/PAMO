package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText weight, height;
    TextView resulttext;
    String calculation, BMIresult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weight = findViewById(R.id.Weight);
        height = findViewById(R.id.Height);
        resulttext = findViewById(R.id.result);
    }

    public void calculateBMI(View view) {
        String W = weight.getText().toString();
        String H = height.getText().toString();

        float weightValue = Float.parseFloat(W);
        float heightValue = Float.parseFloat(H)/100;

        float BMI = weightValue / (heightValue * heightValue);

        if(BMI < 16){
            BMIresult = "Starvation";
        }else if(BMI >= 16 && BMI <= 16.99){
            BMIresult = "emaciation";
        }else if(BMI >= 17 && BMI <= 18.49) {
            BMIresult = "underweight";
        }else if(BMI >= 18.5 && BMI <= 24.99) {
            BMIresult = "normal weight";
        }else if(BMI >= 25 && BMI <= 29.99) {
            BMIresult = "overweight";
        }else if(BMI >= 30 && BMI <= 34.99) {
            BMIresult = "1st degree of obesity";
        }else if(BMI >= 35 && BMI <= 39.99) {
            BMIresult = "2nd degree of obesity";
        }else{
            BMIresult = "extreme obesity.";
        }

        calculation = "Result:\n\n" + BMI + "\n" + BMIresult;

        resulttext.setText(calculation);
    }
}
