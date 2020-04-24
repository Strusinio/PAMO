package com.example.bmicalculator;

public enum EBMIResult {

    STARVATION,
    EMACIATION,
    UNDERWEIGHT,
    NORMAL_WEIGHT,
    OVERWEIGHT,
    DEGREE_OF_OBESIT_1ST,
    DEGREE_OF_OBESITY_2ND,
    EXTREME_OBESITY;


    static EBMIResult calculateBMIResult(double BMI) {
        if (BMI < 16)
            return STARVATION;
        else if (BMI >= 16 && BMI < 17)
            return EMACIATION;
        else if (BMI >= 17 && BMI < 18.5)
            return UNDERWEIGHT;
        else if (BMI >= 18.5 && BMI < 24.5)
            return NORMAL_WEIGHT;
        else if (BMI >= 24.5 && BMI < 30)
            return OVERWEIGHT;
        else if (BMI >= 30 && BMI < 35)
            return DEGREE_OF_OBESIT_1ST;
        else if (BMI >= 35 && BMI < 40)
            return DEGREE_OF_OBESITY_2ND;
        else
            return EXTREME_OBESITY;
    }

}
