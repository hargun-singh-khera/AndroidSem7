package com.example.mythirdapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity14 : AppCompatActivity() {
    private lateinit var add: FloatingActionButton
    private lateinit var setting: FloatingActionButton
    private lateinit var home: FloatingActionButton
    private var fabVisible = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main14)
        add = findViewById(R.id.FABAdd)
        setting = findViewById(R.id.FABSettings)
        home = findViewById(R.id.FABHome)
        fabVisible = false

        add.setOnClickListener {
            if (!fabVisible) {
                home.show()
                setting.show()
                home.visibility = View.VISIBLE
                setting.visibility = View.VISIBLE
                add.setImageDrawable(resources.getDrawable(R.drawable.baseline_close_24))
                fabVisible = true
            }
            else {
                home.hide()
                setting.hide()
                home.visibility = View.GONE
                setting.visibility = View.GONE
                add.setImageDrawable(resources.getDrawable(R.drawable.baseline_add_24))
                fabVisible = false
            }
            home.setOnClickListener {
                Toast.makeText(this, "Home Clicked!!", Toast.LENGTH_LONG).show()
            }
            setting.setOnClickListener {
                Toast.makeText(this, "Settings Clicked!!", Toast.LENGTH_LONG).show()
            }
        }
    }
}