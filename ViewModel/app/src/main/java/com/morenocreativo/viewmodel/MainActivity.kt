package com.morenocreativo.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.morenocreativo.viewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvText1.text = viewModel.num.toString()
        setObservers()
        setListener()

    }

    private fun setObservers() {
        with(viewModel) {
            numLiveData.observe(this@MainActivity) {
                binding.tvText1.text = it.toString()
            }
        }


    }

    private fun setListener() {
        with(binding) {
            tvText1.setOnClickListener {
                viewModel.cambiarNumeroLiveData()

            }
        }

    }
}