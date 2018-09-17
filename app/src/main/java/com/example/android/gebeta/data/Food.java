package com.example.android.gebeta.data;

public class Food {
    private String mName;
    private String mDescription;
    private int mlikes;
    private float mPrice;
    private int mReviews;
    private int mImageResource;

    public Food(String name, int likes, float price, int reviews, int imageResource) {
        mName = name;
        mlikes = likes;
        mPrice = price;
        mReviews = reviews;
        mImageResource = imageResource;
    }

    public String getName() {
        return mName;
    }

    public String getDescription() {
        return mDescription;
    }

    public float getLikes() {
        return mlikes;
    }

    public float getPrice() {
        return mPrice;
    }

    public int getReviews() {
        return mReviews;
    }

    public int getImageResource() {
        return mImageResource;
    }
}

