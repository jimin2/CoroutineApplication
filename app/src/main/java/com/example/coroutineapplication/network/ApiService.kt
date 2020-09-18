package com.example.coroutineapplication.network

import com.example.coroutineapplication.data.Response
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.http.GET
import javax.inject.Singleton

interface ApiService {

//    @GET("/profile")
    @GET("/db")
    suspend fun getTEST(): Response
}