package schilkroete.sammlung;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import static android.R.id.progress;

/**
 * Created by Schilkroete on 14.12.2016.
 */

public class Timer extends AppCompatActivity {



    SeekBar seekBar_time;
    TextView tv_time;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        tv_time = (TextView) findViewById(R.id.tv_time);

        seekBar_time = (SeekBar) findViewById(R.id.seekBar_time);
        seekBar_time.setMax(1200);
        seekBar_time.setProgress(120);

        seekBar_time.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                updateTimer(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }



    public void updateTimer (int secondsLeft) {
        int minutes = secondsLeft / 60;
        int seconds = secondsLeft - minutes * 60;

        String secondsString = Integer.toString(seconds);
        String minutesString = Integer.toString(minutes);

        if(seconds < 10) {
            secondsString = String.format("%02d", seconds);
        }
        if(minutes < 10) {
            minutesString = String.format("%02d", minutes);
        }
        tv_time.setText(minutesString + ":" + secondsString);
        Button btn_go = (Button) findViewById(R.id.btn_go);
        btn_go.setText(minutesString + ":" + secondsString);
    }



    public void controlTimer (View view) {
        // getProgress = gibt mir den aktuellen Wert
        // 1000 wir benöötigen die Millisekunden,
        // 1000 der Timer soll jede Sekunde ablaufen
        new CountDownTimer(seekBar_time.getProgress() * 1000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {

                updateTimer((int)millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {

            }
        };
    }



  /*       new CountDownTimer(10000, 1000) {
          public void onTick(long millisecondsUntilDone) {
              Log.i("Sekunden übrig:", String.valueOf(millisecondsUntilDone/1000));
          }
            public void onFinish(){
                Log.i("Erledigt", "Der Countdown Timer ist fertig!");
            }
        }.start();



       // In dem Fall kann der Handler einen bestimmten Code in einer bestimmten zeit abspielen lassen
        final Handler handler = new Handler();

        // Wenn es wiederholbaren Code gibt, dann kann man diese Methode nutzen
        Runnable run = new Runnable() {
            @Override
            public void run() {
                Log.i("Runnable wurde ausgefuehrt", " eine Sekunde ist verstrichen...");
                // nach einer bestimmten Verzögerung soll der Code ausgeführt

                handler.postDelayed(this, 1000);
            }
        };
        handler.post(run);*/
}