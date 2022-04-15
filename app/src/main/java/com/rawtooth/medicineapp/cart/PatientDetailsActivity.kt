package com.rawtooth.medicineapp.cart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rawtooth.medicineapp.R
import com.rawtooth.medicineapp.databinding.ActivityPatientDetailsBinding

class PatientDetailsActivity : AppCompatActivity() {
    lateinit var binding:ActivityPatientDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityPatientDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        tally()
    }

    private fun tally() {
        binding.namePD.text= nameEP
        binding.agePD.text= ageEP
        binding.addressPD.text= addressEP
    }
}