package com.example.almatyai

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.almatyai.R

class RouteActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_route)

        val routeTextView = findViewById<TextView>(R.id.routeTextView)
        val generatedRoute = "1. Кок-Тобе\n2. Арбат\n3. Тайный бар в центре"
        val intent = Intent(this, MapActivity::class.java)
        intent.putExtra("latitude", 43.2567)  // Координаты места
        intent.putExtra("longitude", 76.9286)
        startActivity(intent)


        routeTextView.text = generatedRoute
    }
}
