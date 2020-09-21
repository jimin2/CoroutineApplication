package com.example.coroutineapplication.di.module

import com.example.coroutineapplication.BuildConfig
import com.example.coroutineapplication.data.api.ApiService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// koin에서 사용
// 레트로핏 객체에 대한 모듈
val retrofitModule = module {

    single {
        OkHttpClient.Builder()
//            .addInterceptor(get<Interceptor>())
            .addInterceptor(get<HttpLoggingInterceptor>())
            .build()
    }

//    single {
//        Interceptor { chain: Interceptor.Chain ->
//            val original = chain.request()
//            chain.proceed(original.newBuilder().apply {
//                addHeader("Authorizaion_Header", "access_token")
//            }.build())
//        }
//    }

    single {
        HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }
    }

    single {
        GsonBuilder()
            .setLenient()
            .create()
    }

    single {
        Retrofit.Builder()
            .baseUrl("https://addb.interpark.com")
            .client(get())
            .addConverterFactory(GsonConverterFactory.create(get<Gson>()))

            // Observable이나 Single같은 타입을 뱉을 수 있음
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    single {
        get<Retrofit>().create(
            ApiService::class.java
        )
    }

}