package com.example.bmicalculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.ppm.*
import java.util.*

class PPM : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ppm)
        calculate.setOnClickListener { view: View -> calculatePressed(view) }
        ppm_back.setOnClickListener { finish() }
    }

    private fun calculatePressed(view: View) {
        val weight = getValueFromView(R.id.weight)
        val height = getValueFromView(R.id.height)
        val age = getValueFromView(R.id.age)
        val pos = sex.selectedItemPosition
        if (weight != 0 && height != 0 && age != 0) {
            val result = calculateMifflinFactor(weight, height, age, pos == 0)
            (findViewById<View>(R.id.result) as TextView).text = String.format(Locale.ROOT, "Wynik: %.2f kcal", result)
        }
    }

    private fun getValueFromView(id: Int): Int {
        val view = findViewById<EditText>(id)
        if (view.text.toString().isEmpty()) {
            view.error = "Brak wartości!!"
            return 0
        }
        return view.text.toString().toInt()
    }

    private fun calculateMifflinFactor(weight: Int, height: Int, age: Int, isFamle: Boolean): Double {
        val factor = if (isFamle) 161 else 5
        return 10 * weight + 6.25 * height - 5 * age - factor
    } /*
    PPM (kobiety) = SWE (spoczynkowy wydatek energetyczny kcal) = (10 x masa ciała [kg])+(6,25 x wzrost [cm]) -(5 x [wiek]) – 161
PPM (mężczyźni) = SWE (spoczynkowy wydatek energetyczny kcal) = (10 x masa ciała [kg])+(6, 25 x wzrost [cm]) -(5 x [wiek]) + 5
     */
}