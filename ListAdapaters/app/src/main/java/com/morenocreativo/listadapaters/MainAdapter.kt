package com.morenocreativo.listadapaters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.morenocreativo.listadapaters.databinding.MainItemBinding

interface MainAdapterCallback {
    fun onItemClick(item: String)
}

class MainAdapter(var callback: MainAdapterCallback) :
    RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    private var items = listOf<String>()

    inner class MainViewHolder(private val binding: MainItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String, position: Int) {
            if (position % 2 == 0) {
                binding.tvName.textAlignment = View.TEXT_ALIGNMENT_TEXT_START
                binding.tvAge.textAlignment = View.TEXT_ALIGNMENT_TEXT_START
            } else {
                binding.tvName.textAlignment = View.TEXT_ALIGNMENT_TEXT_END
                binding.tvAge.textAlignment = View.TEXT_ALIGNMENT_TEXT_END
            }

            binding.tvName.text = item
            binding.tvAge.text = "$position"
            binding.root.setOnClickListener {
                Toast.makeText(binding.root.context, item, Toast.LENGTH_SHORT).show()
                callback.onItemClick(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            MainItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        if (position >= items.size)
            holder.bind("Soy el último y no estoy en la lista", position)
        else
            holder.bind(items[position], position)
    }

    override fun getItemCount(): Int {
        return items.size + 1
    }

    fun updateList(list: List<String>) {
        items = list
//        show reView
        notifyDataSetChanged()
    }


}