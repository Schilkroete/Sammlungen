package schilkroete.sammlung;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Schilkroete on 28.11.2016.
 */

public class Visibility extends AppCompatActivity {

    TextView mTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visibility);

        mTextView = (TextView) findViewById(R.id.tv_view);

    }


    public void show(View view){
        mTextView.setVisibility(View.VISIBLE);
    }

    public void invisible(View view){
        mTextView.setVisibility(View.INVISIBLE);
    }


}
