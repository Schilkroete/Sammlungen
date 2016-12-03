package schilkroete.sammlung;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import static schilkroete.sammlung.R.string.fehler;

/**
 * Created by Schilkroete on 27.11.2016.
 */

public class AlertDialog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);

        ///////////////////// ALERT DIALOG /////////////////////

        Button btn1 = (Button) findViewById(R.id.btnevvet);
        assert btn1 != null;
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                android.support.v7.app.AlertDialog.Builder build= new android.support.v7.app.AlertDialog.Builder(AlertDialog.this);
                build.setIcon(android.R.drawable.ic_dialog_alert);
                build.setTitle(fehler);
                build.setMessage("Benutzername oder Password ist falsch");

                build.setCancelable(false);

                build.setPositiveButton("Beenden", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        AlertDialog.this.finish();
                    }
                });
                build.setNegativeButton("Verstanden", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                android.support.v7.app.AlertDialog TestAlertDialog = build.create();

                TestAlertDialog.show();
            }
        });
    }
}