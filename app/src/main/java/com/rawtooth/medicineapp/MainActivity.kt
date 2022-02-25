package com.rawtooth.medicineapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rawtooth.medicineapp.databinding.ActivityMainBinding

import com.synnapps.carouselview.ImageListener

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

}