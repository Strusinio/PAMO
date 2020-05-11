package com.example.bmicalculator

class QuizItem(val question: String, val answers: List<Pair<String, Boolean>>)


val quiz = listOf(
        QuizItem("Polska", listOf(
                Pair("Londyn", false),
                Pair("Berlin", false),
                Pair("Moskwa", false),
                Pair("Warszawa", true)
        )),
        QuizItem("UK", listOf(
                Pair("Londyn", true),
                Pair("Berlin", false),
                Pair("Moskwa", false),
                Pair("Warszawa", false)
        )),
        QuizItem("Niemcy", listOf(
                Pair("Londyn", false),
                Pair("Berlin", true),
                Pair("Moskwa", false),
                Pair("Warszawa", false)
        ))
)