package com.example.coroutineapplication.network

import com.example.coroutineapplication.data.Response
import retrofit2.http.GET

interface ApiService {

//    @GET("https://jimin-test.herokuapp.com/profile")
    @GET("https://jimin-test.herokuapp.com/db")
    suspend fun getTEST(): Response

}