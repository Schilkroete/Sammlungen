package schilkroete.sammlung;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;


/**
 * Created by Schilkroete on 28.12.2016.
 */

public class BrainTrainer  extends AppCompatActivity {

    Button btn_start, button0, button1, button2, button3, btn_playAgain;
    //Array fuer alle moeglichen vier Antworten
    ArrayList<Integer> answer = new ArrayList<Integer>();
    // welcher Antwort wurde ausgewaehlt
    int locationOfCorrectAnswer;
    TextView tv_result, tv_score, tv_time, sumTextView;
    int score = 0;
    int numberOfQuestions = 0;
    RelativeLayout layout_rl_brain_trainer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brain_trainer);

        btn_start = (Button) findViewById(R.id.btn_start);
        sumTextView = (TextView) findViewById(R.id.tv_sum);
        tv_result = (TextView) findViewById(R.id.tv_result);
        tv_score = (TextView) findViewById(R.id.tv_score);
        tv_time = (TextView) findViewById(R.id.tv_time);
        button0 = (Button)findViewById(R.id.btn_0);
        button1 = (Button)findViewById(R.id.btn_1);
        button2 = (Button)findViewById(R.id.btn_2);
        button3 = (Button)findViewById(R.id.btn_3);
        btn_playAgain = (Button)findViewById(R.id.btn_playAgain);
        layout_rl_brain_trainer = (RelativeLayout) findViewById(R.id.layout_rl_brain_trainer);
    }


    public void start(View view){
        btn_start.setVisibility(View.INVISIBLE);
        layout_rl_brain_trainer.setVisibility(View.VISIBLE);
        playAgain(findViewById(R.id.btn_playAgain));
    }


    // hier wird getestet ob unsere Antwort korrekt war
    // dann soll unten der Text als "Korrekt" angezeigt werden
    // Der Score soll erhoeht werden
    // Wenn falsch, dann soll "Inkorrekt" angezeigt werden
    public void chooseAnswer(View view){
        // wir nehmen von dem Button der angeklickt wurde, welches wird ueber das View wissen/ erhalten,
        // den Tag wandeln diesen in einen String und dieser vergleicht dann den Wert mit der "locationOfCorrectAnswer"

        Log.i("Tag", (String) view.getTag());
        if (view.getTag().toString().equals(Integer.toString(locationOfCorrectAnswer))){
            score++;
            tv_result.setTextColor(0xffff0000);
            tv_result.setText("Richtiger!");
        } else {
            tv_result.setTextColor(0xffbdbdbd);
            tv_result.setText("Falsch!");
        }
        // immer wenn eine Antwort geklickt wurde, dann soll unser "Score" angepasst werde
        numberOfQuestions++;
        tv_score.setText(Integer.toString(score) + " / " + Integer.toString(numberOfQuestions));
        generateQuestion();
    }





    // es sollen Zufallswerte generiert, summiert und in einem TextView angezeigt werden
    // es soll die Location ueberprueft werden, also welcher Button wurde gedrueckt
    // in einer for-Schleife werden alle vier Buttons ueberprueft, verglichen und anschließend
    // werden die Antworten generiert und es wird ueberprueft ob eine Antwort doppelt vorkommt,
    // ist dies der Fall, dann wird eine neue Antwortmoeglichkeit generiert
    public void generateQuestion(){

        Random random = new Random();

        // waehle eine Zahl zwischen 0 und 20
        int a = random.nextInt(21);
        int b = random.nextInt(21);

        sumTextView.setText(Integer.toString(a) + " + " + Integer.toString(b));
        locationOfCorrectAnswer = random.nextInt(4);
        int incorrectAnswer;

        answer.clear();

        for(int i = 0; i < 4; i++){
            if (i == locationOfCorrectAnswer){
                answer.add(a + b);
            } else {
                incorrectAnswer = random.nextInt(41);
                // hiermit gehen wir sicher, dass keine Antwort zwei mal vorkommt
                while (incorrectAnswer == a + b) {
                    incorrectAnswer = random.nextInt(41);
                }
                answer.add(incorrectAnswer);
            }
        }
        button0.setText(Integer.toString(answer.get(0)));
        button1.setText(Integer.toString(answer.get(1)));
        button2.setText(Integer.toString(answer.get(2)));
        button3.setText(Integer.toString(answer.get(3)));
    }

    // unser Score (oben links) muss auf 0 gesetzt werden, genau wie die Anzahl der Fragen (oben rechts)
    // unser Timer soll wieder auf "30s" gesetzt werden
    // Der Button playAgain sollunsichtbar gemacht werden, wenn dieser geklickt wurde
    public void playAgain(final View view) {

        score = 0;
        numberOfQuestions = 0;

        tv_time.setText("30s");
        tv_score.setText("0 / 0");
        tv_result.setText("");
        btn_playAgain.setVisibility(View.INVISIBLE);

        generateQuestion();

        new CountDownTimer(30100, 1000){
            @Override
            public void onTick(long millisUnitilFinished) {
                tv_time.setText(String.valueOf(millisUnitilFinished / 1000) + "s");
            }
            @Override
            public void onFinish(){
                tv_time.setText("0s");
                tv_result.setText("Deine Punkteanzahl liegt bei " + Integer.toString(score)
                        + " / " + Integer.toString(numberOfQuestions));
            }
        }.start();
        btn_playAgain.setVisibility(View.VISIBLE);
    }




}
