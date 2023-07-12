package com.example.myfinalproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RateUs extends AppCompatActivity {

    private RatingBar ratingBar;
    private Button btnSubmit;
    private Button btncomment;
    private TextView commentlab;

    private String com;
    private int i;
    private EditText comment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rate_us);
        i=0;
        ratingBar = findViewById(R.id.ratingBar);
        btnSubmit = findViewById(R.id.btnSubmit);
        comment = findViewById(R.id.comment);
        commentlab = findViewById(R.id.commenttext);
        FirebaseApp.initializeApp(this); // Initialize Firebase

        btncomment = findViewById(R.id.btncomment);
        comment.setVisibility(View.INVISIBLE);
        btncomment.setVisibility(View.INVISIBLE);
        commentlab.setVisibility(View.INVISIBLE);

        comment.setMovementMethod(new ScrollingMovementMethod());
        ratingBar.setRating(5);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float rating = ratingBar.getRating();
                String t="";
                if (rating <= 2) {
                    comment.setVisibility(View.VISIBLE);
                    btncomment.setVisibility(View.VISIBLE);
                    commentlab.setVisibility(View.VISIBLE);

                }
                else {
                    sendFeedback(rating,t);
                }

            }
        });
        btncomment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float rating = ratingBar.getRating();

                String t ="Your Feedback";
                if (comment.getText() != null && comment.getText().toString() != t){
                    commentlab.setText("We will deal with your feedback and try to improve the program to satisfy you");
                    Toast.makeText(RateUs.this, "Thanks For Help Us", Toast.LENGTH_LONG).show();
                    com = comment.getText().toString();
                    comment.setText("Your Feedback");
                    //database saving
                    sendFeedback(rating ,com);
                }
            }
        });
    }
    private void sendFeedback(float rating,String com) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        Map<String, Object> feedback = new HashMap<>();

        feedback.put("rating", rating);
        feedback.put("messege", com);
        String ratename="rate num :"+i;
        db.collection("feedback")
                .document(ratename)
                .set(feedback)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        // Data saved successfully
                        i ++;
                        Toast.makeText(RateUs.this, "Data saved successfully", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        //Failed to save data
                        Toast.makeText(RateUs.this, "Failed to save data", Toast.LENGTH_SHORT).show();

                    }
                });
    }
}