package com.example.exam5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.exam5.fragments.CollectionsFragment
import com.example.exam5.fragments.HomeFragment
import com.example.exam5.fragments.MessagesFragment
import com.example.exam5.fragments.SearchFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var navigationView:BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }
    private fun initViews() {
        navigationView = findViewById(R.id.bottomNavigationView)
        val homeFragment = HomeFragment()
        val collectionsFragment = CollectionsFragment()
        val messagesFragment = MessagesFragment()
        val searchFragment = SearchFragment()
        raplaceFragment(homeFragment)
        navigationView.setOnNavigationItemReselectedListener { item ->
            when(item.itemId){
                R.id.home -> raplaceFragment(homeFragment)
                R.id.collections -> raplaceFragment(collectionsFragment)
                R.id.chat -> raplaceFragment(messagesFragment)
                R.id.search -> raplaceFragment(searchFragment)
            }
            true
        }
    }

    private fun raplaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frame_layout,fragment)
            commit()
        }
    }


}