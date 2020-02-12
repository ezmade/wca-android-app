package com.example.wca

import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Response

fun main() {
    val service = RetrofitFactory.makeRetrofitService()
    CoroutineScope(Dispatchers.IO).launch {
        var responce: Response<JSON_User>
        for (i in 1..5) {
            responce = service.getUserInfo(i)
            withContext(Dispatchers.Main) {
                try {
                    if (responce.isSuccessful) {
                        println(responce)
                    } else {
                        println("Error: ${responce.code()}")
                    }
                } catch (e: HttpException) {
                    println("Exception ${e.message}")
                } catch (e: Throwable) {
                    println("Ooops: Something else went wrong")
                }
            }
        }

    }
}


