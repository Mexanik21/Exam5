package com.example.exam5.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exam5.R
import com.example.exam5.adapter.CategoryAdapter
import com.example.exam5.adapter.HomeAdapter
import com.example.exam5.model.Category
import com.example.exam5.model.HomePost

class HomeFragment: Fragment() {
    lateinit var recyclerHomePost: RecyclerView
    lateinit var recyclerCatageries:RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View = inflater.inflate(R.layout.fragment_home, container, false)
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
    }

    private fun initViews(view: View) {
        recyclerHomePost = view.findViewById(R.id.recyclerHome)
        recyclerHomePost.layoutManager = GridLayoutManager(requireContext(),2)
        refreshAdapter(getAllFeeds(),requireContext())
        recyclerCatageries = view.findViewById(R.id.recyclerCategories)
        recyclerCatageries.layoutManager =
            LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        refreshCategoryAdapter(getAllCategories(),requireContext())
    }

    private fun refreshCategoryAdapter(categories:ArrayList<Category>,context: Context) {
        val adapter = CategoryAdapter(context,categories)
        recyclerCatageries.adapter = adapter
    }

    private fun refreshAdapter(feeds: ArrayList<HomePost>,context: Context) {
        val adapter = HomeAdapter(context,feeds)
        recyclerHomePost.adapter = adapter

    }
    private fun getAllCategories():ArrayList<Category>{
        val categories:ArrayList<Category> = ArrayList()
        categories.add(Category(R.drawable.ic_launcher_background,"Resturant"))
        categories.add(Category(R.drawable.ic_launcher_background,"Resturant"))
        categories.add(Category(R.drawable.ic_launcher_background,"Resturant"))
        categories.add(Category(R.drawable.ic_launcher_background,"Resturant"))
        categories.add(Category(R.drawable.ic_launcher_background,"Resturant"))
        categories.add(Category(R.drawable.ic_launcher_background,"Resturant"))
        categories.add(Category(R.drawable.ic_launcher_background,"Resturant"))
        return categories
    }

    private fun getAllFeeds(): ArrayList<HomePost> {
         val feeds:ArrayList<HomePost> = ArrayList()
        feeds.add(HomePost("Kamolon",R.drawable.ic_launcher_background))
        feeds.add(HomePost("Kamolon",R.drawable.ic_launcher_background))
        feeds.add(HomePost("Kamolon",R.drawable.ic_launcher_background))
        feeds.add(HomePost("Kamolon",R.drawable.ic_launcher_background))
        feeds.add(HomePost("Kamolon",R.drawable.ic_launcher_background))
        feeds.add(HomePost("Kamolon",R.drawable.ic_launcher_background))
        feeds.add(HomePost("Kamolon",R.drawable.ic_launcher_background))
        feeds.add(HomePost("Kamolon",R.drawable.ic_launcher_background))
        feeds.add(HomePost("Kamolon",R.drawable.ic_launcher_background))
        return feeds

    }


}