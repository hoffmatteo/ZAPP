package com.example.ueb1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var text = intent.getStringExtra("text")

        val textview: TextView = findViewById<TextView>(R.id.textview_id)
        textview.setText(text)


    }
}
