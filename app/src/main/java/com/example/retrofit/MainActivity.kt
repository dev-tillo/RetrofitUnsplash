package com.example.retrofit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val countDownTimer = object : CountDownTimer(2000, 100) {
            override fun onTick(p0: Long) {

            }

            override fun onFinish() {
                val intent = Intent(this@MainActivity, Splash::class.java)
                startActivity(intent)
                finish()
            }
        }
        countDownTimer.start()
    }
}