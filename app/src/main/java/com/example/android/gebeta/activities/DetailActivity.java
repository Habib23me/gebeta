package com.example.android.gebeta.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.android.gebeta.R;
import com.example.android.gebeta.dialog.OrderDialog;
import com.example.android.gebeta.fragment.OverviewFragment;

public class DetailActivity extends AppCompatActivity {

    private DetailActivity.SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private FloatingActionButton mOrderFab;

    public void showDialog(){

        OrderDialog orderDialog =new OrderDialog();

        orderDialog.show(getFragmentManager(),"name");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.detail_toolbar);
        final ImageView detailImg= (ImageView) findViewById(R.id.detail_img);
        AppBarLayout appBarLayout=(AppBarLayout) findViewById(R.id.appbar);
        mOrderFab=(FloatingActionButton) findViewById(R.id.fab_order);
        mOrderFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
        toolbar.inflateMenu(R.menu.menu_detail);
        setSupportActionBar(toolbar);
        Glide.with(this).load(R.drawable.pancakes).into(detailImg);


        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        mSectionsPagerAdapter = new DetailActivity.SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.detail_view_pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.detail_tabs);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return true;
    }
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // Return a PlaceholderFragment (defined as a static inner class below).
            switch (position){
                case 0:
                    return new OverviewFragment();
                case 1:
                    return new OverviewFragment();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 2;
        }
        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:
                    return "Overview";
                case 1:
                    return "Rating";
            }
            return null;
        }
    }
}
