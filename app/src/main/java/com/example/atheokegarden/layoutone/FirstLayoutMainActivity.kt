package com.example.atheokegarden.layoutone

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.atheokegarden.R
import com.example.atheokegarden.core.data.remote.response.Current
import com.example.atheokegarden.core.utils.ViewModelFactory
import com.example.atheokegarden.databinding.ActivityFirstLayoutMainBinding
import com.example.atheokegarden.layoutone.detail.FirstLayoutDetailActivity

class FirstLayoutMainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityFirstLayoutMainBinding
    private lateinit var viewModel: ViewModelFirstMainLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstLayoutMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val country = resources.getStringArray(R.array.country)
        val arrayAdapter = ArrayAdapter(this, R.layout.drop_down, country)
        binding.autocompletetext.setAdapter(arrayAdapter)

        val factory = ViewModelFactory.getInstance()
        viewModel = ViewModelProvider(this, factory)[ViewModelFirstMainLayout::class.java]

        binding.btnSubmit.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btn_submit -> {
                val country = binding.txtDropdown.editText?.text
                viewModel.data("ff9f895b2e884d6680530135202710", "$country").observe(this) { data ->

                    Log.d("tesva", data.tempC.toString())
                    val dataMove = Current(
                        tempC = data.tempC?.toDouble(),
                        tempF = data.tempF?.toDouble()
                    )
                    val move = Intent(this, FirstLayoutDetailActivity::class.java)
                    move.putExtra(FirstLayoutDetailActivity.EXTRA_DATA, dataMove)
                    startActivity(move)
                }
            }

        }
    }
}