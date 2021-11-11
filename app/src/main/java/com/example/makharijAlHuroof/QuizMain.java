package com.example.makharijAlHuroof;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.makharijAlHuroof.data.QuizDataSource;
import com.example.makharijAlHuroof.data.TutorialDataSource;
import com.example.makharijAlHuroof.models.QuizQuestion;

import java.util.ArrayList;

public class QuizMain extends AppCompatActivity {

    TextView quizHeader;
    TextView currSection;
    TextView currQuestionCount;
    TextView currQuestionStatement;

    ImageView currImage;

    RadioGroup radioGroup;

    RadioButton currOption1;
    RadioButton currOption2;
    RadioButton currOption3;
    RadioButton currOption4;

    Button btnQuizNext;

    TouchListener touchListener;
    ClickListener clickListener;

    ArrayList<QuizQuestion> quizQuestions;
    ArrayList<Integer> answers;
    Integer currIndex;

    public void setQuestion() {
        if (currIndex < 3) {
            currSection.setText(getString(R.string.sectionHeader1));
            currQuestionStatement.setText(getString(R.string.section1));
            currImage.setImageResource(quizQuestions.get(currIndex).getSelectedQuestion().getImageID());
            currOption1.setText(getString(TutorialDataSource.getTutorials().get(quizQuestions.get(currIndex).getOptionIDs()[0]).getLetterID()));
            currOption2.setText(getString(TutorialDataSource.getTutorials().get(quizQuestions.get(currIndex).getOptionIDs()[1]).getLetterID()));
            currOption3.setText(getString(TutorialDataSource.getTutorials().get(quizQuestions.get(currIndex).getOptionIDs()[2]).getLetterID()));
            currOption4.setText(getString(TutorialDataSource.getTutorials().get(quizQuestions.get(currIndex).getOptionIDs()[3]).getLetterID()));
        } else if (currIndex < 5) {
            currSection.setText(getString(R.string.sectionHeader2));
            currQuestionStatement.setText(getString(R.string.section2));
            currImage.setImageResource(quizQuestions.get(currIndex).getSelectedQuestion().getImageID());
            currOption1.setText(getString(TutorialDataSource.getTutorials().get(quizQuestions.get(currIndex).getOptionIDs()[0]).getRegionID()));
            currOption2.setText(getString(TutorialDataSource.getTutorials().get(quizQuestions.get(currIndex).getOptionIDs()[1]).getRegionID()));
            currOption3.setText(getString(TutorialDataSource.getTutorials().get(quizQuestions.get(currIndex).getOptionIDs()[2]).getRegionID()));
            currOption4.setText(getString(TutorialDataSource.getTutorials().get(quizQuestions.get(currIndex).getOptionIDs()[3]).getRegionID()));
        } else {
            currSection.setText(getString(R.string.sectionHeader3));
            currQuestionStatement.setText(getString(R.string.section3) + " " + getString(quizQuestions.get(currIndex).getSelectedQuestion().getLetterID()) + "?");
            currImage.setImageDrawable(null);
            currOption1.setText(getString(TutorialDataSource.getTutorials().get(quizQuestions.get(currIndex).getOptionIDs()[0]).getSoundID()));
            currOption2.setText(getString(TutorialDataSource.getTutorials().get(quizQuestions.get(currIndex).getOptionIDs()[1]).getSoundID()));
            currOption3.setText(getString(TutorialDataSource.getTutorials().get(quizQuestions.get(currIndex).getOptionIDs()[2]).getSoundID()));
            currOption4.setText(getString(TutorialDataSource.getTutorials().get(quizQuestions.get(currIndex).getOptionIDs()[3]).getSoundID()));
        }
        currQuestionCount.setText((currIndex + 1) + "/10");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_main);

        quizHeader = findViewById(R.id.quizHeader);
        currSection = findViewById(R.id.sectionText);
        currQuestionCount = findViewById(R.id.questionCount);
        currQuestionStatement = findViewById(R.id.currQuestionStatement);
        currImage = findViewById(R.id.quizImage);

        radioGroup = findViewById(R.id.radioGroup);

        currOption1 = findViewById(R.id.option1);
        currOption2 = findViewById(R.id.option2);
        currOption3 = findViewById(R.id.option3);
        currOption4 = findViewById(R.id.option4);

        btnQuizNext = findViewById(R.id.nextQuizBtn);

        touchListener = new TouchListener(this);
        clickListener = new ClickListener(this);

        btnQuizNext.setOnClickListener(clickListener);

        quizHeader.setOnTouchListener(touchListener);

        currIndex = 0;
        quizQuestions = QuizDataSource.getQuizQuestions();
        answers = new ArrayList<>();
        setQuestion();
    }
}