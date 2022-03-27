package com.rawtooth.anchal.insurance

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rawtooth.medicineapp.R
import com.rawtooth.medicineapp.databinding.ActivityInsuranceBinding

class
Insurance_activity : AppCompatActivity() {
    lateinit var binding:ActivityInsuranceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityInsuranceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rec60.setOnClickListener{
            startActivity(Intent(this,Insurance_Details::class.java))
        }
        binding.rec59.setOnClickListener{
            startActivity(Intent(this,BuildYourHealthPlan::class.java))
        }
    }
}