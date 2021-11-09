package com.example.makharijAlHuroof;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class TutorialMain extends AppCompatActivity {

    TextView tutorialHeader;
    TextView currTutorialText;
    TextView currTutorialLetter;
    TextView currTutorialSound;
    Button btnNext;
    Button btnPrevious;
    Integer currTutorialCount;
    TouchListener touchListener;
    ClickListener clickListener;

    ArrayList<String> letters;
    ArrayList<String> sounds;
    ArrayList<String> regions;

    int[] regionSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_main);

        tutorialHeader = findViewById(R.id.tutorialHeader);
        currTutorialText = findViewById(R.id.tutorialCountText);
        currTutorialLetter = findViewById(R.id.letterText);
        currTutorialSound = findViewById(R.id.soundText);

        btnNext = findViewById(R.id.nextTutorialBtn);
        btnPrevious = findViewById(R.id.prevTutorialBtn);

        currTutorialCount = 0;

        touchListener = new TouchListener(this);
        clickListener = new ClickListener(this);

        tutorialHeader.setOnTouchListener(touchListener);
        btnPrevious.setOnClickListener(clickListener);
        btnNext.setOnClickListener(clickListener);

        letters = new ArrayList<>();
        sounds = new ArrayList<>();
        regions = new ArrayList<>();

        letters.add("أ ہ");
        letters.add("غ خ");
        letters.add("ع ح");
        letters.add("ق");
        letters.add("ک");
        letters.add("ج ش ی");
        letters.add("ض");
        letters.add("ل");
        letters.add("ن");
        letters.add("ر");
        letters.add("ت د ط");
        letters.add("ظ ذ ث");
        letters.add("ص ز س");
        letters.add("م ن");
        letters.add("ف");
        letters.add("ف");
        letters.add("م");
        letters.add("و");
        letters.add("باَ بوُ بىِ");

        sounds.add("End of Throat");
        sounds.add("Middle of Throat");
        sounds.add("Start of the Throat");
        sounds.add("Base of Tongue which is near Uvula touching the mouth roof");
        sounds.add("Portion of Tongue near its base touching the roof of mouth");
        sounds.add("Tongue touching the center of the mouth roof");
        sounds.add("One side of the tongue touching the molar teeth");
        sounds.add("Rounded tip of the tongue touching the base of the frontal 8 teeth");
        sounds.add("Rounded tip of the tongue touching the base of the frontal 6 teeth");
        sounds.add("Rounded tip of the tongue and some portion near it touching the base of the frontal 4 teeth");
        sounds.add("Tip of the tongue touching the base of the front 2 teeth");
        sounds.add("Tip of the tongue touching the tip of the frontal 2 teeth");
        sounds.add("Tip of the tongue comes between the front top and bottom teeth");
        sounds.add("While pronouncing the ending sound of  م  or ن , bring the vibration to the nose");
        sounds.add("Tip of the two upper jaw teeth touches the inner part of the lower lip");
        sounds.add("Inner part of the both lips touch each other");
        sounds.add("Outer part of both lips touch each other");
        sounds.add("Rounding both lips and not closing the mouth");
        sounds.add("Mouth empty space while speaking words like  باَ بوُ بىِ");

        regions.add("1. Halqiyah");
        regions.add("2. Lahatiyah");
        regions.add("3. Shajariyah-Haafiyah");
        regions.add("4. Tarfiyah");
        regions.add("5. Nit-eeyah");
        regions.add("6. Lisaveyah");
        regions.add("7. Lisaveyah");
        regions.add("8. Ghunna");
        regions.add("9. Ghunna");

        regionSwitch = new int[]{3, 5, 7, 10, 11, 12, 13, 14};
    }
}