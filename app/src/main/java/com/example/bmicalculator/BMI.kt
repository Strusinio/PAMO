package com.example.bmicalculator

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BMI : AppCompatActivity() {
    private var weight: EditText? = null
    private var height: EditText? = null
    private var result: TextView? = null
    private var calculation: Button? = null
    private var BMIresult: String? = null
    private var error: Exception? = null
    private var backToMain: Button? = null
    private var showRecipesBtn: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bmi)
        // BTN
        backToMain = findViewById(R.id.bmi_back)
        weight = findViewById(R.id.weight)
        height = findViewById(R.id.height)
        result = findViewById(R.id.result)
        calculation = findViewById(R.id.calculate_btn)
        backToMain.setOnClickListener(View.OnClickListener { v: View? -> finish() })
        calculation.setOnClickListener(View.OnClickListener { view: View? -> calculateBmi() })
        showRecipesBtn = findViewById(R.id.showRecipes)
        showRecipesBtn.setVisibility(View.GONE)
    }

    private fun openRecipes(bmi: Double) {
        val intent = Intent(this, Recipe::class.java)
        intent.putExtra("arg_bmi", EBMIResult.calculateBMIResult(bmi))
        startActivity(intent)
    }

    fun calculateBmi() {
        val inputWeightTxt = weight!!.text.toString()
        val inputHeightTxt = height!!.text.toString()
        val weight = inputWeightTxt.toDouble()
        val height = inputHeightTxt.toDouble()
        try {
            val bmi = weight / Math.pow(height / 100, 2.0)
            displayBmi(bmi)
            showRecipesBtn!!.visibility = View.VISIBLE
            showRecipesBtn!!.setOnClickListener { v: View? -> openRecipes(bmi) }
        } catch (ex: ArithmeticException) {
            error = ex
        }
    }

    private fun displayBmi(BMI: Double) {
        BMIresult = if (BMI < 16) "$BMI\n starvation" else if (BMI >= 16 && BMI < 17) "$BMI\n emaciation" else if (BMI >= 17 && BMI < 18.5) "$BMI\n underweight" else if (BMI >= 18.5 && BMI < 24.5) "$BMI\n normal weight" else if (BMI >= 24.5 && BMI < 30) "$BMI\n overweight" else if (BMI >= 30 && BMI < 35) "$BMI\n 1st degree of obesity" else if (BMI >= 35 && BMI < 40) "$BMI\n 2nd degree of obesity" else "$BMI\n extreme obesity"
        result!!.text = "BMI: \n$BMIresult"
    }
}