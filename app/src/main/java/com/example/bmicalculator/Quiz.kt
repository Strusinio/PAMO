package com.example.bmicalculator

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.quiz.*
import java.util.*

class Quiz : Activity() {
    //private int rightAnswerCount = 0;
    private var quizCount = 0
    private var rightAnswer: String? = null
    var questions = quiz
    private val buttons: MutableList<Button> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quiz)
        buttons.add(answerBtn1)
        buttons.add(answerBtn2)
        buttons.add(answerBtn3)
        buttons.add(answerBtn4)
        buttons.forEach { it.setOnClickListener { v: View -> pressAnswer((v as Button).text) } }
        showNextQuiz()
    }

    private fun pressAnswer(text: CharSequence) {
        if (text == rightAnswer) {
            Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show()
            showNextQuiz()
        } else {
            Toast.makeText(this, "BAD", Toast.LENGTH_SHORT).show()
        }
    }


    private fun showNextQuiz() {
        if (quizCount >= questions.size) {
            quizCount = 0
        }
        countLabel.text = "Q${quizCount + 1}"
        val item = questions[quizCount]
        questionLabel.text = item.question
        item.answers.forEachIndexed { index, answer -> buttons[index].text = answer.first }

        rightAnswer = item.answers.find { it.second }!!.first
        quizCount++
    }
}