package com.example.myfinalproject;



 import androidx.appcompat.app.AppCompatActivity;

 import android.content.Intent;
 import android.os.Bundle;
 import android.os.Handler;
 import android.view.WindowManager;
 import android.view.animation.Animation;
 import android.view.animation.AnimationUtils;
 import android.widget.ImageView;
 import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {
    private Animation top, bottom;
    private TextView txt;
    private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_splash);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        top = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottom = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        txt = findViewById(R.id.txt);
        img = findViewById(R.id.img);

        txt.setAnimation(bottom);
        img.setAnimation(top);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 5000);
    }
}



