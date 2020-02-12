package com.example.wca

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.persons_list_item.*

class MainActivity : AppCompatActivity() {

    val persons: ArrayList<JSON> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        val countUsers = 195679
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addPersons()
        persons_list.layoutManager = LinearLayoutManager(this)
        persons_list.adapter = MyAdapter(persons, this)

    }

    fun addPersons() {
        val gson = Gson()
        for (person in getJSON()) {
            persons.add(gson.fromJson(person, JSON::class.java))
        }
    }
}
