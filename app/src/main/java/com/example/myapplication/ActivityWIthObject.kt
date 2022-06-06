package com.example.myapplication

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ActivityWIthObject : AppCompatActivity() {

    companion object {
        const val PERSON = "person"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_with_object)

        val objectTransfer:TextView = findViewById(R.id.object_received)
        val person = intent.getParcelableExtra<Person>(PERSON) as Person
        val string = "Nama : ${person.name}, \nemail : ${person.email}, \n" +
                "umur : ${person.age}, \n" +
                "lokasi : ${person.city}"
        objectTransfer.text = string
    }
}