package schilkroete.sammlung;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Schilkroete on 24.11.2016.
 */

public class AnimationVerblassung extends AppCompatActivity{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_verblassung);
    }


    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    public void verblasse (View view) {
        /*
         * ".alpha (0f)" = verblasst vollständig
         * ".alpha (0.5f)" = verblasst zur Hälfte
         * ".Duration (2000)" =  in 2 Sekunden wird die angegebene Methode
         *                      (hier alpha (also verblassen)) ausgeführt
         */

        ImageView taly = (ImageView) findViewById(R.id.taly);
        ImageView erwuerge = (ImageView) findViewById(R.id.erwuerge);

        taly.animate().alpha(0f).setDuration(2000);
        erwuerge.animate().alpha(1f).setDuration(2000);
    }
}