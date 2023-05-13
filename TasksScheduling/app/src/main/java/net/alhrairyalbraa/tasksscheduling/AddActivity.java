package net.alhrairyalbraa.tasksscheduling;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import DatabaseHandler.Handler;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {

    EditText name, desc, start, end;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        name = findViewById(R.id.name);
        desc = findViewById(R.id.desc);
        start = findViewById(R.id.start);
        end = findViewById(R.id.end);
        handler = new Handler(this);

        findViewById(R.id.add).setOnClickListener(view ->  {
            String n = name.getText().toString();
            String d = desc.getText().toString();
            String s = start.getText().toString();
            String e = end.getText().toString();

            if (!n.isEmpty() && !d.isEmpty() && !s.isEmpty() && !e.isEmpty()){
                long id = handler.insertTask(n, d, s, e);
                if (id > 0) {
                    Toast.makeText(this, "Task Successfully Added And Its Id Is " + id, Toast.LENGTH_SHORT).show();
                    finish();
                }
                else
                    Toast.makeText(this, "Something Wrong!", Toast.LENGTH_SHORT).show();
            }else Toast.makeText(this, "Something Wrong!", Toast.LENGTH_SHORT).show();
        });
    }
}