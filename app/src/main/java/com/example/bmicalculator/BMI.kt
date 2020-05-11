package com.example.bmicalculator

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.bmi.*

class BMI : AppCompatActivity() {
    private var BMIresult: String? = null
    private var error: Exception? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bmi)
        bmi_back.setOnClickListener { finish() }
        calculate_btn.setOnClickListener { calculateBmi() }
        showRecipes.visibility = View.GONE
    }

    private fun openRecipes(bmi: Double) {
        val intent = Intent(this, Recipe::class.java)
        intent.putExtra("arg_bmi", EBMIResult.calculateBMIResult(bmi))
        startActivity(intent)
    }

    private fun calculateBmi() {
        val inputWeightTxt = weight!!.text.toString()
        val inputHeightTxt = height!!.text.toString()
        val weight = inputWeightTxt.toDouble()
        val height = inputHeightTxt.toDouble()
        try {
            val bmi = weight / Math.pow(height / 100, 2.0)
            displayBmi(bmi)
            showRecipes.visibility = View.VISIBLE
            showRecipes.setOnClickListener { v: View? -> openRecipes(bmi) }
        } catch (ex: ArithmeticException) {
            error = ex
        }
    }

    private fun displayBmi(BMI: Double) {
        BMIresult = if (BMI < 16) "$BMI\n starvation" else if (BMI >= 16 && BMI < 17) "$BMI\n emaciation" else if (BMI >= 17 && BMI < 18.5) "$BMI\n underweight" else if (BMI >= 18.5 && BMI < 24.5) "$BMI\n normal weight" else if (BMI >= 24.5 && BMI < 30) "$BMI\n overweight" else if (BMI >= 30 && BMI < 35) "$BMI\n 1st degree of obesity" else if (BMI >= 35 && BMI < 40) "$BMI\n 2nd degree of obesity" else "$BMI\n extreme obesity"
        result!!.text = "BMI: \n$BMIresult"
    }
}