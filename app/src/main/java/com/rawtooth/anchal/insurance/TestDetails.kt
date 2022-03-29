package com.rawtooth.anchal.insurance

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rawtooth.medicineapp.R
import com.rawtooth.medicineapp.cart.EnterPatientDetails
import com.rawtooth.medicineapp.databinding.ActivityTestDetailsBinding

class TestDetails : AppCompatActivity() {
    lateinit var binding:ActivityTestDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityTestDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.patientDetailsBtn.setOnClickListener{
            startActivity(Intent(this,EnterPatientDetails::class.java))
        }
    }
}