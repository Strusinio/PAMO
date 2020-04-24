package com.example.bmicalculator;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.bmicalculator.EBMIResult.calculateBMIResult;

public class BMI extends AppCompatActivity {

    private EditText weight;
    private EditText height;
    private TextView result;
    private Button calculation;
    private String BMIresult;
    private Exception error;
    private Button backToMain;
    private Button showRecipesBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi);

        // BTN
        backToMain = findViewById(R.id.bmi_back);
        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);
        result = findViewById(R.id.result);
        calculation = findViewById(R.id.calculate_btn);

        backToMain.setOnClickListener(v -> finish());
        calculation.setOnClickListener(view -> calculateBmi());
        showRecipesBtn = findViewById(R.id.showRecipes);
        showRecipesBtn.setVisibility(View.GONE);
    }

    private void openRecipes(double bmi) {
        Intent intent = new Intent(this, Recipe.class);
        intent.putExtra("arg_bmi", calculateBMIResult(bmi));
        startActivity(intent);
    }

    public void calculateBmi() {
        String inputWeightTxt = weight.getText().toString();
        String inputHeightTxt = height.getText().toString();

        double weight = Double.parseDouble(inputWeightTxt);
        double height = Double.parseDouble(inputHeightTxt);

        try {
            double bmi = weight / Math.pow(height / 100, 2);
            displayBmi(bmi);
            showRecipesBtn.setVisibility(View.VISIBLE);
            showRecipesBtn.setOnClickListener((v) -> openRecipes(bmi));
        } catch (ArithmeticException ex) {
            error = ex;
        }
    }

    private void displayBmi(double BMI) {
        if (BMI < 16)
            BMIresult = BMI + "\n starvation";
        else if (BMI >= 16 && BMI < 17)
            BMIresult = BMI + "\n emaciation";
        else if (BMI >= 17 && BMI < 18.5)
            BMIresult = BMI + "\n underweight";
        else if (BMI >= 18.5 && BMI < 24.5)
            BMIresult = BMI + "\n normal weight";
        else if (BMI >= 24.5 && BMI < 30)
            BMIresult = BMI + "\n overweight";
        else if (BMI >= 30 && BMI < 35)
            BMIresult = BMI + "\n 1st degree of obesity";
        else if (BMI >= 35 && BMI < 40)
            BMIresult = BMI + "\n 2nd degree of obesity";
        else
            BMIresult = BMI + "\n extreme obesity";

        result.setText("BMI: \n" + BMIresult);
    }
}


