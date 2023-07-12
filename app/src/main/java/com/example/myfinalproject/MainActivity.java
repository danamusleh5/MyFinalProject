package com.example.myfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {
    private FirebaseFirestore database = FirebaseFirestore.getInstance();
    private Button aboutUsButton;
    private Button logInButton;
    private Button cityButton;
    private Button registerButton;
    public static final String HI ="Hi";
    public static final String HELLO="Hello";
    private LinearLayout linearLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        creation();

        linearLayout = findViewById(R.id.linearlayout);

        Animation anim = AnimationUtils.loadAnimation(this, R.anim.slide_up);
        linearLayout.startAnimation(anim);



        aboutUsButton.setOnClickListener(new View.OnClickListener() {
         @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Information.class);
               startActivity(intent);

            }
        });


        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }

        });
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }

        });


        cityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, City.class);
                startActivity(intent);



            }

        });
    }



    public void creation() {

        aboutUsButton = findViewById(R.id.about_us);
        logInButton = findViewById(R.id.log_in);
       cityButton = findViewById(R.id.cities);
       registerButton = findViewById(R.id.rigester);



    }




}