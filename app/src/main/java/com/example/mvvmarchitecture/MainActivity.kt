package com.example.mvvmarchitecture

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.mvvmarchitecture.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btRatrofitShowList.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, ShowlistActivity::class.java))
        })
    }
}