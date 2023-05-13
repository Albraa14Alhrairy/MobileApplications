package net.alhrairyalbraa.tictactoe;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class OneVsComputerEasy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_vs_computer_easy);
    }

    public void select(View view) {
        Button buCh = (Button) view;
        int ch = 0;
        int i = buCh.getId();

        if (i == R.id.bu1)
            ch = 1;
        else if (i == R.id.bu2)
            ch = 2;
        else if (i == R.id.bu3)
            ch = 3;
        else if (i == R.id.bu4)
            ch = 4;
        else if (i == R.id.bu5)
            ch = 5;
        else if (i == R.id.bu6)
            ch = 6;
        else if (i == R.id.bu7)
            ch = 7;
        else if (i == R.id.bu8)
            ch = 8;
        else if (i == R.id.bu9)
            ch = 9;

//        Toast.makeText(this, "id : " + ch, Toast.LENGTH_SHORT).show();
        game(ch, buCh);
    }

    ArrayList<Integer> player1 = new ArrayList<>();
    ArrayList<Integer> player2 = new ArrayList<>();
    int clicks = 0;

    @SuppressLint("ResourceAsColor")
    public void game(int ch, Button buCh) {

        buCh.setText("X");
        buCh.setBackgroundColor(R.color.red);
        player1.add(ch);
        clicks++;
        buCh.setEnabled(false);

        String winner = checkWinner();

        if (winner != null) {
            Toast.makeText(this, "The Winner Is " + winner, Toast.LENGTH_LONG).show();
            finish();
        }
        else if (clicks == 9) {
            Toast.makeText(this, "Draw", Toast.LENGTH_LONG).show();
            finish();
        }
        else {
            autoPlay();
            clicks++;
            String winnerr = checkWinner();
            if (winnerr != null) {
                Toast.makeText(this, "The Winner Is " + winnerr, Toast.LENGTH_LONG).show();
                finish();
            }
        }

    }

    public String checkWinner() {
        String winner = null;

        if ((player2.contains(1) && player2.contains(2) && player2.contains(3)))
            winner = "Computer";
        else if ((player2.contains(4) && player2.contains(5) && player2.contains(6)))
            winner = "Computer";
        else if ((player2.contains(7) && player2.contains(8) && player2.contains(9)))
            winner = "Computer";
        else if ((player2.contains(1) && player2.contains(4) && player2.contains(7)))
            winner = "Computer";
        else if ((player2.contains(2) && player2.contains(5) && player2.contains(8)))
            winner = "Computer";
        else if ((player2.contains(3) && player2.contains(6) && player2.contains(9)))
            winner = "Computer";
        else if ((player2.contains(1) && player2.contains(5) && player2.contains(9)))
            winner = "Computer";
        else if ((player2.contains(3) && player2.contains(5) && player2.contains(7)))
            winner = "Computer";

        else if ((player1.contains(1) && player1.contains(2) && player1.contains(3)))
            winner = "Player 1";
        else if ((player1.contains(4) && player1.contains(5) && player1.contains(6)))
            winner = "Player 1";
        else if ((player1.contains(7) && player1.contains(8) && player1.contains(9)))
            winner = "Player 1";
        else if ((player1.contains(1) && player1.contains(4) && player1.contains(7)))
            winner = "Player 1";
        else if ((player1.contains(2) && player1.contains(5) && player1.contains(8)))
            winner = "Player 1";
        else if ((player1.contains(3) && player1.contains(6) && player1.contains(9)))
            winner = "Player 1";
        else if ((player1.contains(1) && player1.contains(5) && player1.contains(9)))
            winner = "Player 1";
        else if ((player1.contains(3) && player1.contains(5) && player1.contains(7)))
            winner = "Player 1";

        return winner;
    }

    @SuppressLint("ResourceAsColor")
    public void autoPlay() {
        ArrayList<Integer> emptyCells = new ArrayList<>();

        for (int i=1; i<10; i++)
            if (!player1.contains(i) && !player2.contains(i))
                emptyCells.add(i);

        Random random = new Random();
        int ran = random.nextInt(emptyCells.size());
        int ch = emptyCells.get(ran);
        Button buCh = null;

        switch (ch){
            case 1:
                buCh = findViewById(R.id.bu1);
                break;
            case 2:
                buCh = findViewById(R.id.bu2);
                break;
            case 3:
                buCh = findViewById(R.id.bu3);
                break;
            case 4:
                buCh = findViewById(R.id.bu4);
                break;
            case 5:
                buCh = findViewById(R.id.bu5);
                break;
            case 6:
                buCh = findViewById(R.id.bu6);
                break;
            case 7:
                buCh = findViewById(R.id.bu7);
                break;
            case 8:
                buCh = findViewById(R.id.bu8);
                break;
            case 9:
                buCh = findViewById(R.id.bu9);
                break;
        }

        assert buCh != null;
        buCh.setText("O");
        buCh.setBackgroundColor(R.color.blue);
        player2.add(ch);
        buCh.setEnabled(false);
    }

}