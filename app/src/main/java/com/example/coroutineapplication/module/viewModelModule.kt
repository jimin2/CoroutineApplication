package com.example.coroutineapplication.module

import com.example.coroutineapplication.viewmodel.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

// ViewModel 에 대한 모듈
val viewModelModule = module {
    // MyViewModel ViewModel
    viewModel { MainViewModel(get()) }
}