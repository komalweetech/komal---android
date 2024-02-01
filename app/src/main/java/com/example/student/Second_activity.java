package com.example.student;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class Second_activity extends AppCompatActivity {
    private static final String PREF_NAME = "UserData";
    private static final String name_key = "name";
    private static final String surname_key = "surname";
    private static final String email_key = "email";
    private static final String number_key = "number";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView textViewName = findViewById(R.id.textViewName);
        TextView textViewSurname = findViewById(R.id.textViewSurname);
        TextView textViewEmail = findViewById(R.id.textViewEmail);
        TextView textViewNumber = findViewById(R.id.textViewNumber);

        // Retrieve data from SharedPreferences
        SharedPreferences preferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        String savedName = preferences.getString(name_key, "");
        String savedSurname = preferences.getString(surname_key, "");
        String savedEmail = preferences.getString(email_key, "");
        String savedPhone = preferences.getString(number_key, "");

      textViewName.setText("Name : " +savedName);
      textViewSurname.setText("SurName : " +savedSurname);
      textViewEmail.setText("Email : " + savedEmail);
      textViewNumber.setText("Number : " + savedPhone);
    }
}