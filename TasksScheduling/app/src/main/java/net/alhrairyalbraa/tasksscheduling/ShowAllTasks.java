package net.alhrairyalbraa.tasksscheduling;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import java.util.ArrayList;

import DatabaseHandler.Handler;
import DatabaseHandler.Tasks;
import RecyclerView.MyAdapter;

public class ShowAllTasks extends AppCompatActivity {

    RecyclerView rv;
    Handler handler;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_tasks);

        rv = findViewById(R.id.rv);
        handler = new Handler(this);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setHasFixedSize(true);

        ArrayList<Tasks> tasks = (ArrayList<Tasks>) handler.showAllTasks();

        RecyclerView.Adapter adapter = new MyAdapter(this, tasks);
        rv.setAdapter(adapter);
    }
}