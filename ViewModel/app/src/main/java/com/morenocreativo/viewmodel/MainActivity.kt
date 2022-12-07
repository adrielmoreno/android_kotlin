package com.morenocreativo.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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

            stateLiveData.observe(this@MainActivity) {
                when (it) {
                    is MainActivityViewModel.MainActivityState.Success -> {
                        binding.pbLoading.visibility = View.INVISIBLE
                        binding.tvState.text = it.num.toString()
                    }
                    is MainActivityViewModel.MainActivityState.Error -> {
                        binding.pbLoading.visibility = View.INVISIBLE
                        binding.tvState.text = it.message
                    }
                    is MainActivityViewModel.MainActivityState.Loading -> {
                        binding.pbLoading.visibility = View.VISIBLE
                    }
                }
            }
        }
    }

    private fun setListener() {
        with(binding) {
            tvText1.setOnClickListener {
                viewModel.cambiarNumeroLiveData()
            }
            tvState.setOnClickListener {
                viewModel.cambiarState()
            }
        }
    }


}