package com.example.myfinalproject;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.UUID;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.model.Document;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;



public class RegisterActivity extends AppCompatActivity {
   // FirebaseDatabase database = FirebaseDatabase.getInstance();
    private FirebaseFirestore database = FirebaseFirestore.getInstance();


    EditText name_txt;

    EditText email_txt;
    EditText number_txt;
    EditText password;
    EditText confirm_Password;

    Button registration_btn;
    Button login_btn;
    boolean isAllChecked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

          setupViews();

    }

    private void setupViews() {
        name_txt = findViewById(R.id.txtName);
        confirm_Password = findViewById(R.id.txtConfirm);
        email_txt = findViewById(R.id.txtemail);
        password = findViewById(R.id.txtPassword);
        number_txt = findViewById(R.id.txtNumber);

        registration_btn = findViewById(R.id.register_button);
        login_btn = findViewById(R.id.login_button);

       // String[] genderChoice = {"Select Your Gender", "Female", "Male"};

      //  ArrayAdapter<String> gender = new ArrayAdapter<>(this, R.layout.spinner_item, genderChoice);
       // gender_spn.setAdapter(gender);


        registration_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                isAllChecked = checkInformation();

                if (isAllChecked) {
                    writeToDatabase();
                }

            }
        });

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }


    boolean isEmail(EditText text) {
        CharSequence email_txt = text.getText().toString();
        return (!TextUtils.isEmpty(email_txt) && Patterns.EMAIL_ADDRESS.matcher(email_txt).matches());
    }


    private boolean checkInformation() {

        if (name_txt.getText().toString().isEmpty()) {
           name_txt.setError("First Name is Required");
            return false;
        }

//        if (lastname_txt.getText().toString().isEmpty()) {
//            lastname_txt.setError("Last Name is Required");
//            return false;
//        }

        if (email_txt.getText().toString().isEmpty()) {
            email_txt.setError("Email is Required");
            return false;
        } else if (!isEmail(email_txt)) {
            email_txt.setError("Please Enter a Valid Username!");
            return false;
        }

        if (number_txt.getText().toString().isEmpty()) {
            number_txt.setError("Phone Number is Required");
            return false;
        }

        if (password.getText().toString().isEmpty() || password.length() < 6) {
            password.setError("Please Enter a Password With at Least 6 Characters");
            return false;
        }

        return true;
    }


    private void writeToDatabase() {
      //  String uuid = UUID.randomUUID().toString();
        Map<String, Object> user = new HashMap<>();
        user.put("firstName", name_txt.getText().toString());
       // user.put("gender", gender_spn.getSelectedItem().toString());
        user.put("email", email_txt.getText().toString());
        user.put("password", password.getText().toString());
        user.put("phoneNumber", number_txt.getText().toString());




        database.collection("register")
                .document()
                .set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(RegisterActivity.this, " successfully Registration", Toast.LENGTH_SHORT).show();

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(RegisterActivity.this, "Error in Registration", Toast.LENGTH_SHORT).show();
                        Log.d("MainActivity",e.toString());
                    }
                });


        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}