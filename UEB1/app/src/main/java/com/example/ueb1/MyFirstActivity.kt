package com.example.ueb1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class MyFirstActivity : AppCompatActivity() {


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            Log.d("TAG", "123 Test")




            val myButton: Button = findViewById(R.id.hello_world_button)
           myButton.setOnClickListener {
                Log.d("TAG", "Hello World!")
                val textfield: EditText = findViewById(R.id.activity_main_edit_text)
                val text = textfield.text.toString()
                val intent = Intent(this, Main2Activity::class.java)
               intent.putExtra("text", text)

               startActivity(intent)
            }










        }
    }

