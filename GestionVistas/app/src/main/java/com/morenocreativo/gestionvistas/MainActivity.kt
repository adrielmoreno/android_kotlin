package com.morenocreativo.gestionvistas

import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.morenocreativo.gestionvistas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setListener()

    }

    private fun setListener() {
        binding.root.setOnClickListener {
            showToast("Layout Click")
//            Cerrar el teclado
            val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(binding.root.windowToken, 0)

        }
        binding.btnClick.setOnClickListener { showToast("Normal Click") }
        binding.btnLongClick.setOnLongClickListener {
            showToast("Long click")
            true
        }
        binding.etText.doAfterTextChanged { showToast(binding.etText.text.toString()) }

//        controll text
        with(binding){

            etText1.setOnFocusChangeListener { _, focused ->
                if (focused) tvCurrentInteraction.text = "et1"
            }
            etText2.setOnFocusChangeListener { _, focused ->
                if (focused) tvCurrentInteraction.text = "et2"
            }

            etText1.doAfterTextChanged {
                btnAddText.isEnabled = etText1.text.isNotEmpty() && etText2.text.isNotEmpty()
            }
            etText2.doAfterTextChanged {
                btnAddText.isEnabled = etText1.text.isNotEmpty() && etText2.text.isNotEmpty()
            }
            btnAddText.setOnClickListener {
                etText1.setText("${etText1.text}  ${etText2.text}")
                etText2.setText("")
            }
        }


    }

    private fun showToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }



}