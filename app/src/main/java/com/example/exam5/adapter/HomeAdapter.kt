package com.example.exam5.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exam5.R
import com.example.exam5.model.Category
import com.example.exam5.model.HomePost

class HomeAdapter(var context: Context, var items:ArrayList<HomePost>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):FeedViewHolder
    {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed_post,parent,false)
        return FeedViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val feed = items[position]
        if (holder is FeedViewHolder){
            val tv_post = holder.tv_post
            val im_post = holder.im_post

            tv_post.text = feed.name
            im_post.setImageResource(feed.image!!)

        }
    }
    override fun getItemCount(): Int {
        return items.size
    }
    class FeedViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tv_post:TextView
        val im_post:ImageView
        init {
            tv_post = view.findViewById(R.id.tv_post)
            im_post = view.findViewById(R.id.im_post)
        }

    }
}