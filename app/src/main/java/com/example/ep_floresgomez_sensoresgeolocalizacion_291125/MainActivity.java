package com.example.ep_floresgomez_sensoresgeolocalizacion_291125;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;

public class MainActivity extends AppCompatActivity {

    private MapView map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Configuration.getInstance().load(getApplicationContext(),
                androidx.preference.PreferenceManager.getDefaultSharedPreferences(this));

        setContentView(R.layout.activity_main);

        map = findViewById(R.id.map);


        map.setTileSource(TileSourceFactory.MAPNIK);
        map.setMultiTouchControls(true);


        GeoPoint myLocation = new GeoPoint(-17.90123, -63.15047);

        map.getController().setZoom(15.0);
        map.getController().setCenter(myLocation);

        Marker marker = new Marker(map);
        marker.setPosition(myLocation);
        marker.setTitle("Mi ubicación");
        map.getOverlays().add(marker);


    }
}
