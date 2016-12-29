package schilkroete.sammlung;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Schilkroete on 24.11.2016.
 */

public class TicTacToe  extends AppCompatActivity {

    // 0 bedeutet gelb und 1 bedeutet rot
    int activePlayer = 0;

    boolean gameIsActive = true;

    // 2 bedeutet nicht angeklickt
    int[] gameState ={2,2,2,2,2,2,2,2,2};

    int[][] winningPositions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    public void dropIn(View view){



        ImageView counter = (ImageView) view;

        System.out.println(counter.getTag().toString());

        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        if(gameState[tappedCounter] == 2 && gameIsActive){

            boolean gameIsOver = true;

            for(int counterState : gameState){

                if(counterState == 2) gameIsOver = false;

            }


            gameState[tappedCounter] = activePlayer;

            counter.setTranslationY(-1000f);

            if(activePlayer == 0){
                counter.setImageResource(R.drawable.btn_positiv);
                activePlayer = 1;
            }else{
                counter.setImageResource(R.drawable.btn_negativ);
                activePlayer = 0;
            }

            counter.animate().translationYBy(1000f).rotation(3600).setDuration(1200);

            for(int[] winningPosition : winningPositions){

                if (gameState[winningPosition[0]] == gameState[winningPosition[1]]
                        && gameState[winningPosition[1]] == gameState[winningPosition[2]]
                        && gameState[winningPosition[0]] != 2){

                    String winner = "Rot";
                    if(gameState[winningPosition[0]] == 0){
                        winner = "Gruen";
                    }
                    TextView winnerMessage = (TextView) findViewById(R.id.winnerMessage);
                    winnerMessage.setText(winner + " hat gewonnen!");

                    System.out.println(gameState[winningPosition[0]]);

                    LinearLayout layout = (LinearLayout)findViewById(R.id.playAgainLayout);
                    layout.setVisibility(View.VISIBLE);

                    gameIsActive = false;

                }else {


                    if(gameIsOver){
                        TextView winnerMessage = (TextView) findViewById(R.id.winnerMessage);
                        winnerMessage.setText("Unentschieden!");

                        LinearLayout layout = (LinearLayout)findViewById(R.id.playAgainLayout);
                        layout.setVisibility(View.VISIBLE);
                    }

                }

            }

        }


    }

    public void playAgain(View view){

        gameIsActive = true;

        LinearLayout layout = (LinearLayout)findViewById(R.id.playAgainLayout);
        layout.setVisibility(View.INVISIBLE);

        activePlayer = 0;

        for(int i = 0; i <gameState.length; i++){
            gameState[i] =2;
        }

        GridLayout gridLayout = (GridLayout)findViewById(R.id.gridLayout);

        for (int i = 0; i< gridLayout.getChildCount(); i++){
            ((ImageView) gridLayout.getChildAt(i)).setImageResource(0);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tictactoe);
    }
}
