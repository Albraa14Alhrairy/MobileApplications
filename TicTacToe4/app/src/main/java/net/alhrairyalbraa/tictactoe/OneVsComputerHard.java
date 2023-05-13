package net.alhrairyalbraa.tictactoe;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class OneVsComputerHard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_vs_computer_hard);
    }

    static class Move {
        public int row;
        public int column;
    }

    public void select(View view) {
        Button buCh = (Button) view;
        int row = -1, col = -1;
        int i = buCh.getId();

        if (i == R.id.bu1) {
            row = 0;
            col = 0;
        }
        else if (i == R.id.bu2){
            row = 0;
            col = 1;
        }
        else if (i == R.id.bu3){
            row = 0;
            col = 2;
        }
        else if (i == R.id.bu4){
            row = 1;
            col = 0;
        }
        else if (i == R.id.bu5){
            row = 1;
            col = 1;
        }
        else if (i == R.id.bu6){
            row = 1;
            col = 2;
        }
        else if (i == R.id.bu7){
            row = 2;
            col = 0;
        }
        else if (i == R.id.bu8){
            row = 2;
            col = 1;
        }
        else if (i == R.id.bu9){
            row = 2;
            col = 2;
        }

//        Toast.makeText(this, "id : " + row + col, Toast.LENGTH_SHORT).show();
        game(row, col);
    }

    public char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    public final char HUMAN = 'X';
    public final char AI = 'O';
    public final int WIN_STATE = 2, LOSE_STATE = -2, DRAW_STATE = 1, NOT_FINISHED_STATE = 0;

    int clicks = 0;

    public void game(int row, int col) {
        int x, y;
        x = row;
        y = col;

        boolean finished = false;
        if (board[x][y] == ' ') {
            board[x][y] = HUMAN;
            clicks++;
            displayBoard(x, y, HUMAN);    //will be modified
            if (clicks != 9) {
                if (checkGameState() != NOT_FINISHED_STATE) {
                    finished = true;
//                Toast.makeText(this, "finished", Toast.LENGTH_SHORT).show();
                }
                Move best = findBestMove();
                board[best.row][best.column] = AI;
                clicks++;
                displayBoard(best.row, best.column, AI);
                if (checkGameState() != NOT_FINISHED_STATE) {
                    finished = true;
//                Toast.makeText(this, "finished", Toast.LENGTH_SHORT).show();
                }
            }
            else finished = true;
        }

        if (finished) {
            int gameFinalState = checkGameState();
            if (gameFinalState == DRAW_STATE) {
                Toast.makeText(this, "Draw", Toast.LENGTH_LONG).show();
                finish();
            } else if (gameFinalState == LOSE_STATE) {
                Toast.makeText(this, "You Are The Winner", Toast.LENGTH_LONG).show();
                finish();
            } else {
                Toast.makeText(this, "Computer Is The Winner", Toast.LENGTH_LONG).show();
                finish();
            }
        }
    }

    Move findBestMove() {
        int bestVal = Integer.MIN_VALUE;
        Move bestMove = new Move();
        bestMove.row = -1;
        bestMove.column = -1;
        /*
        for each child of this this state
        evaluate the outcome of going in this pass
        then get the best one of them
        */
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // Check if cell is empty
                if (board[i][j] == ' ') {
                    // Make the move
                    board[i][j] = AI;
                    // compute evaluation function for this move
                    int moveVal = minimax(100, false);

                    // Undo after modifying the original board
                    board[i][j] = ' ';
                    if (moveVal > bestVal) {
                        bestMove.row = i;
                        bestMove.column = j;
                        bestVal = moveVal;
                    }
                }
            }
        }
        return bestMove;
    }

    public  int minimax(int depth, boolean isMaximizing) {
        int gameState = checkGameState();
        if (gameState != NOT_FINISHED_STATE || depth == 0) {
            return gameState;
        }

        int bestScore;
        if (isMaximizing) {
            bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    // Is the cell available?
                    if (board[i][j] == ' ') {
                        board[i][j] = AI;
                        int score = minimax(depth - 1, false);
                        board[i][j] = ' ';
                        bestScore = Integer.max(score, bestScore);
                    }
                }
            }

        }
        else {
            bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    // Is the cell available?
                    if (board[i][j] == ' ') {
                        board[i][j] = HUMAN;
                        int score = minimax(depth - 1, true);
                        board[i][j] = ' ';
                        bestScore = Integer.min(score, bestScore);
                    }
                }
            }
        }
        return bestScore;
    }

    public boolean equals3(char a, char b, char c) {
        return a == b && b == c && a != ' ';
    }

    public int checkGameState() {

        int gameState = NOT_FINISHED_STATE;

        /* winning from first diagonal */
        if (equals3(board[0][0], board[1][1], board[2][2])) {
            gameState = board[0][0] == AI ? WIN_STATE : LOSE_STATE;
        }
        /* winning from second diagonal */
        if (equals3(board[0][2], board[1][1], board[2][0])) {
            gameState = board[0][2] == AI ? WIN_STATE : LOSE_STATE;
        }
        /* wining from rows */
        for (int i = 0; i < 3; i++) {
            if (equals3(board[i][0], board[i][1], board[i][2])) {
                gameState = board[i][0] == AI ? WIN_STATE : LOSE_STATE;
            }
        }
        /* wining from columns */
        for (int i = 0; i < 3; i++) {
            if (equals3(board[0][i], board[1][i], board[2][i])) {
                gameState = board[0][i] == AI ? WIN_STATE : LOSE_STATE;
            }
        }
        int emptyCells = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    emptyCells++;
                }
            }
        }
        /* check if it is draw */
        if (gameState == NOT_FINISHED_STATE && emptyCells == 0) {
            gameState = DRAW_STATE;
        }
        return gameState;
    }

    public void displayBoard(int x, int y, char player) {
        Button bu = null;
        if (x == 0 && y == 0) {
            bu = findViewById(R.id.bu1);
        } else if (x == 0 && y == 1) {
            bu = findViewById(R.id.bu2);
        }else if (x == 0 && y == 2) {
            bu = findViewById(R.id.bu3);
        }else if (x == 1 && y == 0) {
            bu = findViewById(R.id.bu4);
        }else if (x == 1 && y == 1) {
            bu = findViewById(R.id.bu5);
        }else if (x == 1 && y == 2) {
            bu = findViewById(R.id.bu6);
        }else if (x == 2 && y == 0) {
            bu = findViewById(R.id.bu7);
        }else if (x == 2 && y == 1) {
            bu = findViewById(R.id.bu8);
        }else if (x == 2 && y == 2) {
            bu = findViewById(R.id.bu9);
        }

        if (bu != null) {
            String ch = String.valueOf(player);
            bu.setText(ch);
            bu.setEnabled(false);
            bu.setBackgroundResource(R.color.red);
        }

    }
}