package com.example.youtubeclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubeclone.adapter.FeedAdapter
import com.example.youtubeclone.adapter.FilterAdapter
import com.example.youtubeclone.model.Feed
import com.example.youtubeclone.model.Filter
import com.example.youtubeclone.model.Post
import com.example.youtubeclone.model.Shorts

class MainActivity : AppCompatActivity() {
    lateinit var recyclerFilter: RecyclerView
    lateinit var recyclerFeed: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        recyclerFeed = findViewById(R.id.recyclerFeed)
        recyclerFeed.setLayoutManager(GridLayoutManager(this, 1))
        recyclerFilter = findViewById(R.id.recyclerFilter)
        recyclerFilter.setLayoutManager(LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false))


        refreshStoryAdapter(getAllFilters())
        refreshFeedAdapter(getAllFeeds())
    }

    private fun getAllFeeds(): ArrayList<Feed> {
        val shorts: ArrayList<Shorts> = ArrayList<Shorts>()

        shorts.add(Shorts(R.drawable.profile_photo, "Miyagi & Andy Panda - Utopia (Snippet) #YAMAKASICHALLENGE", "764 тыс. просмотра"))
        shorts.add(Shorts(R.drawable.shorts1, "Хабибулин Артем, разминочная попитка", "17 млн. просмотра"))
        shorts.add(Shorts(R.drawable.shorts2, "Кошка Софа выпрыгнула в окно?!", "13 млн. просмотра"))
        shorts.add(Shorts(R.drawable.shorts3, "Заказчик отказался от кроссовок!!!\uD83D\uDE31\uD83D\uDE31\uD83D\uDE31\uD83D\uDE31\uD83D\uDE31\uD83D\uDE31", "3 млн. просмотра"))
        shorts.add(Shorts(R.drawable.shorts4, "Как снять дверницу духового шкафа? #Shorts", "1.1 тыс. просмотра"))



        val feeds: ArrayList<Feed> = ArrayList<Feed>()

        feeds.add(Feed(Post(R.drawable.profile_photo, R.drawable.android)))
        feeds.add(Feed(Post(R.drawable.profile_photo, R.drawable.android)))
        feeds.add(Feed(Post(R.drawable.profile_photo, R.drawable.android)))
        feeds.add(Feed(shorts))
        feeds.add(Feed(Post(R.drawable.profile_photo, R.drawable.android)))
        feeds.add(Feed(Post(R.drawable.profile_photo, R.drawable.android)))
        feeds.add(Feed(Post(R.drawable.profile_photo, R.drawable.android)))
        feeds.add(Feed(Post(R.drawable.profile_photo, R.drawable.android)))
        feeds.add(Feed(Post(R.drawable.profile_photo, R.drawable.android)))
        feeds.add(Feed(Post(R.drawable.profile_photo, R.drawable.android)))
        feeds.add(Feed(Post(R.drawable.profile_photo, R.drawable.android)))


        return feeds
    }

    private fun getAllFilters(): ArrayList<Filter> {
        val filters: ArrayList<Filter> = ArrayList<Filter>()

        filters.add(Filter("Explore"))
        filters.add(Filter("Computer Programming"))
        filters.add(Filter("Android Native"))
        filters.add(Filter("Mobile Development"))

        return filters
    }

    private fun refreshFeedAdapter(feeds: ArrayList<Feed>) {
        val adapter = FeedAdapter(this, feeds)
        recyclerFeed!!.adapter = adapter
    }

    private fun refreshStoryAdapter(chats: ArrayList<Filter>) {
        val adapter = FilterAdapter(this, chats)
        recyclerFilter!!.adapter = adapter
    }


}