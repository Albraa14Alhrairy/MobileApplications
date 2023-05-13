package net.alhrairyalbraa.tasksscheduling;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import DatabaseHandler.Handler;

public class UpdateTask extends AppCompatActivity {

    EditText id, desc, start, end;
    Handler handler;
    AlertDialog.Builder ad;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_task);

        id = findViewById(R.id.name);
        desc = findViewById(R.id.desc);
        start = findViewById(R.id.start);
        end = findViewById(R.id.end);
        handler = new Handler(this);
        handler = new Handler(this);

        findViewById(R.id.add).setOnClickListener(view -> {
            String i = id.getText().toString();
            String d = desc.getText().toString();
            String s = start.getText().toString();
            String e = end.getText().toString();


            if (!i.isEmpty() && !d.isEmpty() && !s.isEmpty() && !e.isEmpty()) {
                ad = new AlertDialog.Builder(this);
                ad.setTitle("You Want To Update This Record");
                ad.setPositiveButton("Yes", (dialog, which) -> {
                    long done = handler.updateTask(Integer.parseInt(i), d, s, e);
                    if (done > 0) {
                        Toast.makeText(this, "Task Successfully Updated", Toast.LENGTH_SHORT).show();
                        finish();
                    } else
                        Toast.makeText(this, "ID Wrong!", Toast.LENGTH_SHORT).show();
                });
                ad.create().show();
            }
            else Toast.makeText(this, "Something Wrong!", Toast.LENGTH_SHORT).show();
        });
    }
}