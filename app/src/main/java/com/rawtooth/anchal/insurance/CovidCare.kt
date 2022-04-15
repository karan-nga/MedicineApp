package com.rawtooth.anchal.insurance

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rawtooth.medicineapp.R
import com.rawtooth.medicineapp.databinding.ActivityCovidCareBinding

class CovidCare : AppCompatActivity() {
    lateinit var binding:ActivityCovidCareBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCovidCareBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.testAddBtn.setOnClickListener{
            startActivity(Intent(this,TestDetails::class.java))
        }
    }
}