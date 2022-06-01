package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var editLebar: EditText
    private lateinit var editPanjang: EditText
    private lateinit var editTinggi: EditText
    private lateinit var editButton: Button
    private lateinit var editHasil: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editLebar = findViewById(R.id.edit_lebar)
        editButton = findViewById(R.id.edit_btn)
        editHasil = findViewById(R.id.edit_hasil)
        editPanjang = findViewById(R.id.edit_panjang)
        editTinggi = findViewById(R.id.edit_tinggi)

        editButton.setOnClickListener(this)

        if (savedInstanceState != null){
            val hasil = savedInstanceState.getString(STATE_RESULT)
            editHasil.text = hasil
        }

    }

    override fun onClick(view: View?) {
        if (view != null) {
            if (view.id == R.id.edit_btn) {
                val panjang = editPanjang.text.toString().trim()
                val lebar = editLebar.text.toString().trim()
                val tinggi = editTinggi.text.toString().trim()

                var mandatory = false
                if (panjang.isEmpty()){
                    mandatory = true
                    editPanjang.error = "mandatory bray"
                }
                if (lebar.isEmpty()){
                    mandatory = true
                    editLebar.error = "mandatory bray"
                }
                if (tinggi.isEmpty()){
                    mandatory = true
                    editTinggi.error = "mandatory bray yy"
                }

                if (!mandatory){
                    val volume = panjang.toDouble() * lebar.toDouble() * tinggi.toDouble()
                    editHasil.text = volume.toString()
                }
            }
        }
    }

    companion object{
        private const val STATE_RESULT = "state_result"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, editHasil.text.toString())
    }
}