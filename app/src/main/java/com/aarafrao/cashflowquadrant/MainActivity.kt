package com.aarafrao.cashflowquadrant

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val handler = Handler()
        val runnableCode: Runnable = object : Runnable {
            override fun run() {
                val intent: Intent = Intent(this@MainActivity, FirstActivity::class.java)
                startActivity(intent)
                handler.postDelayed(this, 3000)
            }
        }
        handler.post(runnableCode)
    }
}