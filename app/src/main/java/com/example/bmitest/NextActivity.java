package com.example.bmitest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NextActivity extends AppCompatActivity {

    EditText edage, edweight, edheight;
    ImageView ageplus, ageminus, weightplus, weightminus, heightplus, heightminus;
    Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        edage = findViewById(R.id.edage);
        edweight = findViewById(R.id.edweight);
        edheight = findViewById(R.id.edheight);
        ageplus = findViewById(R.id.ageplus);
        ageminus = findViewById(R.id.ageminus);
        weightplus = findViewById(R.id.weightplus);
        weightminus = findViewById(R.id.weightminus);
        heightplus = findViewById(R.id.heightplus);
        heightminus = findViewById(R.id.heightminus);
        calculateButton = findViewById(R.id.calculateButton);


        // Set click listeners for plus and minus buttons
        ageplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateValue(edage, 1);
            }
        });

        ageminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateValue(edage, -1);
            }
        });

        weightplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateValue(edweight, 1);
            }
        });

        weightminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateValue(edweight, -1);
            }
        });

        heightplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateValue(edheight, 1);
            }
        });

        heightminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateValue(edheight, -1);
            }
        });

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get user input values
                String age = edage.getText().toString();
                String weight = edweight.getText().toString();
                String height = edheight.getText().toString();

                // Create an Intent to start ResultActivity
                Intent intent = new Intent(NextActivity.this, ResultActivity.class);

                // Put the data into the Intent
                intent.putExtra("age", age);
                intent.putExtra("weight", weight);
                intent.putExtra("height", height);

                // Start ResultActivity
                startActivity(intent);

                edage.setText("");
                edweight.setText("");
                edheight.setText("");
            }
        });
    }

    // Method to increment or decrement the value in the EditText
    private void updateValue(EditText editText, int increment) {
        try {
            int currentValue = Integer.parseInt(editText.getText().toString());
            currentValue += increment;

            // Ensure value doesn't go below zero
            if (currentValue < 0) {
                currentValue = 0;
            }

            editText.setText(String.valueOf(currentValue));
        } catch (NumberFormatException e) {
            // If the EditText is empty or contains non-integer data, set it to 0
            editText.setText("0");
        }

    }
}