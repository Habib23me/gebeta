package com.example.android.gebeta.data;

/**
 * Created by KottlandPro TET on 3/3/2018.
 */

public class CardItem {

    private String mTextResource;
    private String mTitleResource;
    private final int mImageResource;

    public CardItem(String title, String text, int imageResource) {
        mTitleResource = title;
        mTextResource = text;
        mImageResource=imageResource;
    }



    public String getText() {
        return mTextResource;
    }

    public String getTitle() {
        return mTitleResource;
    }

    public int getImageResource() {
        return mImageResource;
    }
}
