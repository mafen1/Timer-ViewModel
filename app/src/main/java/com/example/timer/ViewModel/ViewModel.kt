package com.example.timer.ViewModel

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.timer.MainActivity.Companion.binding

class ViewModel: ViewModel() {

    var timer: CountDownTimer? = null
    var countTime: Long = 45000
    val count = 0

    fun Timer(){
        timer =  object : CountDownTimer(countTime, 1000) {
            override fun onTick(p0: Long) {
                binding.textView.text = "${p0/ 1000}"
                countTime = p0
            }
            override fun onFinish() {
                binding.textView.text = "Finish"
            }
        }.start()
    }

}