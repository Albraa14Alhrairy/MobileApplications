package com.example.ai;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class GPA extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpa);

        findViewById(R.id.back1).setOnClickListener(view -> finish());

        findViewById(R.id.sup_6).setOnClickListener(view -> {
            Intent i = new Intent(this, Degrees.class);
            startActivity(i);
        });

        findViewById(R.id.sup_7).setOnClickListener(view -> {
            Intent i = new Intent(this, GPA_2.class);
            startActivity(i);
        });
    }
}