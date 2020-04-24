package com.example.bmicalculator;

public class QuizItem {

    private final String question;

    public String getQuestion() {
        return question;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    private final String rightAnswer;

    public QuizItem(String question, String rightAnswer) {
        this.question = question;
        this.rightAnswer = rightAnswer;
    }
}
