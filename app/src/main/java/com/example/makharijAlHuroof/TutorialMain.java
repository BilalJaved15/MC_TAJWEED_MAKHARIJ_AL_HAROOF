package com.example.makharijAlHuroof;

import com.example.makharijAlHuroof.data.TutorialDataSource;
import com.example.makharijAlHuroof.models.Tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class TutorialMain extends AppCompatActivity {

    TextView tutorialHeader;
    TextView currTutorialText;
    TextView currTutorialLetter;
    TextView currTutorialSound;
    Button btnNext;
    Button btnPrevious;
    ImageView currTutorialImage;

    Integer currTutorialCount;
    TouchListener touchListener;
    ClickListener clickListener;

    ArrayList<Tutorial> tutorials;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_main);

        tutorialHeader = findViewById(R.id.tutorialHeader);
        currTutorialText = findViewById(R.id.tutorialCountText);
        currTutorialLetter = findViewById(R.id.letterText);
        currTutorialSound = findViewById(R.id.soundText);
        currTutorialImage = findViewById(R.id.currTutorialImage);

        btnNext = findViewById(R.id.nextTutorialBtn);
        btnPrevious = findViewById(R.id.prevTutorialBtn);

        currTutorialCount = 0;

        touchListener = new TouchListener(this);
        clickListener = new ClickListener(this);

        tutorialHeader.setOnTouchListener(touchListener);
        btnPrevious.setOnClickListener(clickListener);
        btnNext.setOnClickListener(clickListener);

        tutorials = TutorialDataSource.getTutorials();
    }

    @Override

    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("currTutorialCount", currTutorialCount);
        savedInstanceState.putBoolean("nextEnabled", btnNext.isEnabled());
        savedInstanceState.putBoolean("prevEnabled", btnPrevious.isEnabled());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        currTutorialCount = (savedInstanceState.getInt("currTutorialCount"));
        btnNext.setEnabled(savedInstanceState.getBoolean("nextEnabled"));
        btnPrevious.setEnabled(savedInstanceState.getBoolean("prevEnabled"));
        tutorials = TutorialDataSource.getTutorials();
        currTutorialLetter.setText(getString(tutorials.get(currTutorialCount).getLetterID()));
        currTutorialSound.setText(getString(tutorials.get(currTutorialCount).getSoundID()));
        currTutorialText.setText(getString(tutorials.get(currTutorialCount).getRegionID()));
        currTutorialImage.setImageResource((tutorials.get(currTutorialCount).getImageID()));
    }
}