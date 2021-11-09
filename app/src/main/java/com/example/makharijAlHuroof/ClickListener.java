package com.example.makharijAlHuroof;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ClickListener implements View.OnClickListener {

    AppCompatActivity activity;

    public ClickListener(AppCompatActivity activity){
        this.activity = activity;
    }

    public int findIndex(Integer[] arr, Integer key){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key)
                return i;
        }
        return -1;
    }

    public void setTutorialImage(ImageView currTutorialImage, int imageIndex){
        if (imageIndex != -1){
            switch (imageIndex){
                case 0:
                    currTutorialImage.setImageResource(R.drawable.emission1);
                    break;
                case 1:
                    currTutorialImage.setImageResource(R.drawable.emission2);
                    break;
                case 2:
                    currTutorialImage.setImageResource(R.drawable.emission3);
                    break;
                case 3:
                    currTutorialImage.setImageResource(R.drawable.emission4);
                    break;
                case 4:
                    currTutorialImage.setImageResource(R.drawable.emission5);
                    break;
                case 5:
                    currTutorialImage.setImageResource(R.drawable.emission6);
                    break;
                case 6:
                    currTutorialImage.setImageResource(R.drawable.emission7);
                    break;
                case 7:
                    currTutorialImage.setImageResource(R.drawable.emission8);
                    break;
                case 8:
                    currTutorialImage.setImageResource(R.drawable.emission9);
                    break;
            }
        }
    }

    public void setTutorialRegion(TextView currTutorialRegion, int regionIndex, ArrayList<String> textArray){
        if (regionIndex != -1){
            switch (regionIndex){
                case 0:
                    currTutorialRegion.setText(textArray.get(0));
                    break;
                case 1:
                    currTutorialRegion.setText(textArray.get(1));
                    break;
                case 2:
                    currTutorialRegion.setText(textArray.get(2));
                    break;
                case 3:
                    currTutorialRegion.setText(textArray.get(3));
                    break;
                case 4:
                    currTutorialRegion.setText(textArray.get(4));
                    break;
                case 5:
                    currTutorialRegion.setText(textArray.get(5));
                    break;
                case 6:
                    currTutorialRegion.setText(textArray.get(6));
                    break;
            }
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnTutorial){
            Intent intent = new Intent(activity, TutorialMain.class);
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
                activity.currTutorialLetter.setText(activity.letters.get(activity.currTutorialCount));
                activity.currTutorialSound.setText(activity.sounds.get(activity.currTutorialCount));
                int imageIndex = findIndex(activity.imageForwardSwitch, activity.currTutorialCount);
                int regionIndex = findIndex(activity.regionForwardSwitch, activity.currTutorialCount);
                setTutorialImage(activity.currTutorialImage, imageIndex);
                setTutorialRegion(activity.currTutorialText, regionIndex, activity.regions);
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
                int imageIndex = findIndex(activity.imageBackwardSwitch, activity.currTutorialCount);
                int regionIndex = findIndex(activity.regionBackwardSwitch, activity.currTutorialCount);
                setTutorialImage(activity.currTutorialImage, imageIndex);
                setTutorialRegion(activity.currTutorialText, regionIndex, activity.regions);
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
