package com.example.youtubeclone.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubeclone.R
import com.example.youtubeclone.model.Feed
import com.example.youtubeclone.model.Shorts
import com.google.android.material.imageview.ShapeableImageView


class FeedAdapter(var context: Context, var items: ArrayList<Feed>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object{
        private val TYPE_ITEM_VIDEO = 1
        private val TYPE_ITEM_SHORT = 4
    }

    override fun getItemViewType(position: Int): Int {
        return if (items[position].shorts.size>0){
            return TYPE_ITEM_SHORT
        }  else {
            return TYPE_ITEM_VIDEO
        }
    }

    fun shorts(position: Int): Boolean {
        return position == 4
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_ITEM_SHORT) {
            var view = LayoutInflater.from(parent.context).inflate(R.layout.item_short_recycler, parent, false)
            return ShortsViewHolder(context, view)
        }

        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed_video, parent, false)
        return FeedViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val feed = items[position]

        if (holder is ShortsViewHolder) {
            var recyclerView = holder.recyclerView
            refreshAdapter(feed.shorts, recyclerView)
        }

        if (holder is FeedViewHolder) {
            var iv_profile = holder.iv_profile
            var iv_video = holder.iv_video

            iv_profile.setImageResource(feed.post!!.profile)
            iv_video.setImageResource(feed.post!!.photo)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun refreshAdapter(shorts: ArrayList<Shorts>, recyclerView: RecyclerView) {
        val adapter = ShortAdapter(context, shorts)
        recyclerView.adapter = adapter
    }

    class ShortsViewHolder(context: Context, view: View) : RecyclerView.ViewHolder(view) {
        var recyclerView: RecyclerView

        init {
            recyclerView = view.findViewById(R.id.recyclerView)
            val manager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            recyclerView.setLayoutManager(manager)
        }
    }

    class FeedViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        var iv_profile: ShapeableImageView
        var iv_video: ImageView

        init {
            iv_profile = view.findViewById(R.id.iv_profile1)
            iv_video = view.findViewById(R.id.iv_video)
        }
    }
}