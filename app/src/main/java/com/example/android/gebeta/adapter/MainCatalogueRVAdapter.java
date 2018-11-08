package com.example.android.gebeta.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.android.gebeta.R;
import com.example.android.gebeta.model.Food;

import java.util.ArrayList;
import java.util.List;

public class MainCatalogueRVAdapter extends RecyclerView.Adapter<MainCatalogueRVAdapter.MainCatalogueViewHolder> {
    private Context mContext;
    private List<Food> mFoodList;

    public void addFoodItem(Food foodItem) {
        mFoodList.add(foodItem);
    }

    public MainCatalogueRVAdapter(Context context) {

        mContext = context;
        mFoodList = new ArrayList<>();
    }

    @NonNull
    @Override
    public MainCatalogueViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext)
                            .inflate(R.layout.main_catalogue_rv_item,parent,false);


        return new MainCatalogueViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainCatalogueViewHolder holder, int position) {
            holder.mTextViewTitle.setText(mFoodList.get(position).getName());
            holder.mTextViewRating.setText(String.valueOf(mFoodList.get(position).getLikes()));
            holder.mTextViewReview.setText(String.valueOf(mFoodList.get(position).getReviews()));
            Glide.with(mContext).load(mFoodList.get(position).getImageResource()).into(holder.mImgThumbnail);

    }

    @Override
    public int getItemCount() {
        return mFoodList.size();
    }

    public class MainCatalogueViewHolder extends RecyclerView.ViewHolder{
        private ImageView mImgThumbnail;
        private TextView mTextViewTitle;
        private TextView mTextViewRating;
        private TextView mTextViewReview;

        public MainCatalogueViewHolder(View itemView) {
            super(itemView);
            mImgThumbnail= (ImageView) itemView.findViewById(R.id.thumbnail_main_catalgoue);
            mTextViewTitle= (TextView) itemView.findViewById(R.id.tv_title_main_catalogue);
            mTextViewRating=(TextView) itemView.findViewById(R.id.tv_rating_main_catalogue);
            mTextViewReview= (TextView) itemView.findViewById(R.id.tv_review_main_catalogue);
        }
    }
}
