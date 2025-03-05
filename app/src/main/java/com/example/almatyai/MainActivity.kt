package com.example.almatyai

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editSearch = findViewById<EditText>(R.id.editSearch)
        val btnSearch = findViewById<Button>(R.id.btnSearch)

        btnSearch.setOnClickListener {
            val location = editSearch.text.toString().trim()

            if (location.isNotEmpty()) {
                val intent = Intent(this, MapActivity::class.java)
                intent.putExtra("LOCATION_NAME", location)
                startActivity(intent)
            } else {
                editSearch.error = "Введите название места"
            }
        }
    }
}
