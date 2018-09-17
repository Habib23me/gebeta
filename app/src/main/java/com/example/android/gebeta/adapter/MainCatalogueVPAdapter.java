package com.example.android.gebeta.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.android.gebeta.R;
import com.example.android.gebeta.data.CardItem;

import java.util.ArrayList;
import java.util.List;


public class MainCatalogueVPAdapter extends PagerAdapter {
    public final static int MAX_ELEVATION_FACTOR = 8;

    private float mBaseElevation;
    private List<CardItem> mCardItems;
    private List<CardView> mCardViews;
    private Context mContext;

    public MainCatalogueVPAdapter(Context context) {
        mCardItems = new ArrayList<>();
        mCardViews = new ArrayList<>();
        mContext = context;
    }
    public void addCardItemS(CardItem cardItem){
        mCardViews.add(null);
        mCardItems.add(cardItem);
    }



    public float getBaseElevation() {
        return mBaseElevation;
    }
    public CardView getCardViewAt(int position) {
        return mCardViews.get(position);
    }

    @Override
    public int getCount() {
        return mCardItems.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        //inflate view and add to container
        View layoutView= LayoutInflater.from(mContext)
                .inflate(R.layout.main_catalogue_pager_item, container, false);
        container.addView(layoutView);

        // bind views
        bindView(mCardItems.get(position),layoutView);

        //instantiate cardView and add to mCardViews list
        CardView cardView= layoutView.findViewById(R.id.card_view_pager);
        mCardViews.set(position,cardView);

        //make shadow
        makeShadow(cardView);

        return layoutView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
        mCardViews.set(position,null);
    }

    private void bindView(CardItem cardItem, View view){
        TextView textViewTitle= view.findViewById(R.id.titleTextView);
        TextView textViewBody= view.findViewById(R.id.contentTextView);
        ImageView imageViewPager= view.findViewById(R.id.image_view_pager);


        textViewTitle.setText(cardItem.getTitle());
        textViewBody.setText(cardItem.getText());
        Glide.with(mContext).load(cardItem.getImageResource()).into(imageViewPager);
    }
    private void makeShadow(CardView cardView){
        if(mBaseElevation==0){
            mBaseElevation=cardView.getCardElevation();
        }
        cardView.setMaxCardElevation(mBaseElevation*MAX_ELEVATION_FACTOR);
    }

}