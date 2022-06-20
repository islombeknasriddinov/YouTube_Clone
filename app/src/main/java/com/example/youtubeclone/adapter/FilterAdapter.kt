package com.example.youtubeclone.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubeclone.R
import com.example.youtubeclone.model.Filter

class FilterAdapter(var context: Context, var items: ArrayList<Filter>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val TYPE_ITEM_HEADER = 1
    private val TYPE_ITEM_VIEW = 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_ITEM_HEADER){
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_header_filter,parent,false)
            return HeaderViewHolder(view)
        }

        val  view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed_filter, parent,false)
        return FilterViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return if (isHeader(position))TYPE_ITEM_HEADER  else TYPE_ITEM_VIEW
    }

    fun isHeader(position: Int): Boolean{
        return position == 0
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val filter = items[position]

        if (holder is FilterViewHolder){
            var tv_title = holder.tv_title

            tv_title.text = filter.title
        }

        if (holder is HeaderViewHolder){
            var tv_title = holder.tv_title

            tv_title.text = filter.title
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class FilterViewHolder(view: View): RecyclerView.ViewHolder(view){
        var tv_title: TextView

        init {
            tv_title = view.findViewById(R.id.tv_title)
        }
    }

    class HeaderViewHolder(view: View): RecyclerView.ViewHolder(view){
        var tv_title: TextView

        init {
            tv_title = view.findViewById(R.id.tv_title)
        }
    }
}