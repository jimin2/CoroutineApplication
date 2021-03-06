package com.example.coroutineapplication.ui.main

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.coroutineapplication.R
import com.example.coroutineapplication.data.Result
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

// android 클래스 및 lifecycle의 적절한 지점에서 hilt 구성 요소로 인스턴스화 되어 처리됨
// Dagger-Hilt can now inject dependencies in this class.
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

//    private val mainViewModel : MainViewModel by viewModel()

    private val mainViewModel: MainViewModel by viewModels()

//    @Inject lateinit var mainViewModel: MainViewModel

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

                    tv_response.text = data.toString()

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
