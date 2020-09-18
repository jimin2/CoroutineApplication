package com.example.coroutineapplication.module

import com.example.coroutineapplication.BuildConfig
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

//    @AuthInterceptorOkHttpClient
    @Provides
    fun provideAuthInterceptorOkHttpClient(
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://addb.interpark.com")
            .client(OkHttpClient.Builder()
//            .addInterceptor(get<Interceptor>())
                .addInterceptor( HttpLoggingInterceptor().apply {
                    level = if (BuildConfig.DEBUG) {
                        HttpLoggingInterceptor.Level.BODY
                    } else {
                        HttpLoggingInterceptor.Level.NONE
                    }
                })
                .build())
            .addConverterFactory(GsonConverterFactory.create(
                GsonBuilder()
                    .setLenient()
                    .create()))

            // Observable이나 Single같은 타입을 뱉을 수 있음
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }
}