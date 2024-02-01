package com.example.student;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    //Shared Preference
    private static final String PREF_NAME = "UserData";
    private static final String name_key = "name";
    private static final String surname_key = "surname";
    private static final String email_key = "email";
    private static final String number_key = "number";

    private EditText etName, etSurname, etEmail, etPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.appBar);
        setSupportActionBar(toolbar);

        etName = findViewById(R.id.editTextName);
        etSurname = findViewById(R.id.editTextSurname);
        etEmail = findViewById(R.id.editTextEmail);
        etPhone = findViewById(R.id.editTextPhone);

        Button saveButton = findViewById(R.id.btnSave);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveUserData();
                openSecondScreen();
            }
        });

    }
    private void saveUserData() {

        SharedPreferences preferences = getSharedPreferences(PREF_NAME,MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putString(name_key, etName.getText().toString());
        editor.putString(surname_key, etSurname.getText().toString());
        editor.putString(email_key, etEmail.getText().toString());
        editor.putString(number_key, etPhone.getText().toString());

        editor.apply();
        Toast.makeText(this, "Data saved successfully!", Toast.LENGTH_SHORT).show();
    }

    private void openSecondScreen() {
        long delaySecond = 3000;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity.this, Second_activity.class));
            }
        },delaySecond);

    }
}