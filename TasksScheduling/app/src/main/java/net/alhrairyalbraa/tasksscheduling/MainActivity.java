package net.alhrairyalbraa.tasksscheduling;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import DatabaseHandler.Handler;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup rg;
    RadioButton rb;
    Handler handler;
    AlertDialog.Builder ad;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg = findViewById(R.id.radioGroup);

        rg.setOnCheckedChangeListener((group, id) -> {
            rb = findViewById(id);

            if (rb.getId() == R.id.addTask) {
                findViewById(R.id.ok).setOnClickListener(view -> {
                    Intent intent = new Intent(this, AddActivity.class);
                    startActivity(intent);
                });
            }
            else if (rb.getId() == R.id.delete) {
                findViewById(R.id.ok).setOnClickListener(view -> {
                    Intent intent = new Intent(this, DeleteActivity.class);
                    startActivity(intent);
                });
            }
            else if (rb.getId() == R.id.deleteAll) {
                findViewById(R.id.ok).setOnClickListener(view -> {
                    ad = new AlertDialog.Builder(this);
                    ad.setTitle("You Want To Delete All Tasks!");
                    ad.setPositiveButton("Yes", (dialog, which) -> {
                        handler = new Handler(this);
                        long done = handler.deleteAll();
                        if (done > 0)
                            Toast.makeText(this, "All Tasks Are Deleted", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                    });
                    ad.create().show();
                });
            }
            else if (rb.getId() == R.id.showAll) {
                findViewById(R.id.ok).setOnClickListener(view -> {
                    Intent intent = new Intent(this, ShowAllTasks.class);
                    startActivity(intent);
                });
            }
            else if (rb.getId() == R.id.showTask) {
                findViewById(R.id.ok).setOnClickListener(view -> {
                    Intent intent = new Intent(this, ShowTask.class);
                    startActivity(intent);
                });
            }
            else if (rb.getId() == R.id.update) {
                findViewById(R.id.ok).setOnClickListener(view -> {
                    Intent intent = new Intent(this, UpdateTask.class);
                    startActivity(intent);
                });
            }
        });
    }
}