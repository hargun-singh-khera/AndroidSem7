package com.example.mythirdapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity2 : AppCompatActivity() {
    lateinit var listView: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

//        supportActionBar?.hide()
        listView = findViewById(R.id.listView)

        var list = mutableListOf<ListModelClass>()
        list.add(ListModelClass("Pratyush", R.drawable.ic_launcher_foreground))
        list.add(ListModelClass("Pratyush", R.drawable.ic_launcher_foreground))
        list.add(ListModelClass("Pratyush", R.drawable.ic_launcher_foreground))
        list.add(ListModelClass("Pratyush", R.drawable.ic_launcher_foreground))
        list.add(ListModelClass("Pratyush", R.drawable.ic_launcher_foreground))
        list.add(ListModelClass("Pratyush", R.drawable.ic_launcher_foreground))
        list.add(ListModelClass("Pratyush", R.drawable.ic_launcher_foreground))
        list.add(ListModelClass("Pratyush", R.drawable.ic_launcher_foreground))
        list.add(ListModelClass("Pratyush", R.drawable.ic_launcher_foreground))

        val adapter = CustomListViewClass(this, R.layout.custom_list_view_class, list)
        listView.adapter = adapter
    }
}