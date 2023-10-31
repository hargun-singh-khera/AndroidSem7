package com.example.mythirdapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity16 : AppCompatActivity() {
    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main16)
        val addName = findViewById<Button>(R.id.addName)
        val printName = findViewById<Button>(R.id.printName)
        val enterName = findViewById<EditText>(R.id.enterName)
        val enterAge = findViewById<EditText>(R.id.enterAge)
        val Name = findViewById<TextView>(R.id.name)
        val Age = findViewById<TextView>(R.id.age)

        addName.setOnClickListener{

            val db = DBHelper(this, null)

            val name = enterName.text.toString()
            val age = enterAge.text.toString()

            db.addName(name, age)

            Toast.makeText(this, name + " added to database", Toast.LENGTH_LONG).show()

            enterName.text.clear()
            enterAge.text.clear()
        }

        printName.setOnClickListener{

            val db = DBHelper(this, null)

            val cursor = db.getName()
            Name.text = "Name"
            Age.text = "Age"
            cursor!!.moveToFirst()
            Name.append(cursor.getString(cursor.getColumnIndex(DBHelper.NAME_COL)) + "\n")
            Age.append(cursor.getString(cursor.getColumnIndex(DBHelper.AGE_COL)) + "\n")

            while(cursor.moveToNext()){
                Name.append(cursor.getString(cursor.getColumnIndex(DBHelper.NAME_COL)) + "\n")
                Age.append(cursor.getString(cursor.getColumnIndex(DBHelper.AGE_COL)) + "\n")
            }

            cursor.close()
        }
    }
}