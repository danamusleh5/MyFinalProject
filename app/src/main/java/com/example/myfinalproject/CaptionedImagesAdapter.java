        package com.example.myfinalproject;


import static android.widget.Toast.*;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class CaptionedImagesAdapter
        extends RecyclerView.Adapter<CaptionedImagesAdapter.ViewHolder> {


    private  RecyclerViewInterface recyclerViewInterface;
    private String[] captions;
    private int[] imageIds;

    public CaptionedImagesAdapter(String[] captions, int[] imageIds ,
                                  RecyclerViewInterface recyclerViewInterface) {
        this.captions = captions;
        this.imageIds = imageIds;
        this.recyclerViewInterface = recyclerViewInterface;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView v = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_captioned_image,
                parent,
                false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position ) {
        CardView cardView = holder.cardView;
        ImageView imageView = (ImageView) cardView.findViewById(R.id.image);
        Drawable dr = ContextCompat.getDrawable(cardView.getContext(), imageIds[position]);
        imageView.setImageDrawable(dr);
        TextView txt = (TextView) cardView.findViewById(R.id.txtName);
        txt.setText(captions[position]);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view ) {
                if(recyclerViewInterface !=null){
                    int pos = holder.getAdapterPosition();
                    if(pos != RecyclerView.NO_POSITION){
                        recyclerViewInterface.onItemClick(pos);


                    }
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return captions.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;

        public ViewHolder(CardView cardView) {
            super(cardView);
            this.cardView = cardView;
        }

    }



}
