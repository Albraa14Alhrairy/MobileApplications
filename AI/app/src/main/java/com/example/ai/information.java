package com.example.ai;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class information extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        findViewById(R.id.Subjects).setOnClickListener(view -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://itexam.kfs.edu.eg/AI_EBooks_Exams/Default/Login"));
            startActivity(i);
        });

        findViewById(R.id.Gied).setOnClickListener(view -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://kfs.edu.eg/ai/pdf/1010201911443641.pdf"));
            startActivity(i);
        });

        findViewById(R.id.wepsite).setOnClickListener(view -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://kfs.edu.eg/ai/"));
            startActivity(i);
        });

        findViewById(R.id.GPA).setOnClickListener(view -> {
            Intent i = new Intent(this, GPA.class);
            startActivity(i);
        });

        findViewById(R.id.hou).setOnClickListener(view -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("http://mis.kfs.edu.eg/CreditHours_Reg/"));
            startActivity(i);
        });

        findViewById(R.id.mail).setOnClickListener(view -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("http://mis.kfs.edu.eg/getmail/"));
            startActivity(i);
        });

        findViewById(R.id.pay).setOnClickListener(view -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://payments.kfs.edu.eg/"));
            startActivity(i);
        });

        findViewById(R.id.result).setOnClickListener(view -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("http://mis.kfs.edu.eg/newresult/stud_credithours.aspx"));
            startActivity(i);
        });

        findViewById(R.id.back).setOnClickListener(view -> finish());
    }
}