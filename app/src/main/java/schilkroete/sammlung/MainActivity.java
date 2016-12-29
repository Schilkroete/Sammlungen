package schilkroete.sammlung;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btn_toastNachWunsch = (Button)findViewById(R.id.btn_toastNachWunsch);
        btn_toastNachWunsch.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                Intent btn_toastNachWunsch = new Intent(MainActivity.this,
                        ToastNachWunscheingabe.class);
                startActivity(btn_toastNachWunsch);
            }
        });

        Button btn_checkNetzwerk= (Button)findViewById(R.id.btn_checkNetzwerk);
        btn_checkNetzwerk.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                Intent btn_checkNetzwerk= new Intent(MainActivity.this,
                        CheckNetzwerkverbindung.class);
                startActivity(btn_checkNetzwerk);
            }
        });


        Button btn_imageEinbindenUndAendern = (Button)findViewById(R.id.btn_imageEinbindenUndAendern);
        btn_imageEinbindenUndAendern.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                Intent btn_imageEinbindenUndAendern = new Intent(MainActivity.this,
                        ImageEinbindenUndAendern.class);
                startActivity(btn_imageEinbindenUndAendern);
            }
        });


        Button btn_verblasse = (Button)findViewById(R.id.btn_verblasse);
        btn_verblasse.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                Intent btn_verblasse = new Intent(MainActivity.this,
                        AnimationVerblassung.class);
                startActivity(btn_verblasse);
            }
        });


        Button btn_tictactoe= (Button)findViewById(R.id.btn_tictactoe);
        btn_tictactoe.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                Intent btn_tictactoe = new Intent(MainActivity.this,
                        TicTacToe.class);
                startActivity(btn_tictactoe);
            }
        });


        Button btn_alertdialog= (Button)findViewById(R.id.btn_alertdialog);
        btn_alertdialog.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                Intent btn_alertdialog = new Intent(MainActivity.this,
                        AlertDialog.class);
                startActivity(btn_alertdialog);
            }
        });


        Button btn_progressbar= (Button)findViewById(R.id.btn_progressbar);
        btn_progressbar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                Intent btn_progressbar = new Intent(MainActivity.this,
                        Progressbar.class);
                startActivity(btn_progressbar);
            }
        });


        Button btn_datePicker= (Button)findViewById(R.id.btn_datePicker);
        btn_datePicker.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                Intent btn_datePicker = new Intent(MainActivity.this,
                        DatePicker.class);
                startActivity(btn_datePicker);
            }
        });

        Button btn_swipeSide = (Button)findViewById(R.id.btn_swipeSide);
        btn_swipeSide.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                Intent btn_swipeSide = new Intent(MainActivity.this,
                        SwipeSide.class);
                startActivity(btn_swipeSide);
            }
        });

        Button btn_listView = (Button)findViewById(R.id.btn_listView);
        btn_listView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                Intent btn_listView= new Intent(MainActivity.this,
                        ListView.class);
                startActivity(btn_listView);
            }
        });

        Button btn_timer = (Button)findViewById(R.id.btn_timer);
        btn_timer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                Intent btn_timer= new Intent(MainActivity.this,
                        Timer.class);
                startActivity(btn_timer);
            }
        });

        Button btn_bewertung = (Button)findViewById(R.id.btn_bewertung);
        btn_bewertung.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                Intent btn_bewertung= new Intent(MainActivity.this,
                        Bewertung.class);
                startActivity(btn_bewertung);
            }
        });

        Button btn_visibility = (Button)findViewById(R.id.btn_visibility);
        btn_visibility.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                Intent btn_visibility= new Intent(MainActivity.this,
                        Visibility.class);
                startActivity(btn_visibility);
            }
        });

        Button btn_brainTrainer = (Button)findViewById(R.id.btn_brainTrainer);
        btn_brainTrainer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                Intent btn_brainTrainer= new Intent(MainActivity.this,
                        BrainTrainer.class);
                startActivity(btn_brainTrainer);
            }
        });

        Button btn_reaktion = (Button)findViewById(R.id.btn_reaktion);
        btn_reaktion.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                Intent btn_reaktion= new Intent(MainActivity.this,
                        Reaktion.class);
                startActivity(btn_reaktion);
            }
        });







/**     Button btn_zeigeStandort= (Button)findViewById(R.id.btn_zeigeStandort);
        btn_zeigeStandort.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                Intent btn_zeigeStandort = new Intent(MainActivity.this,
                        StandortZeigen.class);
                startActivity(btn_zeigeStandort);
            }
        });
*/
    }
}
