package com.aarafrao.cashflowquadrant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aarafrao.cashflowquadrant.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFirstBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstBinding.inflate (layoutInflater)
        setContentView(binding.root)

        binding.layout1.setOnClickListener {
            val intent: Intent = Intent(this,PdfActivity::class.java)
            startActivity(intent)
        }


    }
}