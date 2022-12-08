package com.morenocreativo.viewmodel

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import com.morenocreativo.viewmodel.databinding.ActivitySecondBinding
import com.morenocreativo.viewmodel.model.Numbers

class SecondActivity : AppCompatActivity() {

    companion object {
        private const val TAG_TEXT = "TAG_TEXT"
        fun launch(context: Context, numbers: Numbers) {
            val intent = Intent(context, SecondActivity::class.java)
            val numberString = Gson().toJson(numbers)
            intent.putExtra(TAG_TEXT, numberString)
            context.startActivity(intent)
        }
    }

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val textReceived = intent.getStringExtra(TAG_TEXT)
        val number = Gson().fromJson(textReceived, Numbers::class.java)
        binding.textView.text = "Los numeros son: ${number.num1} ${number.num2}"
    }
}