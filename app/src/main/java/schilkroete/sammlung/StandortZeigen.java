/**package schilkroete.sammlung;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;


public abstract class StandortZeigen extends ActionBarActivity implements LocationListener {

    Button btn_zeigeStandort;
    LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standort_zeigen);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btn_zeigeStandort = (Button) findViewById(R.id.btn_zeigeStandort);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 3000, 10, this);
    }


    @Override
    public void onLacationChanged (Location location) {
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();

        Toast.makeText(getApplicationContext(), "Latitude = " + latitude + " \nLongitude = " + longitude, Toast.LENGTH_LONG).show();
        String activity_bewertung = "geo: " + latitude + ", " + longitude;
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(activity_bewertung));
        startActivity(i);
    }



    @Override
    public void wennStatusChanged(String provider, int status, Bundle extras){
//        Toast.makeText(getApplicationContext(), "GPS wurde umgeschaltet", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void wennProviderAktiv(String provider){
        Toast.makeText(getApplicationContext(), "GPS Aktiv", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void wennStatusInaktiv(String provider, int status, Bundle extras){
        Toast.makeText(getApplicationContext(), "GPS Inaktiv", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public void boolean onOptionItemSelected (MenuItem item){
        int id = item.getItemId();
        if (id == android.R.id.home) {

            StandortZeigen.this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
} */