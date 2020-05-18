package com.example.smarteduvid;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView mImageView;
        TextView mTitle,mDescription;
        ItemClickListener itemClickListener;

     MyHolder(@NonNull View itemView) {
        super(itemView);

        this.mImageView = itemView.findViewById(R.id.imageIv);
        this.mTitle = itemView.findViewById(R.id.titleTv);
        this.mDescription = itemView.findViewById(R.id.descriptionTv);


        itemView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

         this.itemClickListener.onItemClickListener(v,getLayoutPosition());
    }

    public void setItemClickListener(ItemClickListener ic){

         this.itemClickListener = ic;


    }

}
