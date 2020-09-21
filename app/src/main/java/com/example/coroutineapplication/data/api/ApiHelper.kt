package com.example.coroutineapplication.data.api

import com.example.coroutineapplication.data.model.Response

// hilt에서 사용
interface ApiHelper {
    suspend fun getTEST(): Response
}