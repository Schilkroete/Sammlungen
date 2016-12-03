package schilkroete.sammlung;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Schilkroete on 24.11.2016.
 */

public class ImageEinbindenUndAendern extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_einbinden);
    }


    public void clickFunktion (View view) {

        ImageView aktuellesBild = (ImageView) findViewById(R.id.imageView);
        aktuellesBild.setImageResource(R.drawable.erwuerge);
    }
}
