package com.example.makharijAlHuroof;

import android.content.Intent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ClickListener implements View.OnClickListener {

    AppCompatActivity activity;

    public ClickListener(AppCompatActivity activity){
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnTutorial){
            Intent intent = new Intent(activity, TutorialMain.class);
            activity.startActivity(intent);
        }
        if (v.getId() == R.id.tutorialHeader){

        }
    }
}
