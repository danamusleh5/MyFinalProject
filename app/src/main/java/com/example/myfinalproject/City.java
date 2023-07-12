        package com.example.myfinalproject;

import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.OnClickAction;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
public class City extends AppCompatActivity  implements RecyclerViewInterface {

    //Cities[] captions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.city);

        RecyclerView recycler = findViewById(R.id.city_recycler);

        String[] captions = new String[Cities.cities.length];
        int[] ids = new int[Cities.cities.length];


        for (int i = 0; i < captions.length; i++) {
            captions[i] = Cities.cities[i].getName() ;
            ids[i] = Cities.cities[i].getImageID();

        }


        recycler.setLayoutManager(new LinearLayoutManager(this));

        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(captions, ids, this);
        recycler.setAdapter(adapter);

    }


    @Override
    public void onItemClick(int position) {

        Intent intent = new Intent(City.this, Hotel.class);
        startActivity(intent);
//        if (position == 0 ){
//            intent.putExtra("name",captions[0].getName());
//        }

    }
}
