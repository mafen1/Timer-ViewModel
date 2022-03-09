package com.example.timer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.timer.ViewModel.ViewModel
import com.example.timer.databinding.ActivityMainBinding
import java.util.*

class MainActivity :AppCompatActivity() {
    companion object{
        lateinit var binding: ActivityMainBinding
    }
    private val TAG = "TAG"
    private lateinit var viewmodel: ViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewmodel = ViewModelProvider(this)[ViewModel::class.java]
        binding.btnStop.visibility = View.GONE
        initButton()
    }
    private fun initButton(){
        binding.btnStart.setOnClickListener {
            viewmodel.Timer()

            binding.btnStart.visibility = View.GONE
            binding.btnPause.visibility = View.VISIBLE
            binding.btnStop.visibility = View.VISIBLE
        }

        binding.btnPause.setOnClickListener {
            viewmodel.timer?.cancel()

            binding.btnPause.visibility = View.GONE
            binding.btnStart.visibility = View.VISIBLE
            binding.btnStop.visibility = View.VISIBLE
           


        }
        binding.btnStop.setOnClickListener {

            binding.textView.text = "00"
            binding.btnPause.visibility = View.GONE
            binding.btnStart.visibility = View.VISIBLE

            binding.btnPause.setClickable(false)
            binding.btnStart.setClickable(false)
            binding.btnStop.setClickable(false)
            viewmodel.timer?.cancel()
        }

    }
}