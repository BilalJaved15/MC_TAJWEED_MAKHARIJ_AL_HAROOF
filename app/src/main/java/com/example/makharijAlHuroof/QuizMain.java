package com.example.makharijAlHuroof;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.makharijAlHuroof.data.QuizDataSource;
import com.example.makharijAlHuroof.models.QuizQuestion;

import java.util.ArrayList;

public class QuizMain extends AppCompatActivity {

    TextView quizHeader;
    TextView currSection;
    TextView currQuestionCount;

    TouchListener touchListener;
    ClickListener clickListener;

    ArrayList<QuizQuestion> quizQuestions;
    Integer currIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_main);

        quizHeader = findViewById(R.id.quizHeader);
        
        touchListener = new TouchListener(this);
        clickListener = new ClickListener(this);

        quizHeader.setOnTouchListener(touchListener);

        quizQuestions = QuizDataSource.getQuizQuestions();
        /*for(QuizQuestion question : quizQuestions){
            for (int i = 0; i < question.getOptionIDs().length; i++){
                System.out.println("Option " + (i+1) + ": " + question.getOptionIDs()[i]);
            }
            System.out.println("Correct Option: " + question.getCorrectOption());
        }*/
    }
}