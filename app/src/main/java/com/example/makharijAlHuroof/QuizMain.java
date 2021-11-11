package com.example.makharijAlHuroof;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class QuizMain extends AppCompatActivity {

    TextView quizHeader;

    TouchListener touchListener;
    ClickListener clickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_main);

        quizHeader = findViewById(R.id.quizHeader);
        
        touchListener = new TouchListener(this);
        clickListener = new ClickListener(this);

        quizHeader.setOnTouchListener(touchListener);
    }
}