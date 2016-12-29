package schilkroete.sammlung;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import android.app.AlertDialog;

/**
 * Created by Schilkroete on 22.12.2016.
 */

public class Bewertungsabfrage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bewertungsabfrage);

        ///////////////////// ALERT DIALOG /////////////////////


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Exit!")
                .setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setIcon(R.drawable.btn_negativ)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Bewertungsabfrage.this.finish();
                    }
                })
                .setIcon(R.drawable.btn_neutral)
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                })
                .setIcon(R.drawable.btn_positiv)
                .setNeutralButton("Middle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Bewertungsabfrage.this, "Middle button clicked!", Toast.LENGTH_SHORT).show();
                    }
                });

        builder.create().show();		// create and show the alert dialog

    }
}