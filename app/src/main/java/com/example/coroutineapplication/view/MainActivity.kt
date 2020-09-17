package com.example.coroutineapplication.view

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.coroutineapplication.R
import com.example.coroutineapplication.network.Result
import com.example.coroutineapplication.viewmodel.MainViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainViewModel : MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.loadData()

        mainViewModel.toastMsg.observe(this, Observer {
            Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
        })

        mainViewModel.resultResponse.observe(this, Observer { data ->
            when (data) {
                // 성공
                is Result.Success -> {
                    when (data.data.profile?.age) {
                        is String -> Log.d(TAG, "age is String")
                        is Int -> Log.d(TAG, "age is Int")
                        is Float -> Log.d(TAG, "age is Float")
                        is Double -> Log.d(TAG, "age is Double")
                        is Any -> Log.d(TAG, "age is Any")
                    }

                    Toast.makeText(this, data.toString(), Toast.LENGTH_SHORT).show()
                }

                // 실패
                is Result.Error -> Toast.makeText(this, data.exception, Toast.LENGTH_SHORT).show()
            }
        })
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}
