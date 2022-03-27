package com.rawtooth.subscription

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rawtooth.medicineapp.R
import com.rawtooth.medicineapp.databinding.ActivityMemeberSubBinding

class MemeberSub : AppCompatActivity() {
    lateinit var binding:ActivityMemeberSubBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMemeberSubBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.benfitPoints.setText(R.string.bullted_list)
    }
}