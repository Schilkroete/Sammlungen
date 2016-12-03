package schilkroete.sammlung;

import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import static android.graphics.Color.GREEN;
import static android.graphics.Color.RED;

/**
 * Created by Schilkroete on 28.11.2016.
 */

public class CheckNetzwerkverbindung extends AppCompatActivity {

    Button btn;
    ImageView iV_status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_netzwerkverbindung);

        iV_status = (ImageView) findViewById(R.id.iV_status);

        btn = (Button) findViewById(R.id.btn_checkNetzwerk);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkInternetConnection();
            }
        });}


    private boolean checkInternetConnection() {
        ConnectivityManager connect = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);

        if (connect.getNetworkInfo(0).getState() ==
                android.net.NetworkInfo.State.CONNECTED ||
                connect.getNetworkInfo(0).getState() ==
                        android.net.NetworkInfo.State.CONNECTING ||
                connect.getNetworkInfo(1).getState() ==
                        android.net.NetworkInfo.State.CONNECTING ||
                connect.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTED) {
            Toast.makeText(this, " Verbunden ", Toast.LENGTH_SHORT).show();

            iV_status.setColorFilter(GREEN);
            return true;
        } else if (
                connect.getNetworkInfo(0).getState() ==
                        android.net.NetworkInfo.State.DISCONNECTED ||
                        connect.getNetworkInfo(1).getState() ==
                                android.net.NetworkInfo.State.DISCONNECTED) {
            Toast.makeText(this, " Nicht verbunden ", Toast.LENGTH_SHORT).show();
            iV_status.setColorFilter(RED);
        }
        return false;
    }
}