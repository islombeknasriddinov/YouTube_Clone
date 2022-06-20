package com.example.youtubeclone.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubeclone.R
import com.example.youtubeclone.model.Shorts

class ShortAdapter(var context: Context, var items: ArrayList<Shorts>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_short_view,parent,false)
        return ShortsViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val short = items[position]

        if (holder is ShortsViewHolder){
            var iv_photo = holder.iv_photo
            var tv_title = holder.tv_title
            var tv_count = holder.tv_count

            iv_photo.setImageResource(short.photo)
            tv_count.text = short.count
            tv_title.text = short.title
        }
    }

    override fun getItemCount(): Int {
       return items.size
    }

    class ShortsViewHolder(view: View): RecyclerView.ViewHolder(view){
        var iv_photo: ImageView
        var tv_title: TextView
        var tv_count: TextView

        init {
            iv_photo = view.findViewById(R.id.iv_photo)
            tv_count = view.findViewById(R.id.tv_countView)
            tv_title = view.findViewById(R.id.tv_title)
        }
    }
}
