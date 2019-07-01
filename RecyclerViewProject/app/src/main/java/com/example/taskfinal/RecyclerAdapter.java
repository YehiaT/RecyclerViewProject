package com.example.taskfinal;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {
    private String TAG = "RecAdapter";
    private ArrayList<CardItem> cardList;
    private Context mContext;

    public RecyclerAdapter(ArrayList<CardItem> list, Context context) {
        cardList = list;
        mContext = context;

    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: started");
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        RecyclerViewHolder evh = new RecyclerViewHolder(v);


        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called");
        CardItem cardItem = cardList.get(position);
        holder.cardText.setText(cardItem.getArtText());
        if(cardItem.getArtImageUrl()!=null)
        Glide.with(mContext).load(cardItem.getArtImageUrl()).into(holder.cardImage);

        holder.cardText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(mContext,SecondPage.class);
                intent.putExtra("Text", MainActivity.articles.get(position).toString());
                intent.putExtra("url", MainActivity.articles.get(position).getUrlToImage());
                mContext.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: Started");
        if (cardList != null)
            return cardList.size();
        return 0;
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView cardText;
        ImageView cardImage;
        CardView cardView;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardView);
            cardText = itemView.findViewById(R.id.textView);
            cardImage = itemView.findViewById(R.id.cardImage);
            Log.d(TAG, "RecyclerViewHolder: Initiated");
        }
    }


}
