package com.rawtooth.medicineapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.rawtooth.medicineapp.databinding.MainActivity2Binding
import com.rawtooth.medicineapp.fragments.cart
import com.rawtooth.medicineapp.fragments.user
import com.rawtooth.medicineapp.ui.mainfragment2.HomeFragment

class MainActivity2 : AppCompatActivity() {
    lateinit var MainBinding:MainActivity2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainBinding= MainActivity2Binding.inflate(layoutInflater)
        setContentView(MainBinding.root)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, HomeFragment.newInstance())
                .commitNow()
        }
        MainBinding.bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.person ->replaceFragment(user())
                R.id.bag ->replaceFragment(cart())
                R.id.home ->replaceFragment(HomeFragment())
            }
            true
        }


        }
    private fun replaceFragment(fragment: Fragment) {
        val tranction = supportFragmentManager.beginTransaction()
        tranction.replace(R.id.container, fragment)
        tranction.commit()
    }
}