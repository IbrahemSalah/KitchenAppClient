package com.example.android.kitchenappclient;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by Eng_I on 12/27/2017.
 */

public class FoodViewHolder extends RecyclerView.ViewHolder {
    View mView;
    public FoodViewHolder(View itemView) {
        super(itemView);

        mView = itemView;
    }


    public void setName(String Name){
        TextView foodName = (TextView)mView.findViewById(R.id.foodName);
        foodName.setText(Name);
    }

    public void setPrice(String Price){
        TextView foodPrice = (TextView)mView.findViewById(R.id.foodDesc);
        foodPrice.setText(Price);
    }

    public void setDesc(String Desc){
        TextView foodDesc = (TextView)mView.findViewById(R.id.foodDesc);
        foodDesc.setText(Desc);
    }

    public void setImage(Context context, String Image){
        ImageView foodImage= (ImageView)mView.findViewById(R.id.foodImage);
        Picasso.with(context).load(Image).into(foodImage);
    }
}
