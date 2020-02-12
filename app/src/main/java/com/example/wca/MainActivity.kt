package com.example.wca

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.persons_list_item.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    val persons: ArrayList<JSON_Person> = ArrayList()

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
        val service = RetrofitFactory.makeRetrofitService()
        CoroutineScope(Dispatchers.IO).launch {
            var responce: Response<JSON_User>
            for (i in 1..5) {
                responce = service.getUserInfo(i)
                withContext(Dispatchers.Main) {
                    try {
                        if (responce.isSuccessful) {
                            Toast.makeText(MainActivity(), responce.message().toString(), Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(MainActivity(), "Error: ${responce.code()}", Toast.LENGTH_SHORT).show()
                        }
                    } catch (e: HttpException) {
                        Toast.makeText(MainActivity(), "Exception ${e.message}", Toast.LENGTH_SHORT).show()
                    } catch (e: Throwable) {
                        Toast.makeText(MainActivity(), "Ooops: Something else went wrong", Toast.LENGTH_SHORT).show()
                    }
                }
            }

        }

//        for (person in getJSON()) {
//            persons.add(gson.fromJson(person, JSON::class.java))
//        }
    }
}
