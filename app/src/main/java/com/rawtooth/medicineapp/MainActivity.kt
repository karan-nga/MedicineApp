package com.rawtooth.medicineapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.rawtooth.medicineapp.databinding.ActivityMainBinding
import com.rawtooth.medicineapp.fragments.cart
import com.rawtooth.medicineapp.fragments.user


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.mainRecycler.adapter = RecyclerAdapter(this)
        binding.mainRecycler.layoutManager = LinearLayoutManager(this)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.home ->{
                replaceFragment(user())
            }
            R.id.person -> {
                replaceFragment(user())
            }
            R.id.bag -> {
                replaceFragment(cart())
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun replaceFragment(fragment: Fragment) {
        val tranction = supportFragmentManager.beginTransaction()
        tranction.replace(R.id.fragment_container, fragment)
        tranction.commit()
    }
}