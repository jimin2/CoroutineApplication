package com.example.coroutineapplication.di.module

import com.example.coroutineapplication.ui.main.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

// koin에서 사용
// ViewModel 에 대한 모듈
val viewModelModule = module {
    // MyViewModel ViewModel
    viewModel { MainViewModel(get()) }
}