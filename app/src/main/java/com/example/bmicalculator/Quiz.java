package com.example.bmicalculator;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Quiz extends Activity {

    private TextView countLabel;
    private TextView questionLabel;

    private int rightAnswerCount = 0;
    private int quizCount = 0;

    private String rightAnswer;

    ArrayList<ArrayList<String>> quizArray = new ArrayList<>();

    ArrayList<QuizItem> questions = new ArrayList<>();
    private List<Button> buttons = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz);
        initQuestions();

        countLabel = (TextView) findViewById(R.id.countLabel);
        questionLabel = (TextView) findViewById(R.id.questionLabel);
        Button answerBtn1 = (Button) findViewById(R.id.answerBtn1);
        Button answerBtn2 = (Button) findViewById(R.id.answerBtn2);
        Button answerBtn3 = (Button) findViewById(R.id.answerBtn3);
        Button answerBtn4 = (Button) findViewById(R.id.answerBtn4);
        buttons.add(answerBtn1);
        buttons.add(answerBtn2);
        buttons.add(answerBtn3);
        buttons.add(answerBtn4);
        for (Button b : buttons) {
            b.setOnClickListener((v) -> pressAnswer(((Button) v).getText()));
        }

        showNextQuiz();
    }

    private void pressAnswer(CharSequence text) {
        if (text.equals(rightAnswer)) {
            Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show();
            showNextQuiz();
        } else {
            Toast.makeText(this, "BAD", Toast.LENGTH_SHORT).show();
        }
    }

    private void initQuestions() {
        questions.clear();
        questions.add(new QuizItem("Poland", "Warsaw"));
        questions.add(new QuizItem("Germany", "Berlin"));
        questions.add(new QuizItem("United Kingdom", "London"));
        questions.add(new QuizItem("France", "Paris"));
        Collections.shuffle(questions);
    }

    public void showNextQuiz() {

        if (quizCount >= questions.size()) {
            Collections.shuffle(questions);
            quizCount = 0;
        }
        countLabel.setText("Q" + (quizCount + 1));

        QuizItem item = questions.get(quizCount);

        questionLabel.setText(item.getQuestion());
        rightAnswer = item.getRightAnswer();

        List<QuizItem> tmp = new ArrayList<>();
        for (QuizItem i : questions) {
            if (i != item) {
                tmp.add(i);
            }
        }

        int rightAnswerIdx = new Random().nextInt(4);

        buttons.get(rightAnswerIdx).setText(rightAnswer);

        List<Button> tmpButtons = new ArrayList();
        for (Button button : buttons) {
            if (button != buttons.get(rightAnswerIdx)) {
                tmpButtons.add(button);
            }
        }


        for (Button b : tmpButtons) {
            int idx = tmpButtons.indexOf(b);
            if (idx != rightAnswerIdx) {
                tmpButtons.get(idx).setText(tmp.get(idx).getRightAnswer());
            }
        }
        quizCount++;
    }


}
