package net.alhrairyalbraa.tasksscheduling;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import DatabaseHandler.Handler;

public class ShowActivity extends AppCompatActivity {

    TextView inf ;
    Handler handler;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        inf = findViewById(R.id.res);
        handler = new Handler(this);
        Intent intent = getIntent();
        int i = intent.getExtras().getInt("id");
        String [] info = handler.showTask(i);
        String res = "Id : " + info[0] +
                "\nTask Is " + info[1] +
                "\nDescription : " + info[2] +
                "\nStart : " + info[3] +
                "\nEnd : " + info[4];
        inf.setText(res);

    }
}