package com.example.mythirdapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView

class MainActivity18 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main18)

        val wv = findViewById<WebView>(R.id.webview)
        val webSettings: WebSettings = wv.settings
        webSettings.javaScriptEnabled = true

        wv.loadUrl("https://myhosieryshop.netlify.app/")
    }
}