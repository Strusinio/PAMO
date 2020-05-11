package com.example.bmicalculator

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button_bmi.setOnClickListener { openActivityBMI() }
        button_ppm.setOnClickListener { openActivityPPM() }
        button_recipe.setOnClickListener { openActivityRecipes() }
        button_quiz.setOnClickListener { openActivityQuiz() }
    }

    private fun openActivityBMI() {
        val intent = Intent(this, BMI::class.java)
        startActivity(intent)
    }

    private fun openActivityPPM() {
        val intent = Intent(this, PPM::class.java)
        startActivity(intent)
    }

    private fun openActivityRecipes() {
        val intent = Intent(this, Recipe::class.java)
        startActivity(intent)
    }

    private fun openActivityQuiz() {
        val intent = Intent(this, Quiz::class.java)
        startActivity(intent)
    }
}