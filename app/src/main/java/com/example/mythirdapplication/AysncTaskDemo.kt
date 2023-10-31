package com.example.mythirdapplication

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.ProgressBar
import android.widget.Toast
import java.lang.Exception

class AysncTaskDemo : AppCompatActivity() {
    lateinit var progressBar: ProgressBar
    lateinit var listView: ListView
    val array = arrayOf("1","2","3","4","5","6","7","8","9","10")
    lateinit var myAdapter:ArrayAdapter<String>
    lateinit var arrayList: ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aysnc_task_demo)

        progressBar = findViewById(R.id.progressBar)
        listView = findViewById(R.id.listView)

        arrayList = ArrayList()
        myAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList)
        listView.adapter = myAdapter
        MyTaskDemo().execute()

    }
    internal inner class MyTaskDemo:AsyncTask<Void,Int?,String?>() {
        var count = 0
        override fun onPreExecute() {
            super.onPreExecute()
            progressBar.max = 10
            progressBar.progress=0
            progressBar.visibility= View.VISIBLE
            count=0
        }
        override fun doInBackground(vararg params: Void?): String? {
            for (i in 1..10) {
                count=count+1
                publishProgress(i)
                try {
                    Thread.sleep(1000)
                } catch (e:Exception) {
                    e.printStackTrace()
                }
            }
            return "Task Completed"
        }

        override fun onProgressUpdate(vararg values: Int?) {
            super.onProgressUpdate(*values)
            progressBar.progress = values[0]!!
            arrayList.add(array[count-1])
            myAdapter.notifyDataSetChanged()
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            Toast.makeText(this@AysncTaskDemo, result, Toast.LENGTH_SHORT).show()
        }
    }
}