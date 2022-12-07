package com.morenocreativo.listadapaters

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.morenocreativo.listadapaters.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainAdapterCallback {

    private lateinit var binding : ActivityMainBinding
    private val adater = MainAdapter(this)
    private  val list = MutableList(40){
        "Soy el elemento $it"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        createRecycler()

        setListeners()
    }

    private fun setListeners() {
        binding.btnadd.setOnClickListener {
            list.add("Soy el lemento ${list.size}")
            adater.updateList(list)
        }
    }

    private fun createRecycler(){
        adater.updateList(list)
        binding.rvItems.adapter = adater
        binding.rvItems.layoutManager = LinearLayoutManager(this)
    }

    private fun updateTitle( title: String) {
        binding.textView.text = title
    }

    override fun onItemClick(item: String) {
        updateTitle(item)
    }
}