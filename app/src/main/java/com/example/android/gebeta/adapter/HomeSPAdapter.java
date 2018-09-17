package com.example.android.gebeta.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.android.gebeta.fragment.MainCatalogue;
import com.example.android.gebeta.fragment.MainCategory;

public class HomeSPAdapter extends FragmentPagerAdapter {

    public HomeSPAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        switch (position){
            case 0:
                return new MainCatalogue();
            case 1:
                return new MainCategory();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Main";
            case 1:
                return "Category";
        }
        return null;
    }
}