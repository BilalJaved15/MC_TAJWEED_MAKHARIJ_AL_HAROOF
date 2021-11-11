package com.example.makharijAlHuroof.data;
import com.example.makharijAlHuroof.R;
import com.example.makharijAlHuroof.models.Tutorial;

import java.util.ArrayList;

public class TutorialDataSource {

//    private static int[] imageSwitch = {0, 3, 5, 7, 10, 11, 12, 13, 14};
//    private static int[] regionSwitch = {0, 3, 5, 7, 10, 11, 13};

    public static ArrayList<Tutorial> getTutorials(){
        ArrayList<Tutorial> tutorials = new ArrayList<>();
        for (int i = 0; i < 19; i++) {
            int regionID;
            int letterID;
            int soundID;
            int imageID;
            switch (i){
                case 0:
                    regionID = R.string.regions_1;
                    letterID = R.string.letters_1;
                    soundID = R.string.sounds_1;
                    imageID = R.drawable.emission1;
                    break;
                case 1:
                    regionID = R.string.regions_1;
                    letterID = R.string.letters_2;
                    soundID = R.string.sounds_2;
                    imageID = R.drawable.emission1;
                    break;
                case 2:
                    regionID = R.string.regions_1;
                    letterID = R.string.letters_3;
                    soundID = R.string.sounds_3;
                    imageID = R.drawable.emission1;
                    break;
                case 3:
                    regionID = R.string.regions_2;
                    letterID = R.string.letters_4;
                    soundID = R.string.sounds_4;
                    imageID = R.drawable.emission2;
                    break;
                case 4:
                    regionID = R.string.regions_2;
                    letterID = R.string.letters_5;
                    soundID = R.string.sounds_5;
                    imageID = R.drawable.emission2;
                    break;
                case 5:
                    regionID = R.string.regions_3;
                    letterID = R.string.letters_6;
                    soundID = R.string.sounds_6;
                    imageID = R.drawable.emission3;
                    break;
                case 6:
                    regionID = R.string.regions_3;
                    letterID = R.string.letters_7;
                    soundID = R.string.sounds_7;
                    imageID = R.drawable.emission3;
                    break;
                case 7:
                    regionID = R.string.regions_4;
                    letterID = R.string.letters_8;
                    soundID = R.string.sounds_8;
                    imageID = R.drawable.emission4;
                    break;
                case 8:
                    regionID = R.string.regions_4;
                    letterID = R.string.letters_9;
                    soundID = R.string.sounds_9;
                    imageID = R.drawable.emission4;
                    break;
                case 9:
                    regionID = R.string.regions_4;
                    letterID = R.string.letters_10;
                    soundID = R.string.sounds_10;
                    imageID = R.drawable.emission4;
                    break;
                case 10:
                    regionID = R.string.regions_5;
                    letterID = R.string.letters_11;
                    soundID = R.string.sounds_11;
                    imageID = R.drawable.emission5;
                    break;
                case 11:
                    regionID = R.string.regions_6;
                    letterID = R.string.letters_12;
                    soundID = R.string.sounds_12;
                    imageID = R.drawable.emission6;
                    break;
                case 12:
                    regionID = R.string.regions_6;
                    letterID = R.string.letters_13;
                    soundID = R.string.sounds_13;
                    imageID = R.drawable.emission7;
                    break;
                case 13:
                    regionID = R.string.regions_7;
                    letterID = R.string.letters_14;
                    soundID = R.string.sounds_14;
                    imageID = R.drawable.emission8;
                    break;
                case 14:
                    regionID = R.string.regions_7;
                    letterID = R.string.letters_15;
                    soundID = R.string.sounds_15;
                    imageID = R.drawable.emission9;
                    break;
                case 15:
                    regionID = R.string.regions_7;
                    letterID = R.string.letters_16;
                    soundID = R.string.sounds_16;
                    imageID = R.drawable.emission9;
                    break;
                case 16:
                    regionID = R.string.regions_7;
                    letterID = R.string.letters_17;
                    soundID = R.string.sounds_17;
                    imageID = R.drawable.emission9;
                    break;
                case 17:
                    regionID = R.string.regions_7;
                    letterID = R.string.letters_18;
                    soundID = R.string.sounds_18;
                    imageID = R.drawable.emission9;
                    break;
                default:
                    regionID = R.string.regions_7;
                    letterID = R.string.letters_19;
                    soundID = R.string.sounds_19;
                    imageID = R.drawable.emission9;
                    break;
            }
            Tutorial tutorial = new Tutorial(regionID, letterID, soundID, imageID);
            tutorials.add(tutorial);
        }
        return tutorials;
    }
}
