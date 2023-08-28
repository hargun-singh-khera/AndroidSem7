package com.example.mythirdapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.example.myfourthapplication.ContactDetails
import com.example.myfourthapplication.CustomListView

class MainActivity : AppCompatActivity() {
//    lateinit var list: ArrayList<ContactDetails>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listView = findViewById<ListView>(R.id.listView)
        val list = mutableListOf<ContactDetails>()
//        list = ArrayList()
        list.add(ContactDetails("Vivek","friend",R.drawable.ic_launcher_background))
        list.add(ContactDetails("Vivek","friend",R.drawable.ic_launcher_foreground))
        list.add(ContactDetails("Vivek","friend",R.drawable.ic_launcher_background))
        list.add(ContactDetails("Vivek","friend",R.drawable.ic_launcher_foreground))
        list.add(ContactDetails("Vivek","friend",R.drawable.ic_launcher_background))
        list.add(ContactDetails("Vivek","friend",R.drawable.ic_launcher_foreground))
        val adapter = CustomListView(this,R.layout.customlookfile,list)
        listView.adapter = adapter
    }
}