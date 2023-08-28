package com.example.mythirdapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity3 : AppCompatActivity() {
    val list = mutableListOf<MyDataModel1>()
    lateinit var myAdapter: RecyclerAdapterDemo
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val rv:RecyclerView = findViewById(R.id.recyclerView)
        myAdapter = RecyclerAdapterDemo(list)
        val layoutManager = LinearLayoutManager(applicationContext)
        rv.layoutManager = layoutManager
        rv.itemAnimator = DefaultItemAnimator()
        rv.adapter = myAdapter
        call()
    }
    fun call() {
        var data = MyDataModel1("Semester 1","CGPA: 9","2015")
        list.add(data)
        list.add(MyDataModel1("Semester 2","CGPA: 8","2016"))
        list.add(MyDataModel1("Semester 3","CGPA: 9","2017"))
        list.add(MyDataModel1("Semester 4","CGPA: 8.5","2018"))
        list.add(MyDataModel1("Semester 5","CGPA: 9.5","2019"))

    }
}