package com.example.atheokegarden

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.atheokegarden.databinding.ActivityMainBinding
import com.example.atheokegarden.layoutone.FirstLayoutMainActivity
import com.example.atheokegarden.layoutone.detail.FirstLayoutDetailActivity
import com.example.atheokegarden.secondlayout.SecondLayoutActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        startActivity(Intent(this, FirstLayoutMainActivity::class.java))
    }
}