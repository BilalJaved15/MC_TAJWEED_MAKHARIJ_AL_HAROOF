package com.example.makharijAlHuroof.models;

import com.example.makharijAlHuroof.R;
import com.example.makharijAlHuroof.data.TutorialDataSource;

import java.util.Arrays;
import java.util.Random;

public class QuizQuestion {
    private Tutorial selectedQuestion;
    private int selectedQuestionIndex;
    private int correctOption;
    private int[] optionIDs;

    public int getSelectedQuestionIndex() {
        return selectedQuestionIndex;
    }

    public void setSelectedQuestionIndex(int selectedQuestionIndex) {
        this.selectedQuestionIndex = selectedQuestionIndex;
    }

    public Tutorial getSelectedQuestion() {
        return selectedQuestion;
    }

    public void setSelectedQuestion(Tutorial selectedQuestion) {
        this.selectedQuestion = selectedQuestion;
    }

    public int getCorrectOption() {
        return correctOption;
    }

    public void setCorrectOption(int correctOption) {
        this.correctOption = correctOption;
    }

    public int[] getOptionIDs() {
        return optionIDs;
    }

    public void setOptionIDs(int[] optionIDs) {
        this.optionIDs = optionIDs;
    }

    public void setOptionIDs(int index, int val){
        this.optionIDs[index] = val;
    }

    private boolean isSelected(int id){
        for (int optionID : optionIDs) {
            if (optionID == id)
                return true;
        }
        return false;
    }

    private void populateOptions(){
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            if (i != correctOption){
                int id = random.nextInt(19);
                while (isSelected(id)){
                    id = random.nextInt(19);
                }
                optionIDs[i] = id;
            }
        }
    }

    public QuizQuestion(int id){
        this.selectedQuestionIndex = id;
        this.selectedQuestion = TutorialDataSource.getTutorials().get(id);
        switch (this.selectedQuestion.getImageID()){
            case R.drawable.emission1:
                this.selectedQuestion.setImageID(R.drawable.emission1quiz);
                break;
            case R.drawable.emission2:
                this.selectedQuestion.setImageID(R.drawable.emission2quiz);
                break;
            case R.drawable.emission3:
                this.selectedQuestion.setImageID(R.drawable.emission3quiz);
                break;
            case R.drawable.emission4:
                this.selectedQuestion.setImageID(R.drawable.emission4quiz);
                break;
            case R.drawable.emission5:
                this.selectedQuestion.setImageID(R.drawable.emission5quiz);
                break;
            case R.drawable.emission6:
                this.selectedQuestion.setImageID(R.drawable.emission6quiz);
                break;
            case R.drawable.emission7:
                this.selectedQuestion.setImageID(R.drawable.emission7quiz);
                break;
            case R.drawable.emission8:
                this.selectedQuestion.setImageID(R.drawable.emission8quiz);
                break;
            case R.drawable.emission9:
                this.selectedQuestion.setImageID(R.drawable.emission9quiz);
                break;
        }
        optionIDs = new int[4];
        Arrays.fill(optionIDs, -1);
        Random rand = new Random();
        correctOption = rand.nextInt(4);
        optionIDs[correctOption] = id;
        populateOptions();
    }
}
