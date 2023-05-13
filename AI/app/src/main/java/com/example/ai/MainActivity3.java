package com.example.ai;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity3 extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        findViewById(R.id.back2).setOnClickListener(view -> finish());

        findViewById(R.id.wek).setOnClickListener(view -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://ar.wikipedia.org/wiki/%D9%83%D9%84%D9%8A%D8%A9_%D8%A7%D9%84%D8%B0%D9%83%D8%A7%D8%A1_%D8%A7%D9%84%D8%A7%D8%B5%D8%B7%D9%86%D8%A7%D8%B9%D9%8A_(%D8%AC%D8%A7%D9%85%D8%B9%D8%A9_%D9%83%D9%81%D8%B1_%D8%A7%D9%84%D8%B4%D9%8A%D8%AE)"));
            startActivity(i);
        });

        findViewById(R.id.fac).setOnClickListener(view -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://www.facebook.com/KFS.AI.un"));
            startActivity(i);
        });

        findViewById(R.id.g).setOnClickListener(view -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://kfs.edu.eg/ai/pdf/1010201911443641.pdf"));
            startActivity(i);
        });

        findViewById(R.id.web).setOnClickListener(view -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://kfs.edu.eg/en_ai/"));
            startActivity(i);
        });

        findViewById(R.id.youtube).setOnClickListener(view -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://www.youtube.com/channel/UCX_gPhvczpcRzfwHqIq4-iA"));
            startActivity(i);
        });

        findViewById(R.id.bio).setOnClickListener(view -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://kfs.edu.eg/en_ai/display.aspx?topic=88684"));
            startActivity(i);
        });
    }
}