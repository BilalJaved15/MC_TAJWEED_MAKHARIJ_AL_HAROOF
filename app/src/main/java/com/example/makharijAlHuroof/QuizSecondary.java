package com.example.makharijAlHuroof;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.makharijAlHuroof.data.QuizDataSource;
import com.example.makharijAlHuroof.models.QuizQuestion;

import java.util.ArrayList;

public class QuizSecondary extends AppCompatActivity {

    TextView header;
    TextView score;

    ClickListener clickListener;
    TouchListener touchListener;

    ArrayList<QuizQuestion> quizQuestions;
    ArrayList<Integer> answers;

    Integer correctAnswers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_secondary);

        header = findViewById(R.id.quizHeaderDetails);
        score = findViewById(R.id.score);

        clickListener = new ClickListener(this);
        touchListener = new TouchListener(this);

        header.setOnTouchListener(touchListener);

        quizQuestions = QuizDataSource.parseToQuizQuestionArray(getIntent().getIntegerArrayListExtra("questions"));
        answers = getIntent().getIntegerArrayListExtra("answers");

        for (int i = 0; i < quizQuestions.size(); i++) {
            if (quizQuestions.get(i).getCorrectOption() == answers.get(i))
                correctAnswers++;
        }
        score.setText(score.getText() + " " + correctAnswers + "/10");
    }
}