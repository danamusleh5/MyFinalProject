package com.example.myfinalproject;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class HotelInformation extends AppCompatActivity {
    String name;
    String city;
    public HotelInformation(String name, String city) {
        this.name=name;
        this.city=city;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FirebaseApp.initializeApp(this); // Initialize Firebase

        super.onCreate(savedInstanceState);
    }
//    public void getNames(){
//        FirebaseFirestore db = FirebaseFirestore.getInstance();
//
//        db.collection("hotels")
//                .get()
//                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                    @Override
//                    public void onSuccess(DocumentSnapshot documentSnapshot) {
////                           ?    }
//                    }
//                }}
}