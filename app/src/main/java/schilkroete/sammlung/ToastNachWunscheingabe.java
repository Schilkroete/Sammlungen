package schilkroete.sammlung;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Schilkroete on 24.11.2016.
 */

public class ToastNachWunscheingabe extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast_nach_wunscheingabe);
    }



    public void clickFunktion (View view) {

        EditText et_individuelle_Eingabe = (EditText)findViewById(R.id.et_individuelle_Eingabe);

        Toast toast = Toast.makeText(getApplicationContext(), "Dein individueller Text lautet: " + et_individuelle_Eingabe.getText().toString(), Toast.LENGTH_LONG);
        // Setze Toast in die Mitte
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();

    }
}
