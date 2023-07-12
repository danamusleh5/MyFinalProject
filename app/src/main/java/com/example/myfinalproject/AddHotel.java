package com.example.myfinalproject;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AddHotel extends AppCompatActivity {


    private FirebaseFirestore database = FirebaseFirestore.getInstance();
    public static final String name = "name";
    public static final String city = "city";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel);



        addnew();


    }




    private void addnew() {

        boolean booked =true;
        String city ="";
        String des="";
        String location="";
        String name="";
        int price=100;
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        Map<String, Object> hotel = new HashMap<>();

        hotel.put("booked", booked);
        hotel.put("city", city);
        hotel.put("description", des);
        hotel.put("location", location);
        hotel.put("name", name);
        hotel.put("price", price);
       // hotel.put("", image)

        final int[] i = {6};
        String hotelname="h"+ i[0];
        db.collection("hotels")
                .document(hotelname)
                .set(hotel)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        // Data saved successfully
                        i[0]++;
                        Toast.makeText(AddHotel.this, "HotelAdded", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        //Failed to save data
                        Toast.makeText(AddHotel.this, "Failed to add hotel", Toast.LENGTH_SHORT).show();

                    }
                });
    }
}
