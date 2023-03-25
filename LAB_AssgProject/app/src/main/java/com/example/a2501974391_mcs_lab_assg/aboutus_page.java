package com.example.a2501974391_mcs_lab_assg;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class aboutus_page extends AppCompatActivity implements OnMapReadyCallback {

//    private MapView mapView;
//    private static final String MapBundleKey = "MapViewBundleKey";
//    private static final String MapBundleKey = "MapBundle";

//    GoogleMap gMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus_page);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.about_trial_map);
        mapFragment.getMapAsync(this);


//        Bundle mapBundle = null;
//        if (savedInstanceState != null) {
//            mapBundle = savedInstanceState.getBundle(MapBundleKey);
//        }
//        mapView = findViewById(R.id.about_mapView);
//        mapView.onCreate(mapBundle);
//        mapView.getMapAsync(this);
//        mapView.onSaveInstanceState(savedInstanceState);

        //action bar
        getSupportActionBar().setTitle(" About Us");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.drawable.baseline_info_24);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_logout:
                Intent toLoginPg = new Intent(this, MainActivity.class);
                startActivity(toLoginPg);
                return true;
            case R.id.menu_about:
                Intent toAboutPg = new Intent(this, aboutus_page.class);
                startActivity(toAboutPg);
                return true;
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        googleMap.addMarker(new MarkerOptions().position(new LatLng(-6.202339050051723, 106.78280380867268)).title("Bluejack Pharmacy"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-6.202339050051723, 106.78280380867268), 15));
    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        mapView.onStart();
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        mapView.onPause();
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        mapView.onResume();
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        mapView.onStop();
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        mapView.onDestroy();
//    }
//
//    @Override
//    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
//        super.onSaveInstanceState(outState);
//        Bundle mapBundle = outState.getBundle(MapBundleKey);
//        if (mapBundle == null) {
//            mapBundle = new Bundle();
//            outState.putBundle(MapBundleKey, mapBundle);
//        }
//        mapView.onSaveInstanceState(mapBundle);
//        mapView.onSaveInstanceState(outState);
//    }
//
//    @Override
//    public void onLowMemory() {
//        super.onLowMemory();
//        mapView.onLowMemory();
//    }
}