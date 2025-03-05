package com.example.almatyai

import android.location.Geocoder
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import java.util.Locale

class MapActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        val btnBack = findViewById<ImageButton>(R.id.btnBack)
        btnBack.setOnClickListener {
            finish() // Закрывает MapActivity и возвращает пользователя назад
        }
    }


    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val locationName = intent.getStringExtra("LOCATION_NAME")

        if (!locationName.isNullOrEmpty()) {
            val geocoder = Geocoder(this, Locale.getDefault())
            val addresses = geocoder.getFromLocationName(locationName, 1)

            if (!addresses.isNullOrEmpty()) {
                val latitude = addresses[0].latitude
                val longitude = addresses[0].longitude
                val location = LatLng(latitude, longitude)

                mMap.addMarker(MarkerOptions().position(location).title(locationName))
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 15f))
            }
        }
    }
}
