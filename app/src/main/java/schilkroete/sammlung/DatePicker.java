package schilkroete.sammlung;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Date;

/**
 * Created by Schilkroete on 05.12.2016.
 */

public class DatePicker extends Activity {

    Button a = null;
    TimePicker tp = null;
    android.widget.DatePicker dp = null;

    @Override
    protected void onCreate (Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_date_picker);

        final android.widget.DatePicker dp = (android.widget.DatePicker) findViewById(R.id.datePicker);
        final TimePicker tp = (TimePicker) findViewById(R.id.timePicker);
        Button btn_1 = (Button) findViewById(R.id.btn1);
        
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strDateTime = dp.getYear() + "-" + (dp.getMonth() + 1) + "-" + dp.getDayOfMonth() +
                        " " + tp.getCurrentHour() + ":" + tp.getCurrentMinute();

                Toast.makeText(getApplicationContext(), "Gewählte(s) Zeit und Datum.. = " + strDateTime,
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
