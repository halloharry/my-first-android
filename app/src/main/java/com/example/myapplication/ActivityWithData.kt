package com.example.myapplication

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ActivityWithData : AppCompatActivity() {

    companion object{
        const val AGE = "age"
        const val NAME = "name"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_with_data)

        val data :TextView = findViewById(R.id.data_received)
        val age = intent.getStringExtra(AGE)
        val name = intent.getStringExtra(NAME)

        val text = "Name : $name , yout age is : $age"
        data.text = text
    }

}