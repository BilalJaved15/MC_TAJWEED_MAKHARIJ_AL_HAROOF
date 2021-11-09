package com.example.makharijAlHuroof;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class GitMain extends AppCompatActivity {

    Button btnOpenRepo;
    TextView gitHeader;

    ClickListener clickListener;
    TouchListener touchListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_git_main);

        btnOpenRepo = findViewById(R.id.btnOpenRepo);
        gitHeader = findViewById(R.id.gitHeader);

        clickListener = new ClickListener(this);
        touchListener = new TouchListener(this);

        btnOpenRepo.setOnClickListener(clickListener);
        gitHeader.setOnTouchListener(touchListener);
    }
}