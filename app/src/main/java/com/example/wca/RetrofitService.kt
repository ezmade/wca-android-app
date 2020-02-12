package com.example.wca

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService {
    @GET("users/{user_id}")
    suspend fun getUserInfo(@Path("user_id") id: Int): Response<JSON_User>
    @GET("persons/{wca_id}")
    suspend fun getPersonInfo(@Path("wca_id") wca_id: String): Response<JSON_Person>
}