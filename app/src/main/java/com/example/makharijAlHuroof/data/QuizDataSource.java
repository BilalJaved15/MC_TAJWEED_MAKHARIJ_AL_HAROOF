package com.example.makharijAlHuroof.data;

import com.example.makharijAlHuroof.models.QuizQuestion;

import java.util.ArrayList;
import java.util.Random;

public class QuizDataSource {
    public static ArrayList<QuizQuestion> getQuizQuestions(){
        ArrayList<QuizQuestion> quizQuestions = new ArrayList<>();
        ArrayList<Integer> selectedQs = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int id = random.nextInt(19);
            while (selectedQs.contains(id)){
                id = random.nextInt(19);
            }
            selectedQs.add(id);
            quizQuestions.add(new QuizQuestion(id));
        }
        return quizQuestions;
    }

    public static ArrayList<Integer> parseToIntegerArray(ArrayList<QuizQuestion> quizQuestions){
        ArrayList<Integer> parsedArray = new ArrayList<>();
        for (int i = 0; i < quizQuestions.size(); i++) {
            parsedArray.add(quizQuestions.get(i).getSelectedQuestionIndex());
            parsedArray.add(quizQuestions.get(i).getOptionIDs()[0]);
            parsedArray.add(quizQuestions.get(i).getOptionIDs()[1]);
            parsedArray.add(quizQuestions.get(i).getOptionIDs()[2]);
            parsedArray.add(quizQuestions.get(i).getOptionIDs()[3]);
            parsedArray.add(quizQuestions.get(i).getCorrectOption());
        }
        return parsedArray;
    }

    public static ArrayList<QuizQuestion> parseToQuizQuestionArray(ArrayList<Integer> quizQuestions){
        ArrayList<QuizQuestion> parsedArray = new ArrayList<>();
        for (int i = 0, j = 0; j < (quizQuestions.size()/6); i+=6, j++) {
            parsedArray.add(new QuizQuestion(quizQuestions.get(i)));
            parsedArray.get(j).setOptionIDs(0, quizQuestions.get(i + 1));
            parsedArray.get(j).setOptionIDs(1, quizQuestions.get(i + 2));
            parsedArray.get(j).setOptionIDs(2, quizQuestions.get(i + 3));
            parsedArray.get(j).setOptionIDs(3, quizQuestions.get(i + 4));
            parsedArray.get(j).setCorrectOption(quizQuestions.get(i + 5));
        }
        return parsedArray;
    }
}
