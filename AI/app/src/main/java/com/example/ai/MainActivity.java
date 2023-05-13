package com.example.ai;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.yes).setOnClickListener(view -> {
            Intent i = new Intent(this, information.class);
            startActivity(i);
        });

        findViewById(R.id.no).setOnClickListener(view -> {
            Intent i = new Intent(this, MainActivity3.class);
            startActivity(i);
        });

    }

}