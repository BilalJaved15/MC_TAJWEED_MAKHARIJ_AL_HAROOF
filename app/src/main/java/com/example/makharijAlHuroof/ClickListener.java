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
        else if (v.getId() == R.id.nextTutorialBtn){
            TutorialMain activity = (TutorialMain)this.activity;
            if (activity.currTutorialCount < 18){
                activity.currTutorialCount++;
                activity.btnNext.setEnabled(activity.currTutorialCount < 18);
                activity.btnPrevious.setEnabled(activity.currTutorialCount > 0);
                activity.currTutorialLetter.setText(activity.letters.get(activity.currTutorialCount));
                activity.currTutorialSound.setText(activity.sounds.get(activity.currTutorialCount));
            }
        }
        else if (v.getId() == R.id.prevTutorialBtn){
            TutorialMain activity = (TutorialMain)this.activity;
            if (activity.currTutorialCount > 0){
                activity.currTutorialCount--;
                activity.btnNext.setEnabled(activity.currTutorialCount < 18);
                activity.btnPrevious.setEnabled(activity.currTutorialCount > 0);
                activity.currTutorialLetter.setText(activity.letters.get(activity.currTutorialCount));
                activity.currTutorialSound.setText(activity.sounds.get(activity.currTutorialCount));
            }
        }
    }
}
