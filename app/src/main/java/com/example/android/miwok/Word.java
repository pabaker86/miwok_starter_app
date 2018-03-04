package com.example.android.miwok;

/**
 * Created by Bakes on 2/24/2018.
 */

/**
 Each word object has 2 properties: default word, miwok word
 */

public class Word {

    private String mDefaultTranslation; // default translation of the word
    private String mMiwokTranslation;  // Miwok translastion of the word
    private int mResourceImageId;       //Image resource ID
    private boolean mDoesContainImage ;  // value to set if there is or is not an image.

    //Constructor method for data type (Word) with 2 strings of input
    //@param defaultTranslation is the english word
    //@param miwokTranslation is the miwok word
    //@param mResourceImageID is the id for each word image associated to it.

    //two variable input constructor 2 strings
    public Word(String defaultTranslation, String miwokTranslation){
        mMiwokTranslation = miwokTranslation;
        mDefaultTranslation = defaultTranslation;
        mDoesContainImage = false;
    }
    //three varaible input constructor 1 image 2 strings
    public Word(String defaultTranslation, String miwokTranslation, int resourceImageId) {
        mMiwokTranslation = miwokTranslation;
        mDefaultTranslation = defaultTranslation;
        mResourceImageId = resourceImageId;
        mDoesContainImage = true;
    }

    //returns the Miwok string translation
    public String getMiwokTranslaction() {
        return mMiwokTranslation;
    }

    //returns the Default string translation
    public String getDefaultTranslaction() {
        return mDefaultTranslation;
    }

    //returns integer image resource ID
    public int getImageResourceID() { return mResourceImageId;     }

    //returns value of whether an image is present or not.
    public boolean isThereAnImage(){  return mDoesContainImage; }
}