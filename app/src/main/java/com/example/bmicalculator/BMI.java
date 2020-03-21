package com.example.bmicalculator;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BMI extends AppCompatActivity {

    private EditText weight;
    private EditText height;
    private TextView result;
    private Button calculation;
    private double BMI;
    private String BMIresult;
    private Exception error;
    private Button backToMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi);

        // BTN initialize
        backToMain = findViewById(R.id.bmi_back);
        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);
        result = findViewById(R.id.result);
        calculation = findViewById(R.id.calculate_btn);

        backToMain.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
            }
        });
        calculation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateBmi();
            }
        });
    }

    public void calculateBmi(){
        String inputWeightTxt = weight.getText().toString();
        String inputHeightTxt = height.getText().toString();

        double weight = Double.parseDouble(inputWeightTxt);
        double height = Double.parseDouble(inputHeightTxt);

        try{
            BMI = weight / Math.pow(height/100, 2);
            displayBmi();
        }
        catch (ArithmeticException ex){
            error = ex;
        }
    }

    private void displayBmi(){
        if ( BMI < 16 )
            BMIresult = BMI +"\n starvation";
        else if(BMI >=16 && BMI <17)
            BMIresult = BMI +"\n emaciation";
        else if(BMI >=17 && BMI <18.5)
            BMIresult = BMI +"\n underweight";
        else if(BMI >=18.5 && BMI <24.5)
            BMIresult = BMI +"\n normal weight";
        else if(BMI >=24.5 && BMI <30)
            BMIresult = BMI +"\n overweight";
        else if(BMI >=30 && BMI <35)
            BMIresult = BMI +"\n 1st degree of obesity";
        else if(BMI >=35 && BMI <40)
            BMIresult = BMI +"\n 2nd degree of obesity";
        else
            BMIresult = BMI +"\n extreme obesity";

        result.setText("BMI: \n"+ BMIresult);
    }
}


