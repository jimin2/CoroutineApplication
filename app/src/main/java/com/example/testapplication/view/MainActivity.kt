package com.example.testapplication.view

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.testapplication.R
import com.example.testapplication.viewmodel.MainViewModel
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

        mainViewModel.resultResponse.observe(this, Observer {
            Log.d("jmlee", "Response = ${it.toString()}")
            Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
        })
    }
}
