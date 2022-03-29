package com.rawtooth.medicineapp.cart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rawtooth.medicineapp.R
import com.rawtooth.medicineapp.databinding.ActivityEnterPatientDetailsBinding

class EnterPatientDetails : AppCompatActivity() {
    lateinit var binding:ActivityEnterPatientDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityEnterPatientDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.patientDetailsBtn.setOnClickListener{
            startActivity(Intent(this,TimeDateSelection::class.java))
        }
    }
}