package com.example.atheokegarden.layoutone.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.atheokegarden.R
import com.example.atheokegarden.core.data.remote.response.Current
import com.example.atheokegarden.databinding.ActivityFirstLayoutDetailBinding

class FirstLayoutDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFirstLayoutDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstLayoutDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<Current>(EXTRA_DATA)
        binding.celcius.setText(data?.tempC.toString())
        binding.fahrenheit.setText(data?.tempF.toString())
    }

    companion object{
        const val EXTRA_DATA = "extra_data"
    }
}