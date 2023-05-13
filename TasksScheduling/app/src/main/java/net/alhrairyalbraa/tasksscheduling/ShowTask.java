package net.alhrairyalbraa.tasksscheduling;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import DatabaseHandler.Handler;

public class ShowTask extends AppCompatActivity {

    EditText id;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_task);

        id = findViewById(R.id.id);

        findViewById(R.id.del).setOnClickListener(view -> {
            String i = id.getText().toString();
            if (!i.isEmpty()) {
                int ii = Integer.parseInt(i);
                Intent intent = new Intent(this, ShowActivity.class);
                intent.putExtra("id", ii);
                startActivity(intent);
            }
            else
                Toast.makeText(this, "Something Wrong!", Toast.LENGTH_SHORT).show();

        });
    }
}