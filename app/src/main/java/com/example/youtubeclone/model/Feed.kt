package com.example.youtubeclone.model

class Feed{

    var post: Post? = null
    var shorts: ArrayList<Shorts> = ArrayList<Shorts>()

    constructor(post: Post){
        this.post = post
    }

    constructor(shorts: ArrayList<Shorts>){
        this.shorts = shorts
    }
}