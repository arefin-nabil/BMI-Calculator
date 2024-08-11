package com.example.bmitest;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageView male, female;
    Button continueButton;
    private String gender = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        continueButton = findViewById(R.id.continueButton);

        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sgender("Male");
            }
        });

        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sgender("Female");
            }
        });

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gender != null) {
                    Toast.makeText(MainActivity.this, gender + " Selected", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(MainActivity.this, NextActivity.class);
                    intent.putExtra("gender", gender);
                    startActivity(intent);
                }
            }
        });
    }

    private void sgender(String selectedGender) {
        this.gender = selectedGender;

        // Reset backgrounds
        male.setBackgroundColor(0xBDD1C5);
        female.setBackgroundColor(0xBDD1C5);

        // Set selected background
        if (selectedGender.equals("Male")) {
            male.setBackgroundColor(Color.GRAY); // Ash color
        } else {
            female.setBackgroundColor(Color.GRAY); // Ash color
        }

        // Enable the continue button
        continueButton.setEnabled(true);
    }


    @Override
    public void onBackPressed() {
        // Create an AlertDialog.Builder
        new AlertDialog.Builder(this)
                .setTitle("Exit")
                .setMessage("Are you sure you want to exit?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Exit the activity
                        MainActivity.super.onBackPressed();
                    }
                })
                .setNegativeButton("No", null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

}
