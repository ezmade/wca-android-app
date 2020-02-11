package com.example.wca

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.rvtutorial.MyAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.net.URL

class MainActivity : AppCompatActivity() {

    val persons: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        val countUsers = 195679
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addPersons()
        persons_list.layoutManager = LinearLayoutManager(this)
        persons_list.adapter = MyAdapter(persons, this)

//        val newurl = URL(gson.fromJson(string[0], JSON::class.java).person.avatar.thumb_url)
//        icon = BitmapFactory.decodeStream(newurl.openConnection().getInputStream())
//        myImageView.setImageBitmap(icon)
    }

    fun addPersons() {

    }




}
