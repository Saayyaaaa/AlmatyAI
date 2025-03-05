package com.example.almatyai

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Получаем переданные координаты
        val latitude = intent.getDoubleExtra("latitude", 43.238949)
        val longitude = intent.getDoubleExtra("longitude", 76.889709)

        val location = LatLng(latitude, longitude)
        mMap.addMarker(MarkerOptions().position(location).title("Выбранное место"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 15f))
    }

}
