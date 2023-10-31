package com.example.mythirdapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class MainActivity17 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main17)

        val wv = findViewById<WebView>(R.id.webview)
        val customHtml = "<html><body><h1>Welcome to Cabify</h1><h2>Welcome to Cabify</h2><h3>Welcome to Cabify</h3><p>It is a static Web HTML Content.</body></html>"

        wv.loadData(customHtml, "text/html", "UTF-8")
    }
}