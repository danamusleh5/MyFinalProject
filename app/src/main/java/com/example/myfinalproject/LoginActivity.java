package com.example.myfinalproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;


public class LoginActivity extends AppCompatActivity {
    private FirebaseFirestore database = FirebaseFirestore.getInstance();
    public static final String email = "email";
    public static final String PASS = "password";
    private EditText nameTxt;
    private EditText passTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acyivity_login);





    }

    public void login_button(View view) {

//        nameTxt.getText().toString();
//        passTxt.getText().toString();

        database.collection("register")
                .document()
                .get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {

                        String e = documentSnapshot.getString(email);
                        String p = documentSnapshot.getString(PASS);

                        String data = "email : " + e + "E-mail: " + p;
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                        Toast.makeText(LoginActivity.this, data, Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d("LoginActivity", e.toString());


                    }
                });
    }

        public void reg_button (View view) {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
            finish();

        }

}