package com.example.makharijAlHuroof.models;

public class Tutorial {
    private int regionID;
    private int letterID;
    private int soundID;
    private int imageID;

    public Tutorial(int region, int letter, int sound, int imageID) {
        this.regionID = region;
        this.letterID = letter;
        this.soundID = sound;
        this.imageID = imageID;
    }

    public int getRegionID() {
        return regionID;
    }

    public void setRegionID(int regionID) {
        this.regionID = regionID;
    }

    public int getLetterID() {
        return letterID;
    }

    public void setLetterID(int letterID) {
        this.letterID = letterID;
    }

    public int getSoundID() {
        return soundID;
    }

    public void setSoundID(int soundID) {
        this.soundID = soundID;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }
}
