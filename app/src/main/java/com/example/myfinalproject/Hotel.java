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

public class Hotel extends AppCompatActivity {
   // private FirebaseFirestore database = FirebaseFirestore.getInstance();
    public static final String name = "name";
    public static final String city = "city";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel);



//        database.collection("hotels")
//                .document("h1")
//                .get()
//                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                    @Override
//                    public void onSuccess(DocumentSnapshot documentSnapshot) {
//
//                        String n = documentSnapshot.getString(name);
//                        String c = documentSnapshot.getString(city);
//
//                      //  if (c.equals("nablus")){
//                            String data = "Name : " + n + "City : " + c;
//                            Toast.makeText(Hotel.this, data, Toast.LENGTH_SHORT).show();
//
//                       // }
//
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Log.d("Hotel" , e.toString());
//
//
//                    }
//                });






    }




}
