package net.alhrairyalbraa.tasksscheduling;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import DatabaseHandler.Handler;

public class DeleteActivity extends AppCompatActivity {

    EditText id;
    Handler handler;
    AlertDialog.Builder ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        id = findViewById(R.id.id);
        handler = new Handler(this);

        findViewById(R.id.del).setOnClickListener(view -> {
            String i = id.getText().toString();
            if (!i.isEmpty()) {
                int ii = Integer.parseInt(i);
                ad = new AlertDialog.Builder(this);
                ad.setTitle("You Want To Delete This Record");
                ad.setPositiveButton("Yes", (dialog, which) -> {
                    long d = handler.deleteTask(ii);
                    if (d > 0) {
                        Toast.makeText(this, "Task Successfully Deleted", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                    else Toast.makeText(this, "You Enter Wrong Id", Toast.LENGTH_SHORT).show();
                });
            ad.create().show();
            }else Toast.makeText(this, "Something Wrong!", Toast.LENGTH_SHORT).show();

        });
    }
}