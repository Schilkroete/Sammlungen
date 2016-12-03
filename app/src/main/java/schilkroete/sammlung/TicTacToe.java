package schilkroete.sammlung;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Schilkroete on 24.11.2016.
 */

public class TicTacToe extends AppCompatActivity {

    int aktiverSpieler = 0;                                                                         // 0 ist Spieler
    int[] spielStatus = {2, 2, 2, 2, 2, 2, 2, 2, 2};                                                // 2 bdeutet nicht angeklickt
    int[][] gewinnPositionen = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 4, 8}, {2, 4, 6}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}};   // alle möglichen Positionen um zu gewinnen

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tictactoe);
    }


    // Wenn ein Feld angeklickt wurde, dann soll der aktive Spieler inkl. Farbe gewechselt werden
    public void klickeInEinFeld(View uebergebeBild) {
        ImageView zaehler = (ImageView) uebergebeBild;                                              // das Bild wird in ein ImageView ungewandelt
        System.out.println(zaehler.getTag().toString());                                            // Nimmt Tag und zeigt uns diesem in der Konsole an
        int tagText = Integer.parseInt(zaehler.getTag().toString());                                // wandelt den Tag in einen String um
        TextView tv_gewonnenerSpieler = (TextView) findViewById(R.id.tv_gewonnenerSpieler);
        Button btn_neuesSpiel = (Button) findViewById(R.id.btn_neuesSpiel);
        LinearLayout layout_neuesSpiel = (LinearLayout) findViewById(R.id.layout_neuesSpiel);
        layout_neuesSpiel.setTranslationY(-2000f);                                                  // Layout wird außerhalb angebracht

        if (spielStatus[tagText] == 2) {

            spielStatus[tagText] = aktiverSpieler;
            zaehler.setTranslationY(-1000f);                                                        // Bild ist nicht sichtbar

            if (aktiverSpieler == 0) {
                zaehler.setImageResource(R.drawable.tuerkis);
                aktiverSpieler = 1;
            } else {
                zaehler.setImageResource(R.drawable.rot);
                aktiverSpieler = 0;
            }
            zaehler.animate().translationYBy(1000f).rotation(3600).setDuration(1500);

            for (int[] gewinner : gewinnPositionen) {
                if (spielStatus[gewinner[0]] == spielStatus[gewinner[1]] &&
                        spielStatus[gewinner[1]] == spielStatus[gewinner[2]] &&
                        spielStatus[gewinner[0]] != 2) {
                    System.out.println(spielStatus[gewinner[0]]);
                    layout_neuesSpiel.animate().translationYBy(+2000).alpha(1f).setDuration(2000);  // Layout wird nach dem Spiel angezeigt.
                }
            }
        }
    }
}
