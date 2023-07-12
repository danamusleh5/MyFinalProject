package com.example.myfinalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class contactUsActivity extends AppCompatActivity {
    private int i;
    private EditText editTextName;
    private EditText editTextEmail;
    private EditText editTextMessage;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_us);
        FirebaseApp.initializeApp(this); // Initialize Firebase

        creation();

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString().trim();
                String email = editTextEmail.getText().toString().trim();
                String message = editTextMessage.getText().toString().trim();

                if (name.isEmpty() || email.isEmpty() || message.isEmpty()) {
                    Toast.makeText(contactUsActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                } else {
                    contacing(name,email,message);
                    Toast.makeText(contactUsActivity.this, "Form submitted successfully", Toast.LENGTH_SHORT).show();
                    editTextName.getText().clear();
                    editTextEmail.getText().clear();
                    editTextMessage.getText().clear();
                }
            }
        });
    }
    private void contacing(String  name,String mail,String com) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        Map<String, Object> contactUs = new HashMap<>();

        contactUs.put("name",name);
        contactUs.put("email",mail);

        contactUs.put("messege", com);
        String documentName = "contact num :" +i;

        db.collection("contactUs")
                .document(documentName)
                .set(contactUs)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        // Data saved successfully
                        i ++;
                        Toast.makeText(contactUsActivity.this, "Data saved successfully", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        //Failed to save data
                        Toast.makeText(contactUsActivity.this, "Failed to save data", Toast.LENGTH_SHORT).show();

                    }
                });
    }
    public void creation() {
        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextMessage = findViewById(R.id.editTextMessage);
        buttonSubmit = findViewById(R.id.buttonSubmit);
    }
}