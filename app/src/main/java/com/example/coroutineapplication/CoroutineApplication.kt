package com.example.coroutineapplication

import android.app.Application
import com.example.coroutineapplication.module.appModule
import com.example.coroutineapplication.module.retrofitModule
import com.example.coroutineapplication.module.viewModelModule
import dagger.hilt.android.HiltAndroidApp
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

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