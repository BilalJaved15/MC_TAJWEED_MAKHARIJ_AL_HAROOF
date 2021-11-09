package com.example.makharijAlHuroof;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class TutorialMain extends AppCompatActivity {

    TextView tutorialHeader;

    TouchListener touchListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_main);
        tutorialHeader = findViewById(R.id.tutorialHeader);

        touchListener = new TouchListener(this);
        tutorialHeader.setOnTouchListener(touchListener);
    }
}