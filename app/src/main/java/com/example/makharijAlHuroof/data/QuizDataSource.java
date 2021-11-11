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
}
