package com.moreno.fundamentos

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import com.moreno.fundamentos.databinding.ActivityMainBinding
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    companion object {
        const val TAG_NUM = "aleatorio"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(MainActivity::class.java.simpleName, "onCreate")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//obtener preferencias
        val sharedPreferences = getPreferences(Context.MODE_PRIVATE)
        val preferencesText = sharedPreferences.getString(TAG_NUM, "")
        println(preferencesText)

        val textAnterior = savedInstanceState?.getString(TAG_NUM)
        binding.tvHola.text = textAnterior ?: Random().nextInt().toString()

//        context
        val name = getString(R.string.app_name)
        val dimen = resources.getDimension(R.dimen.margin_medium)
        val drawable = ContextCompat.getDrawable(this, R.drawable.ic_launcher_foreground)
        val color = ContextCompat.getColor(this, R.color.orange)

    }

    override fun onStart() {
        super.onStart()
        Log.d(MainActivity::class.java.simpleName, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(MainActivity::class.java.simpleName, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(MainActivity::class.java.simpleName, "onPause")
    }

    override fun onStop() {
        Log.d(MainActivity::class.java.simpleName, "onStop")
//        almacenar
        val sharedPreferences = getPreferences(Context.MODE_PRIVATE)
        val editPrefs = sharedPreferences.edit()
        editPrefs.putString(TAG_NUM, binding.tvHola.text.toString())
//        guardar
        editPrefs.apply()
        super.onStop()
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(MainActivity::class.java.simpleName, "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(MainActivity::class.java.simpleName, "onDestroy")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString(TAG_NUM, binding.tvHola.text.toString())
        super.onSaveInstanceState(outState)
    }
}