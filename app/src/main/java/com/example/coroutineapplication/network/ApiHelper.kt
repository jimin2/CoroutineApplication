package com.example.coroutineapplication.network

import com.example.coroutineapplication.data.Response

interface ApiHelper {

    suspend fun getTEST(): Response
}