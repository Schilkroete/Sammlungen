package schilkroete.sammlung;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Created by Schilkroete on 29.12.2016.
 */

public class Reaktion extends AppCompatActivity
        implements Runnable, View.OnTouchListener, View.OnClickListener{

    TextView tv_now, tv_time;
    Button btn_start;
    LinearLayout layout_reaktion;
    boolean running, reactNow;
    double time, reactionTime, reactionMoment;
    Thread thread_count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reaktion);

        tv_now = (TextView) findViewById(R.id.tv_now);
        tv_time = (TextView) findViewById(R.id.tv_time);
        btn_start = (Button) findViewById(R.id.btn_start);
        layout_reaktion = (LinearLayout) findViewById(R.id.layout_reaktion);

        layout_reaktion.setOnTouchListener(this);
        btn_start.setOnClickListener(this);

        thread_count = new Thread(this);
        running = false;
        reactNow = false;
    }



    /* Berechnung im Hintergrund
  *
  * hier wird die Zeit gezählt und wenn der Zeitpunkt erreicht ist, wenn User reagieren
  * soll (reactionMoment) dann werden die entsprechenden Operationen in die Wege geleitet.
  * Anschließend  zählt der Thread die Zeit, wie lange der User benötigt, um zu reagieren
  */
    public void run(){
        time = 0;
        reactionTime = 0;

        runOnUiThread(new Runnable() {
            public void run() {
                tv_now.setText("Warte!");
                tv_now.setVisibility(View.VISIBLE);
                tv_time.setText(String.format("%.2f", reactionTime));
            }
        });

        while (running) {
            time = time + 0.01;
            if (time == reactionMoment) {
                reactNow = true;
            }
            if (reactNow) {
                reactionTime += 0.01;
                runOnUiThread(new Runnable() {
                    public void run() {
                        tv_now.setText("Reagiere!");
                        tv_time.setText(String.format("%.2f", reactionTime));
                    }
                });
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Reaktion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        runOnUiThread(new Runnable() {
            public void run() {
                tv_now.setVisibility(View.INVISIBLE);
            }
        });
    }
    /* Je nachdem in welchem Zustand sich der Reaktionstest befindet, ändern wir den Text unseres
    * TV's entweder zu "Warte!" oder "Reagiere!". So weiß der User sofort, wenn er reagieren soll,
    * nämmlich sobald der Text auf "Reagiere!" umspringt. Berührt er dann den Bildschirm der App,
    * wird die Zeit gestoppt
    */





    // was passiert, wenn der User den Bildschirm berührt
    public boolean onTouch(View view, MotionEvent event){
        /* das zweite Interface, onTouchListener kommt mit der Methode onTouch daher, in der wir
        * definieren, was geschieht, sobald der User den Bildschirm berührt.
        *
        * Das Berühren des Bildschirms ist die Reaktion, sobald der User das entsprechende
        * Kommando bekommt
        *
        * Also müssen wir den Thread stoppen und den Button zum starten des Reaktionstest
        * wieder entsperren
        */
        if (running && reactNow) {
            running = false;
            reactNow = false;
            btn_start.setClickable(true);
        }
        return true;
    }




    public void onClick(View view){
        // den Moment, berechnen, wann der User reagieren soll, also eine Zufallszahl
        reactionMoment = ((Math.random()) * 6 + 2);
        running = true;
        // Neuer Thread soll gestartet werden, dieser soll eine Berechnung vornehmen
        thread_count = new Thread (this);
        thread_count.start();
        // Der Button soll gesperrt werden, damit dieser nicht mehr angeklickt werden kann
        btn_start.setClickable(false);
    }



}