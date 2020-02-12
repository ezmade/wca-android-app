package com.example.wca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    var users: ArrayList<JSON_User> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        val countUsers = 195679
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addUsers(1, 200)
        persons_list.layoutManager = LinearLayoutManager(this)
        persons_list.adapter = MyAdapter(users, this)

    }

    fun addUsers(begin: Int, end: Int) {
        for (i in begin..end) {
            val service = RetrofitService.makeRetrofitService()
            service.getUserInfo(i).enqueue(object : Callback<JSON_User> {
                override fun onResponse(call: Call<JSON_User>, response: Response<JSON_User>) {
                    if (response.body() != null) {
                        users.add(response.body()!!)
                    }
                }

                override fun onFailure(call: Call<JSON_User>, t: Throwable) {
                    println("Failed")
                }
            })
        }
    }
}
