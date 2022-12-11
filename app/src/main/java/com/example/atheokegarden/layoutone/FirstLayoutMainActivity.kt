package com.example.atheokegarden.layoutone

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.atheokegarden.R
import com.example.atheokegarden.core.data.remote.response.Current
import com.example.atheokegarden.databinding.ActivityFirstLayoutMainBinding
import com.example.atheokegarden.layoutone.detail.FirstLayoutDetailActivity
import com.jakewharton.rxbinding2.widget.RxTextView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirstLayoutMainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityFirstLayoutMainBinding
    private val viewModel: ViewModelFirstMainLayout by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstLayoutMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val country = resources.getStringArray(R.array.country)
        val arrayAdapter = ArrayAdapter(this, R.layout.drop_down, country)
        binding.autocompletetext.setAdapter(arrayAdapter)
        binding.btnSubmit.setOnClickListener(this)
        val emailStream = RxTextView.textChanges(binding.autocompletetext)
            .skipInitialValue()
            .map { text ->
                text.length > 1
            }
        emailStream.subscribe {
            if (it) {
                binding.btnSubmit.isEnabled = true
                binding.btnSubmit.background = ContextCompat.getDrawable(
                    this,
                    R.drawable.bg_btn_enable
                )
            } else {
                binding.btnSubmit.isEnabled = false
                binding.btnSubmit.background = ContextCompat.getDrawable(
                    this,
                    R.drawable.bg_btn_disable
                )
            }
        }
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btn_submit -> {
                val country = binding.txtDropdown.editText?.text
                val key = binding.txtApi.editText?.text
                viewModel.data(key = key.toString(), "$country").observe(this) { data ->

                    if (data != null) {
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
}