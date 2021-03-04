package com.gurpreet.singh.app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.gurpreet.singh.app.R
import com.gurpreet.singh.app.data.Iconset

class IconSetAdapter: androidx.recyclerview.widget.ListAdapter<Iconset, IconSetAdapter.ViewHolder>(IconSetDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class ViewHolder private constructor(itemView: View): RecyclerView.ViewHolder(itemView){
        val name: TextView = itemView.findViewById(R.id.name)
        val type: TextView = itemView.findViewById(R.id.type)
        val price: TextView = itemView.findViewById(R.id.price)
        val authersName: TextView = itemView.findViewById(R.id.authers_name)
        val licenceName: TextView = itemView.findViewById(R.id.licence_name)

        fun bind(item: Iconset) {
            name.text = item.name
            type.text = item.type
            price.text = item.prices[0].price.toString()
            authersName.text = item.author.name
            licenceName.text = item.prices[0].license.name
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_set_single_item, parent, false)
                return ViewHolder(layoutInflater)
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