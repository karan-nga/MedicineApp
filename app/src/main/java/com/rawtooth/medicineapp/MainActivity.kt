package com.rawtooth.medicineapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rawtooth.medicineapp.databinding.ActivityMainBinding
import com.rawtooth.medicineapp.fragments.user

import com.synnapps.carouselview.ImageListener

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private var layoutManager:RecyclerView.LayoutManager?=null
    private var adapter:RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null
    private val user=user()
    private val cart=com.rawtooth.medicineapp.fragments.cart()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        layoutManager=LinearLayoutManager(this)
        binding.mainRecycler.layoutManager=layoutManager
        adapter=RecyclerAdapter()
        binding.mainRecycler.adapter=adapter

        binding.bottomNav.setOnNavigationItemReselectedListener {
            when(it.itemId){
                R.id.person -> replaceFragment(user)
                R.id.bag -> replaceFragment(cart)
            }

        }
    }
    private fun replaceFragment(fragment: Fragment){
        if(fragment!=null){
            val tranction=supportFragmentManager.beginTransaction()
            tranction.replace(R.id.fragment_container,fragment)
            tranction.commit()
        }
    }
}