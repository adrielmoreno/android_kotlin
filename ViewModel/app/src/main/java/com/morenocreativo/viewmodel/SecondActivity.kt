package com.morenocreativo.viewmodel

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.morenocreativo.viewmodel.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    companion object {
        private const val TAG_TEXT = "TAG_TEXT"
        fun launch(context: Context, text: String) {
            val intent = Intent(context, SecondActivity::class.java)
            intent.putExtra(TAG_TEXT, text)
            context.startActivity(intent)
        }
    }

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val textReceived = intent.getStringExtra(TAG_TEXT)
        binding.textView.text = textReceived
    }
}