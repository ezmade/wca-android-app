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
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.SearchView



class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {
    private var mFirebaseAnalytics: FirebaseAnalytics? = null

    val adapter: MyAdapter = MyAdapter(this)
    var users: ArrayList<JSON_User> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this)
        val countUsers = 195679
        val begin = 53600
        val end = 54000
        val service = RetrofitService.makeRetrofitService()


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        persons_list.layoutManager = LinearLayoutManager(this)
        persons_list.adapter = adapter

        for (i in begin..end) {
            service.getUserInfo(i).enqueue(object : Callback<JSON_User> {
                override fun onResponse(call: Call<JSON_User>, response: Response<JSON_User>) {
                    if ((response.body() != null) && (response.body()!!.user.wca_id != null)) {
                        adapter.setListUsers(response.body()!!)
                        users.add(response.body()!!)
                    }
                }

                override fun onFailure(call: Call<JSON_User>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "Connection to network was failed!", Toast.LENGTH_LONG).show()
                }
            })

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        val menuItem: MenuItem = menu!!.findItem(R.id.action_search)
        val searchView: SearchView = menuItem.actionView as SearchView
        searchView.setOnQueryTextListener(this)
        return true
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        return false
    }

    override fun onQueryTextChange(newText: String): Boolean {
        val userInput: String = newText.toLowerCase()
        var listUsers: ArrayList<JSON_User> = ArrayList()
        for (user in users) {
            if (user.user.name.toLowerCase().contains(userInput))
                listUsers.add(user)
        }

        adapter.users = listUsers
        adapter.notifyDataSetChanged()
        return true
    }

}
