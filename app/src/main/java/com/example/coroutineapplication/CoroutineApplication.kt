package com.example.coroutineapplication

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

// 컴파일 타임시 표준 컴포넌트 빌딩에 필요한 클래스들을 초기화
@HiltAndroidApp
class CoroutineApplication : Application() {
    override fun onCreate() {
        super.onCreate()

//        // Start Koin
//        startKoin {
//
//            androidLogger(Level.ERROR)
//
//            androidContext(this@CoroutineApplication)
//
//            modules(
//                retrofitModule,
//                appModule,
//                viewModelModule
//            )
//        }
    }
}