package com.example.atheokegarden.layoutone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
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
//        viewModel.data.observe(this){data ->
//            Toast.makeText(this, "celcius ${data.tempC}, farhaneit ${data.tempF}", Toast.LENGTH_SHORT).show()
//        }
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.btn_submit -> {
                val country = binding.txtDropdown.editText?.text
//                viewModel.getSuhu("ff9f895b2e884d6680530135202710","Singapore")
                viewModel.data("ff9f895b2e884d6680530135202710","$country").observe(this){data ->
                    Toast.makeText(this, "celcius ${data.current?.tempC.toString()}, farhaneit ${data.current?.tempF.toString()}", Toast.LENGTH_SHORT).show()

                    val dataMove = Current(
                        tempC = data.current?.tempC,
                        tempF = data.current?.tempF
                    )
                    val move = Intent(this, FirstLayoutDetailActivity::class.java)
                    move.putExtra(FirstLayoutDetailActivity.EXTRA_DATA, dataMove)
                    startActivity(move)
                }
            }

        }
    }
}