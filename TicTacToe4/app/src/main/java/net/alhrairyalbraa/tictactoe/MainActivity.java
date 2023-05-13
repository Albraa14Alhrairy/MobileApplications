package net.alhrairyalbraa.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.o2o).setOnClickListener(view -> {
            Intent intent = new Intent(this, OneVsOne.class);
            startActivity(intent);
        });

        findViewById(R.id.o2ce).setOnClickListener(view -> {
            Intent intent = new Intent(this, OneVsComputerEasy.class);
            startActivity(intent);
        });

        findViewById(R.id.o2ch).setOnClickListener(view -> {
            Intent intent = new Intent(this, OneVsComputerHard.class);
            startActivity(intent);
        });
    }
}