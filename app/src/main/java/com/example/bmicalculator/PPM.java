package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Locale;

public class PPM extends AppCompatActivity {
    private Button backToMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ppm);

        findViewById(R.id.calculate).setOnClickListener(this::calculatePressed);

        // BTN initialize
        backToMain = findViewById(R.id.ppm_back);
        backToMain.setOnClickListener(v -> finish());

    }

    private void calculatePressed(View view) {
        Spinner spinner = findViewById(R.id.sex);
        int weight = getValueFromView(R.id.weight);
        int height = getValueFromView(R.id.height);
        int age = getValueFromView(R.id.age);
        int pos = spinner.getSelectedItemPosition();

        if (weight != 0 && height != 0 && age != 0) {
            double result = calculateMifflinFactor(weight, height, age, pos == 0);
            ((TextView) findViewById(R.id.result)).setText(String.format(Locale.ROOT, "Wynik: %.2f kcal", result));
        }
    }

    private int getValueFromView(int id) {
        EditText view = findViewById(id);
        if (view.getText().toString().isEmpty()) {
            view.setError("Brak wartości!!");
            return 0;
        }
        return Integer.parseInt(view.getText().toString());
    }

    private double calculateMifflinFactor(int weight, int height, int age, boolean isFamle) {
        int factor = isFamle ? 161 : 5;
        return 10 * weight + 6.25 * height - 5 * age - factor;
    }

    /*
    PPM (kobiety) = SWE (spoczynkowy wydatek energetyczny kcal) = (10 x masa ciała [kg])+(6,25 x wzrost [cm]) -(5 x [wiek]) – 161
PPM (mężczyźni) = SWE (spoczynkowy wydatek energetyczny kcal) = (10 x masa ciała [kg])+(6, 25 x wzrost [cm]) -(5 x [wiek]) + 5
     */


}
