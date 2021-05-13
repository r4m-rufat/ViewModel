package com.codingwithrufat.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity(), LifecycleObserver {

    private lateinit var addButton: Button
    private lateinit var textView: TextView
    private lateinit var textViewWithViewModel: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addButton = findViewById(R.id.addButton)
        textView = findViewById(R.id.number_text)
        textViewWithViewModel = findViewById(R.id.numberWithViewModel)

        var viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        textViewWithViewModel.text = viewModel.number.toString()

        var number = 0
        addButton.setOnClickListener {

            number++

            textView.text = number.toString()

            viewModel.addNumber()
            textViewWithViewModel.text = viewModel.number.toString()

        }

    }


}