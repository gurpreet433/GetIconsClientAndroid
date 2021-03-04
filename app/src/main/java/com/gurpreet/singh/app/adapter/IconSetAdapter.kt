package com.gurpreet.singh.app.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.gurpreet.singh.app.data.Iconset
import com.gurpreet.singh.app.databinding.ItemSetSingleItemBinding

class IconSetAdapter: androidx.recyclerview.widget.ListAdapter<Iconset, IconSetAdapter.ViewHolder>(IconSetDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class ViewHolder private constructor(val binding: ItemSetSingleItemBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(item: Iconset) {
            binding.name.text = item.name
            binding.type.text = item.type
            binding.price.text = item.prices[0].price.toString()
            binding.authersName.text = item.author.name
            binding.licenceName.text = item.prices[0].license.name
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemSetSingleItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    class IconSetDiffCallback : DiffUtil.ItemCallback<Iconset>(){
        override fun areItemsTheSame(oldItem: Iconset, newItem: Iconset): Boolean {
            return oldItem.iconsetID == newItem.iconsetID
        }

        override fun areContentsTheSame(oldItem: Iconset, newItem: Iconset): Boolean {
            return oldItem == newItem
        }
    }
}