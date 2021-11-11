package com.example.makharijAlHuroof;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Toast;

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
        }else if(v.getId() == R.id.btnQuiz){
            Intent intent = new Intent(activity, QuizMain.class);
            activity.startActivity(intent);
        } else if(v.getId() == R.id.btnRepo){
            Intent intent = new Intent(activity, GitMain.class);
            activity.startActivity(intent);
        }
        else if (v.getId() == R.id.nextTutorialBtn){
            TutorialMain activity = (TutorialMain)this.activity;
            if (activity.currTutorialCount < 18){
                activity.currTutorialCount++;
                activity.btnNext.setEnabled(activity.currTutorialCount < 18);
                activity.btnPrevious.setEnabled(activity.currTutorialCount > 0);
                activity.currTutorialLetter.setText(activity.getString(activity.tutorials.get(activity.currTutorialCount).getLetterID()));
                activity.currTutorialSound.setText(activity.getString(activity.tutorials.get(activity.currTutorialCount).getSoundID()));
                activity.currTutorialText.setText(activity.getString(activity.tutorials.get(activity.currTutorialCount).getRegionID()));
                activity.currTutorialImage.setImageResource((activity.tutorials.get(activity.currTutorialCount).getImageID()));
            }
        }
        else if (v.getId() == R.id.prevTutorialBtn){
            TutorialMain activity = (TutorialMain)this.activity;
            if (activity.currTutorialCount > 0){
                activity.currTutorialCount--;
                activity.btnNext.setEnabled(activity.currTutorialCount < 18);
                activity.btnPrevious.setEnabled(activity.currTutorialCount > 0);
                activity.currTutorialLetter.setText(activity.getString(activity.tutorials.get(activity.currTutorialCount).getLetterID()));
                activity.currTutorialSound.setText(activity.getString(activity.tutorials.get(activity.currTutorialCount).getSoundID()));
                activity.currTutorialText.setText(activity.getString(activity.tutorials.get(activity.currTutorialCount).getRegionID()));
                activity.currTutorialImage.setImageResource((activity.tutorials.get(activity.currTutorialCount).getImageID()));
            }
        }
        else if(v.getId() == R.id.nextQuizBtn){
            QuizMain activity = (QuizMain)this.activity;
            if (activity.radioGroup.getCheckedRadioButtonId() != -1){
                switch (activity.radioGroup.getCheckedRadioButtonId()){
                    case R.id.option1:
                        activity.answers.add(0);
                        break;
                    case R.id.option2:
                        activity.answers.add(1);
                        break;
                    case R.id.option3:
                        activity.answers.add(2);
                        break;
                    default:
                        activity.answers.add(3);
                        break;
                }
                if (activity.currIndex < 9){
                    activity.currIndex++;
                    activity.setQuestion();
                }
            } else {
                Toast.makeText(activity, "Please select an option", Toast.LENGTH_LONG).show();
            }
        }
        else if (v.getId() == R.id.btnOpenRepo){
            Uri webpage = Uri.parse("https://github.com/BilalJaved15/MC_TAJWEED_MAKHARIJ_AL_HAROOF");
            Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
            if (intent.resolveActivity(activity.getPackageManager()) != null) {
                activity.startActivity(intent);
            }
        }
    }
}
