package com.example.coroutineapplication.data.api

import com.example.coroutineapplication.data.model.Response
import javax.inject.Inject

// hilt에서 사용
class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {
    override suspend fun getTEST(): Response = apiService.getTEST()
}