package com.example.bmicalculator

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.*

class Quiz : Activity() {
    private var countLabel: TextView? = null
    private var questionLabel: TextView? = null
    //private int rightAnswerCount = 0;
    private var quizCount = 0
    private var rightAnswer: String? = null
    private val wrongAnswer: String? = null
    var quizArray = ArrayList<ArrayList<String>>()
    var questions = ArrayList<QuizItem?>()
    private val buttons: MutableList<Button> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quiz)
        initQuestions()
        countLabel = findViewById<View>(R.id.countLabel) as TextView
        questionLabel = findViewById<View>(R.id.questionLabel) as TextView
        val answerBtn1 = findViewById<View>(R.id.answerBtn1) as Button
        val answerBtn2 = findViewById<View>(R.id.answerBtn2) as Button
        val answerBtn3 = findViewById<View>(R.id.answerBtn3) as Button
        val answerBtn4 = findViewById<View>(R.id.answerBtn4) as Button
        buttons.add(answerBtn1)
        buttons.add(answerBtn2)
        buttons.add(answerBtn3)
        buttons.add(answerBtn4)
        for (b in buttons) {
            b.setOnClickListener { v: View -> pressAnswer((v as Button).text) }
        }
        showNextQuiz()
    }

    private fun pressAnswer(text: CharSequence) {
        if (text == rightAnswer) {
            Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show()
            showNextQuiz()
        }
        if (text == wrongAnswer) {
            run { Toast.makeText(this, "BAD", Toast.LENGTH_SHORT).show() }
        }
    }

    private fun initQuestions() {
        questions.clear()
        questions.add(QuizItem("Co trzeba myć by zachować bezpieczeństwo", "Ręce", "stopy"))
        questions.add(QuizItem("Jaka jest naukowa nazwa obecnego wirusa", "Koronawirus", "ptasia grypa"))
        questions.add(QuizItem("Gdzie rozpoczeła się epidemia ", "Chiny", "Polska"))
        questions.add(QuizItem("Najwiecej potwierdzonych przypadków występuje w ", "USA", "Kosmosie"))
        Collections.shuffle(questions)
    }

    fun showNextQuiz() {
        if (quizCount >= questions.size) {
            Collections.shuffle(questions)
            quizCount = 0
        }
        countLabel!!.text = "Q" + (quizCount + 1)
        val item = questions[quizCount]
        questionLabel.setText(item.getQuestion())
        rightAnswer = item.getRightAnswer()
        val tmp: MutableList<QuizItem?> = ArrayList()
        for (i in questions) {
            if (i !== item) {
                tmp.add(i)
            }
        }
        val rightAnswerIdx = Random().nextInt(4)
        buttons[rightAnswerIdx].text = rightAnswer
        val tmpButtons: MutableList<Button?> = ArrayList<Any?>()
        for (button in buttons) {
            if (button !== buttons[rightAnswerIdx]) {
                tmpButtons.add(button)
            }
        }
        for (b in tmpButtons) {
            val idx = tmpButtons.indexOf(b)
            if (idx != rightAnswerIdx) {
                tmpButtons[idx].setText(tmp[idx].getRightAnswer())
            }
        }
        quizCount++
    }
}