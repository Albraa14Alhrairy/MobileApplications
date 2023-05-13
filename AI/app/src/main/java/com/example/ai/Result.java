package com.example.ai;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Result extends AppCompatActivity {
    TextView result;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        result = findViewById(R.id.res);
        Intent data = getIntent();
        double gp = data.getExtras().getDouble("gpa");
        String gr = data.getExtras().getString("grade");

        result.setText("Your Gpa Is "+df.format(gp)+" And Your Grade Is "+gr);

        findViewById(R.id.back3).setOnClickListener(view -> finish());
    }
}