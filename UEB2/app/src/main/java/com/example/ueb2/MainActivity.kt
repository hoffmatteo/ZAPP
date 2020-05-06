package com.example.ueb2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)



        val mList: LinkedList<String> = LinkedList()
        val rnd = Random()
        for (i in 0..49) mList.add(
            ('A' + rnd.nextInt('Z' - 'A')).toString() + " " +
                    i.toString()
        )
        mList.sort()


        var mRecyclerView: RecyclerView = findViewById(R.id.recyclerview)
        var mAdapter= ListAdapter(this, mList)
        mRecyclerView.adapter = mAdapter
        mRecyclerView.layoutManager = LinearLayoutManager(this)


    }



}
