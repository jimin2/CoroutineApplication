package com.example.testapplication.network

import com.example.testapplication.model.Response
import retrofit2.http.GET

interface ApiService {

    @GET("https://jimin-test.herokuapp.com/db")
    suspend fun getTEST(): Response

}