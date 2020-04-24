package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button bmiButton;
    private Button ppmButton;
    private Button recipeButton;
    private  Button quizButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bmiButton = findViewById(R.id.button_bmi);
        ppmButton = findViewById(R.id.button_ppm);
        recipeButton = findViewById(R.id.button_recipe);
        quizButton =findViewById(R.id.button_quiz);

        bmiButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openActivityBMI();
            }
        });
        ppmButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openActivityPPM();
            }
        });
        recipeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openActivityRecipes();
            }
        });
        quizButton.setOnClickListener(v -> openActivityQuiz());


    }

    public void openActivityBMI(){
        Intent intent = new Intent(this, BMI.class);
        startActivity(intent);
    }

    public void openActivityPPM(){
        Intent intent = new Intent(this, PPM.class);
        startActivity(intent);
    }

    public void openActivityRecipes(){
        Intent intent = new Intent(this, Recipe.class);
        startActivity(intent);
    }
    public void openActivityQuiz(){
        Intent intent = new Intent(this, Quiz.class);
        startActivity(intent);
    }

}
