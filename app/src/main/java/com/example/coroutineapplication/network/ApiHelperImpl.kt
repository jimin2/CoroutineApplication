package com.example.coroutineapplication.network

import com.example.coroutineapplication.data.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {

    override suspend fun getTEST(): Response = apiService.getTEST()

}