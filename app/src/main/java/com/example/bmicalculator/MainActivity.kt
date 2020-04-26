package com.example.bmicalculator

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var bmiButton: Button? = null
    private var ppmButton: Button? = null
    private var recipeButton: Button? = null
    private var quizButton: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bmiButton = findViewById(R.id.button_bmi)
        ppmButton = findViewById(R.id.button_ppm)
        recipeButton = findViewById(R.id.button_recipe)
        quizButton = findViewById(R.id.button_quiz)
        bmiButton.setOnClickListener(View.OnClickListener { openActivityBMI() })
        ppmButton.setOnClickListener(View.OnClickListener { openActivityPPM() })
        recipeButton.setOnClickListener(View.OnClickListener { openActivityRecipes() })
        quizButton.setOnClickListener(View.OnClickListener { v: View? -> openActivityQuiz() })
    }

    fun openActivityBMI() {
        val intent = Intent(this, BMI::class.java)
        startActivity(intent)
    }

    fun openActivityPPM() {
        val intent = Intent(this, PPM::class.java)
        startActivity(intent)
    }

    fun openActivityRecipes() {
        val intent = Intent(this, Recipe::class.java)
        startActivity(intent)
    }

    fun openActivityQuiz() {
        val intent = Intent(this, Quiz::class.java)
        startActivity(intent)
    }
}