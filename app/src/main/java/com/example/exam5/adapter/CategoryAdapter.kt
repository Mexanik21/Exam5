package com.example.exam5.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.exam5.R
import com.example.exam5.model.Category

class CategoryAdapter(var context: Context,var items: ArrayList<Category>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_catigories_view,parent,false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var category = items[position]
        if (holder is CategoryViewHolder){
            val im_catergory = holder.im_catergory
            val tv_category = holder.tv_category

            im_catergory.setImageResource(category.image)
            tv_category.text = category.name

        }
    }

    override fun getItemCount(): Int {
       return items.size
    }
    class CategoryViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val im_catergory:ImageView
        val tv_category:TextView
        init {
            im_catergory = view.findViewById(R.id.im_category)
            tv_category = view.findViewById(R.id.tv_category)
        }

    }

}
