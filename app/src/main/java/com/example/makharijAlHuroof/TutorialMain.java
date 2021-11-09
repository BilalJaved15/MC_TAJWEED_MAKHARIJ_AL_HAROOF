package com.example.makharijAlHuroof;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
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

    ArrayList<String> letters;
    ArrayList<String> sounds;
    ArrayList<String> regions;

    Integer[] imageForwardSwitch;
    Integer[] imageBackwardSwitch;
    Integer[] regionForwardSwitch;
    Integer[] regionBackwardSwitch;

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
        letters.add("ب");
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
        regions.add("7. Ghunna");

        imageForwardSwitch = new Integer[]{0, 3, 5, 7, 10, 11, 12, 13, 14};
        imageBackwardSwitch = new Integer[]{2, 4, 6, 9, 10, 11, 12, 13, 14};
        regionForwardSwitch = new Integer[]{0, 3, 5, 7, 10, 11, 13};
        regionBackwardSwitch = new Integer[]{2, 4, 6, 9, 10, 12, 13};
    }

    @Override

    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("currTutorialText", currTutorialText.getText().toString());
        savedInstanceState.putString("currTutorialLetter", currTutorialLetter.getText().toString());
        savedInstanceState.putString("currTutorialSound", currTutorialSound.getText().toString());
        int currImage = 1;
        if (currTutorialImage.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.emission2).getConstantState()) {
            currImage = 2;
        } else if (currTutorialImage.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.emission3).getConstantState()) {
            currImage = 3;
        } else if (currTutorialImage.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.emission4).getConstantState()) {
            currImage = 4;
        } else if (currTutorialImage.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.emission5).getConstantState()) {
            currImage = 5;
        } else if (currTutorialImage.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.emission6).getConstantState()) {
            currImage = 6;
        } else if (currTutorialImage.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.emission7).getConstantState()) {
            currImage = 7;
        } else if (currTutorialImage.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.emission8).getConstantState()) {
            currImage = 8;
        } else if (currTutorialImage.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.emission9).getConstantState()) {
            currImage = 9;
        }
        savedInstanceState.putInt("currImage", currImage);
        savedInstanceState.putInt("currTutorialCount", currTutorialCount);
        savedInstanceState.putBoolean("nextEnabled", btnNext.isEnabled());
        savedInstanceState.putBoolean("prevEnabled", btnPrevious.isEnabled());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        currTutorialText.setText(savedInstanceState.getString("currTutorialText"));
        currTutorialLetter.setText(savedInstanceState.getString("currTutorialLetter"));
        currTutorialSound.setText(savedInstanceState.getString("currTutorialSound"));
        currTutorialCount = (savedInstanceState.getInt("currTutorialCount"));
        int currImage = savedInstanceState.getInt("currImage");
        switch (currImage){
            case 1:
                currTutorialImage.setImageResource(R.drawable.emission1);
                break;
            case 2:
                currTutorialImage.setImageResource(R.drawable.emission2);
                break;
            case 3:
                currTutorialImage.setImageResource(R.drawable.emission3);
                break;
            case 4:
                currTutorialImage.setImageResource(R.drawable.emission4);
                break;
            case 5:
                currTutorialImage.setImageResource(R.drawable.emission5);
                break;
            case 6:
                currTutorialImage.setImageResource(R.drawable.emission6);
                break;
            case 7:
                currTutorialImage.setImageResource(R.drawable.emission7);
                break;
            case 8:
                currTutorialImage.setImageResource(R.drawable.emission8);
                break;
            case 9:
                currTutorialImage.setImageResource(R.drawable.emission9);
                break;
        }
        btnNext.setEnabled(savedInstanceState.getBoolean("nextEnabled"));
        btnPrevious.setEnabled(savedInstanceState.getBoolean("prevEnabled"));
    }
}