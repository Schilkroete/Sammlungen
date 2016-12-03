package schilkroete.sammlung;


import android.content.DialogInterface;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

/**
 * Created by Schilkroete on 27.11.2016.
 */

public class Progressbar extends Activity implements View.OnClickListener{

    ProgressBar bar;
    Button btn;
    int i = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progressbar);

        bar = (ProgressBar)findViewById(R.id.progressBar1);
        bar.setMax(100);

        btn = (Button)findViewById(R.id.button1);
        btn.setOnClickListener(this);

        //TODO zweiten Button hinzufügen, Verlinkung zu Vorschaubildern der Bewegungsabläufe
        android.app.AlertDialog ad = new android.app.AlertDialog.Builder(this).create();
        ad.setTitle("Hinweis");
        ad.setMessage("Das Ziel dieser Übung ist es, einen bestimmten Bewegungsablauf zu trainieren"
                + "\n\nFrage dazu deine Betreuer/in oder klicke auf den Button 'Bilder'");
        ad.setIcon(R.drawable.icon);
        //TODO Bilder-Button zu einer Gallerie verlinken
        ad.setButton(DialogInterface.BUTTON_NEUTRAL, "Bilder",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Du hast den Bilder-Button gedrückt",
                                Toast.LENGTH_SHORT).show();
                    }
                });
        ad.setButton(DialogInterface.BUTTON_POSITIVE, "Verstanden",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        ad.show();
    }

    public void onClick(View e){
        if(e == btn){
            i += 8;

            if(i >= 100){
                android.app.AlertDialog ad = new android.app.AlertDialog.Builder(this).create();
                ad.setMessage("Sehr gut, du hast die Leiste vollständig gefüllt. Weiter so!");
                ad.show();

                i = 0;
            }

            bar.setProgress(i);
        }
    }
}