package com.example.bmicalculator

enum class EBMIResult {
    STARVATION, EMACIATION, UNDERWEIGHT, NORMAL_WEIGHT, OVERWEIGHT, DEGREE_OF_OBESIT_1ST, DEGREE_OF_OBESITY_2ND, EXTREME_OBESITY;

    companion object {
        fun calculateBMIResult(BMI: Double): EBMIResult {
            return if (BMI < 16) STARVATION else if (BMI >= 16 && BMI < 17) EMACIATION else if (BMI >= 17 && BMI < 18.5) UNDERWEIGHT else if (BMI >= 18.5 && BMI < 24.5) NORMAL_WEIGHT else if (BMI >= 24.5 && BMI < 30) OVERWEIGHT else if (BMI >= 30 && BMI < 35) DEGREE_OF_OBESIT_1ST else if (BMI >= 35 && BMI < 40) DEGREE_OF_OBESITY_2ND else EXTREME_OBESITY
        }
    }
}