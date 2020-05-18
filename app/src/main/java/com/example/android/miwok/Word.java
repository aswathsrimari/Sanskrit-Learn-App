package com.example.android.miwok;

import android.content.Context;
import android.view.View;

public class Word {

    private  static final int NO_IMAGE_PROVIDED  = -1;
    private String word;
    private String translate;
    private int mImageResourceId =NO_IMAGE_PROVIDED;
    private int mMediaId;

    public Word(String s1,String s2){
        word = s1;
        translate = s2;
    }
    public Word(String s1,String s2,int im,int mm){
        word = s1;
        translate = s2;
        mImageResourceId = im;
        mMediaId  = mm;
    }
    public String getDefaultWord(){
        return word;
    }
    public String getTranslate(){
        return translate;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }
    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
    public int getmMediaId(){
        return mMediaId;
    }
}
