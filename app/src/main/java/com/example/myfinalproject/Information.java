package com.example.myfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Information extends AppCompatActivity {

    private TextView hotelName;
    private TextView address;
    private TextView description;
    private ImageButton facebookButton;
    private Button contactButton;
    private Button rateButton;

    private LinearLayout linear;
    private ImageButton instagramButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_us);
        creation();

        // Create a fade-in animation


        contactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Information.this,contactUsActivity.class);
                startActivity(intent);
            }
        });
        rateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Information.this,RateUs.class);
                startActivity(intent);
            }
        });


    }

    public void creation() {
        hotelName = findViewById(R.id.name);
        address = findViewById(R.id.address);
        contactButton = findViewById(R.id.contactButton);
        description = findViewById(R.id.description);
        facebookButton = findViewById(R.id.facebook);
        instagramButton = findViewById(R.id.instagram);
        rateButton = findViewById(R.id.rateUs);

        linear=findViewById(R.id.linear);
        description.setMovementMethod(new ScrollingMovementMethod());
    }
    public void face(View view) {
        facebookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the Facebook URL
                String facebookUrl = "https://www.facebook.com";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(facebookUrl));
                startActivity(intent);
            }
        });
    }

    public void instagram(View view) {
        instagramButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the Instagram URL
                String instagramUrl = "https://www.instagram.com";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(instagramUrl));
                startActivity(intent);
            }
        });
    }
}
