package schilkroete.sammlung;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;

import static java.util.Arrays.asList;

/**
 * Created by Schilkroete on 13.12.2016.
 */

public class ListView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        android.widget.ListView myList = (android.widget.ListView) findViewById(R.id.myListView);

        // final = einmal angelegt ist diese nicht mehr überschreibbar
        final ArrayList<String> myPfeile = new ArrayList<String>(asList("Holz", "Alu", "Carbon", "Gummi", "Luft"));

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, myPfeile);

        myList.setAdapter(arrayAdapter);

        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick (AdapterView<?> parent, View view, int position, long id) {
                Log.i ("Pfeile tapped: ", myPfeile.get(position));
                Toast.makeText(getApplicationContext(), myPfeile.get(position), Toast.LENGTH_SHORT).show();
                }
        });
    }
}