package com.example.android.gebeta.fragment;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.gebeta.R;
import com.example.android.gebeta.adapter.MainCatalogueVPAdapter;
import com.example.android.gebeta.adapter.MainCatalogueRVAdapter;
import com.example.android.gebeta.model.CardItem;
import com.example.android.gebeta.model.Food;
import com.example.android.gebeta.utils.ShadowTransformer;



public class MainCatalogue extends Fragment {

    //Viewpager Section
    private ViewPager mViewPager;
    private MainCatalogueVPAdapter mCardAdapter;
    private ShadowTransformer mCardShadowTransformer;

    //RecyclerView Section
    private RecyclerView mRecyclerView;
    private View mParentView;
    private MainCatalogueRVAdapter mRecyclerViewAdapter;



    public MainCatalogue() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        mParentView= inflater.inflate(R.layout.fragment_main_catalague, container, false);
        // View pager section
        bindAdapterToViewPager();
        initializeViewPagerData();

        // Recycler View section
        mRecyclerView = (RecyclerView) mParentView.findViewById(R.id.rv_main_catalogue);
        mRecyclerViewAdapter = new MainCatalogueRVAdapter(getContext());
        initializeRecyclerViewData();
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        return mParentView;
    }



    private  void initializeRecyclerViewData(){
        String titlesText []=getResources().getStringArray(R.array.viewpager_title);
        TypedArray foodImageResource= getResources().obtainTypedArray(R.array.food_image_pager);
        //Bind viewpager data
        for (int i=0; i<titlesText.length; i++){
            mRecyclerViewAdapter.addFoodItem(new Food(titlesText[i], 10,200,120, foodImageResource.getResourceId(i,0)));
        }
        mRecyclerViewAdapter.notifyDataSetChanged();
    }

    private void initializeViewPagerData(){
        //Initialize viewpager data
        String titlesText []=getResources().getStringArray(R.array.viewpager_title);
        String  detailsArray []=getResources().getStringArray(R.array.viewpager_body);
        TypedArray foodImageResource= getResources().obtainTypedArray(R.array.food_image_pager);
        //Bind viewpager data
        for (int i=0; i<titlesText.length; i++){
            mCardAdapter.addCardItemS(new CardItem( titlesText[i], detailsArray[i],foodImageResource.getResourceId(i,0)));
        }
        mCardAdapter.notifyDataSetChanged();

    }
    private void bindAdapterToViewPager(){
        mViewPager = (ViewPager)mParentView.findViewById(R.id.viewPager);
        mCardAdapter = new MainCatalogueVPAdapter(getContext());
        mCardShadowTransformer = new ShadowTransformer(mViewPager, mCardAdapter);
        mViewPager.setAdapter(mCardAdapter);
        mViewPager.setPageTransformer(false, mCardShadowTransformer);
        mViewPager.setOffscreenPageLimit(3);


    }


}



