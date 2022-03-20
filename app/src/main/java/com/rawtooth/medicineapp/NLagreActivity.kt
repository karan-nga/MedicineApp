package com.rawtooth.medicineapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.rawtooth.medicineapp.databinding.ActivityNlagreBinding

class NLagreActivity : AppCompatActivity() {
    lateinit var binding:ActivityNlagreBinding
    lateinit var adapter:NLagreAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityNlagreBinding.inflate(layoutInflater)
        adapter= NLagreAdapter(this)
        binding.recycleNLarge.adapter=adapter
        binding.recycleNLarge.layoutManager=LinearLayoutManager(this)
        setContentView(binding.root)
    }
}