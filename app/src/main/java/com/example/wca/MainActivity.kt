package com.example.wca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        val countUsers = 195679
        val begin = 1
        val end = 50
        val service = RetrofitService.makeRetrofitService()
        val adapter: MyAdapter = MyAdapter(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        persons_list.layoutManager = LinearLayoutManager(this)
        persons_list.adapter = adapter

        for (i in begin..end) {
            service.getUserInfo(i).enqueue(object : Callback<JSON_User> {
                override fun onResponse(call: Call<JSON_User>, response: Response<JSON_User>) {
                    if (response.body() != null) {
                        adapter.setListUsers(response.body()!!)
                    }
                }

                override fun onFailure(call: Call<JSON_User>, t: Throwable) {
                    println("Failed")
                }
            })

        }
    }
}
