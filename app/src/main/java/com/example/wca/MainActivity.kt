package com.example.wca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.analytics.FirebaseAnalytics
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private var mFirebaseAnalytics: FirebaseAnalytics? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this)
        val countUsers = 195679
        val begin = 1
        val end = 1000
        val service = RetrofitService.makeRetrofitService()
        val adapter: MyAdapter = MyAdapter(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        persons_list.layoutManager = LinearLayoutManager(this)
        persons_list.adapter = adapter

        for (i in begin..end) {
            service.getUserInfo(i).enqueue(object : Callback<JSON_User> {
                override fun onResponse(call: Call<JSON_User>, response: Response<JSON_User>) {
                    if ((response.body() != null) && (response.body()!!.user.wca_id != null)) {
                        adapter.setListUsers(response.body()!!)
                    }
                }

                override fun onFailure(call: Call<JSON_User>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "Connection to network was failed!", Toast.LENGTH_LONG).show()
                }
            })

        }
    }
}
