package com.example.android.gebeta.fragment;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.gebeta.R;
import com.example.android.gebeta.adapter.MainCatagoryRVAdapter;
import com.example.android.gebeta.model.Food;

public class MainCategory extends Fragment {
    private RecyclerView mRecyclerView;
    private MainCatagoryRVAdapter mMainCatagoryRVAdapter;
    private View mParentView;
    public MainCategory() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

     mParentView= inflater.inflate(R.layout.fragment_main_category, container, false);
     mRecyclerView= mParentView.findViewById(R.id.rv_main_catagory);
     mMainCatagoryRVAdapter= new MainCatagoryRVAdapter(getContext());
     initializeRecyclerViewData();
     mRecyclerView.setAdapter(mMainCatagoryRVAdapter);
     mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
     return  mParentView;
    }
    private  void initializeRecyclerViewData(){
        String titlesText []=getResources().getStringArray(R.array.viewpager_title);
        TypedArray foodImageResource= getResources().obtainTypedArray(R.array.food_image_pager);
        //Bind viewpager data
        for (int i=0; i<titlesText.length; i++){
            mMainCatagoryRVAdapter.addFoodItem(new Food(titlesText[i], 10,200,120, foodImageResource.getResourceId(i,0)));
        }
        foodImageResource.recycle();
        mMainCatagoryRVAdapter.notifyDataSetChanged();
    }


}
