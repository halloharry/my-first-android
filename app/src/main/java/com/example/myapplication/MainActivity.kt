package com.example.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var tvResult: TextView
    private lateinit var btnSetValue: Button
    private lateinit var tvText: TextView
    private var names = ArrayList<String>()


    private val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == ResultActivity.RESULT_CODE && result.data != null) {
            val selectedValue =
                result.data?.getIntExtra(ResultActivity.EXTRA_SELECTED_VALUE, 0)
            tvResult.text = "Hasil : $selectedValue"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonMove: Button = findViewById(R.id.btn_move_activity)
        buttonMove.setOnClickListener(this)

        val buttonWithData: Button = findViewById(R.id.btn_move_activity_data)
        buttonWithData.setOnClickListener(this)

        val buttonWithObject: Button = findViewById(R.id.btn_move_activity_object)
        buttonWithObject.setOnClickListener(this)

        val dialPhoneButton: Button = findViewById(R.id.btn_dial_number)
        dialPhoneButton.setOnClickListener(this)

        val btnMoveForResult:Button = findViewById(R.id.btn_move_for_result)
        btnMoveForResult.setOnClickListener(this)
        tvResult = findViewById(R.id.tv_result)

        debuggingCodeLab()

    }

    override fun onClick(view: View?) {
        if (view?.id == R.id.btn_set_value) {
            Log.d("MainActivity", names.toString())
            val name = StringBuilder()
            for (i in 0..2) {
                name.append(names[i]).append("\n")
            }
            tvText.text = name.toString()
        }

        when (view?.id) {
            R.id.btn_move_activity -> {
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveIntent)
            }

            R.id.btn_move_activity_data ->{
                val dataTransfer = Intent(this@MainActivity, ActivityWithData::class.java)
                dataTransfer.putExtra(ActivityWithData.NAME, "joko")
                dataTransfer.putExtra(ActivityWithData.AGE, 12)
                startActivity(dataTransfer)
            }

            R.id.btn_move_activity_object -> {
               val person = Person("joko", 12, "joko@gmail.com", "subang")
                val objectTransfer = Intent(this@MainActivity, ActivityWIthObject::class.java)
                val putExtra = objectTransfer.putExtra(ActivityWIthObject.PERSON, person)
                startActivity(putExtra)
            }
            R.id.btn_dial_number -> {
                val phoneNumber = "08999999999"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }
            R.id.btn_move_for_result -> {
                val moveForResultIntent = Intent(this@MainActivity, ResultActivity::class.java)
                resultLauncher.launch(moveForResultIntent)
            }

        }

    }

    private fun debuggingCodeLab(){
        btnSetValue = findViewById(R.id.btn_set_value)
        tvText = findViewById(R.id.tv_text)
        btnSetValue.setOnClickListener(this)
        names.add("Narenda Wicaksono")
        names.add("Kevin")
        names.add("Yoza")
    }
}