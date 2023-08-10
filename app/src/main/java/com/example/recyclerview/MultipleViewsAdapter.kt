package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MultipleViewsAdapter(
    private val items: List<ListItem>
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class HeaderViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(item: ListItem.Header) {
            val textView = itemView.findViewById<TextView>(R.id.tvHeader)
            textView.text = item.text
        }
    }

    inner class TextViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(item: ListItem.TextItem) {
            val textView = itemView.findViewById<TextView>(R.id.tvTextItem)
            textView.text = item.text
        }
    }

    inner class ImageViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(item: ListItem.ImageItem) {
            val imageView = itemView.findViewById<ImageView>(R.id.cr7Iv)
            imageView.setBackgroundResource(item.image)
        }
    }


    override fun getItemViewType(position: Int): Int {
        return when(items[position]) {
            is ListItem.Header -> 0
            is ListItem.TextItem -> 1
            is ListItem.ImageItem -> 2
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            0 -> HeaderViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.header_item, parent, false)
            )
            1 -> TextViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.text_items, parent, false)
            )
            2 -> ImageViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.image_item, parent, false)
            )

            else -> throw IllegalArgumentException("Invalid view type")
        }
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = items[position]) {
            is ListItem.Header -> (holder as HeaderViewHolder).bind(item)
            is ListItem.TextItem -> (holder as TextViewHolder).bind(item)
            is ListItem.ImageItem -> (holder as ImageViewHolder).bind(item)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}