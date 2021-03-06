package uk.co.damaris.mapping;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;

import org.osmdroid.config.Configuration;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;

public class MainActivity extends AppCompatActivity implements OnClickListener
{

    /****** GLOBAL VARIABLES ******/
    MapView mv;


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);

        // This line sets the user agent, a requirement to download OSM maps
        Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this));

        setContentView(R.layout.activity_main);

        mv = (MapView)findViewById(R.id.map1);

        mv.setBuiltInZoomControls(true);
        mv.getController().setZoom(16);
        mv.getController().setCenter(new GeoPoint(50.9115,-1.4156));

        Button b = (Button)findViewById(R.id.goButton);
        b.setOnClickListener(this);

    }

    public void onClick(View view) {

        mv = (MapView)findViewById(R.id.map1);
        EditText et_lat = (EditText)findViewById(R.id.latitudeEditText);
        EditText et_lon = (EditText)findViewById(R.id.longitudeEditText);

        double latitude = Double.parseDouble(et_lat.getText().toString());
        double longitude = Double.parseDouble(et_lon.getText().toString());

        // This line sets the user agent, a requirement to download OSM maps
        Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this));

        mv.getController().setCenter(new GeoPoint(latitude,longitude));

    }

    


}
