package com.example.atheokegarden.layoutone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.atheokegarden.R
import com.example.atheokegarden.databinding.ActivityFirstLayoutMainBinding

class FirstLayoutMainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFirstLayoutMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstLayoutMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val country = resources.getStringArray(R.array.country)
        val arrayAdapter = ArrayAdapter(this, R.layout.drop_down, country)
        binding.autocompletetext.setAdapter(arrayAdapter)
    }
}