package com.example.wca

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


interface RetrofitService {

    @GET("users/{user_id}")
    fun getUserInfo(@Path("user_id") id: Int): Call<JSON_User>
    @GET("persons/{wca_id}")
    fun getPersonInfo(@Path("wca_id") wca_id: String): Call<JSON_Person>
    companion object {
        fun makeRetrofitService() : RetrofitService {

            return Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(RetrofitService::class.java)
        }
        val base_url: String = "https://www.worldcubeassociation.org/api/v0/"
    }

}