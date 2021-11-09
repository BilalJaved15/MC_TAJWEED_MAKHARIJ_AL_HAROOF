package com.example.makharijAlHuroof;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnTutorial;
    Button btnQuiz;
    Button btnRepo;

    ClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listener = new ClickListener(this);

        btnTutorial = findViewById(R.id.btnTutorial);
        btnQuiz = findViewById(R.id.btnQuiz);
        btnRepo = findViewById(R.id.btnRepo);

        btnTutorial.setOnClickListener(listener);
        btnQuiz.setOnClickListener(listener);
        btnRepo.setOnClickListener(listener);
    }
}