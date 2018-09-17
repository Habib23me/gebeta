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
import com.example.android.gebeta.data.Food;

import java.util.ArrayList;
import java.util.List;

public class MainCatagoryRVAdapter extends RecyclerView.Adapter<MainCatagoryRVAdapter.MainCatagoryViewHolder>{

    private List<Food> mFoodList;
    private Context mContext;


    public MainCatagoryRVAdapter(Context context) {
        mFoodList=new ArrayList<>();
        mContext = context;
    }
    public void addFoodItem(Food foodItem){
        mFoodList.add(foodItem);
    }


    @NonNull
    @Override
    public MainCatagoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(mContext).inflate(R.layout.main_catagory_rv_item,parent,false);
        return new MainCatagoryViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MainCatagoryViewHolder holder, int position) {
            holder.mTextViewTitle.setText(mFoodList.get(position).getName());
            holder.mTextViewDescription.setText(String.valueOf(mFoodList.get(position).getPrice()));
            holder.mTextViewLikes.setText(String.valueOf(mFoodList.get(position).getLikes()));
            holder.mTextViewReviews.setText(String.valueOf(mFoodList.get(position).getReviews()));
        Glide.with(mContext).load(mFoodList.get(position).getImageResource()).into(holder.mFoodThumbnail);


    }

    @Override
    public int getItemCount() {
        return mFoodList.size();
    }

    class MainCatagoryViewHolder extends RecyclerView.ViewHolder{
        private TextView mTextViewTitle;
        private TextView mTextViewDescription;
        private TextView mTextViewLikes;
        private TextView mTextViewReviews;
        private ImageView mFoodThumbnail;

        public MainCatagoryViewHolder(View itemView) {
            super(itemView);
            mTextViewTitle=(TextView) itemView.findViewById(R.id.tv_food_name);
            mTextViewDescription=(TextView) itemView.findViewById(R.id.tv_description);
            mTextViewLikes=(TextView) itemView.findViewById(R.id.likes_tv);
            mTextViewReviews=(TextView) itemView.findViewById(R.id.reviews_tv);
            mFoodThumbnail=(ImageView) itemView.findViewById(R.id.img_thumb);

        }
    }

}
