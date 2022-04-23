package com.rawtooth.medicineapp.cart

import android.content.Intent
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
        binding.patientDetailsBtn.setOnClickListener{
            startActivity(Intent(this,Test_Cart_Order::class.java))
        }
    }

    private fun tally() {
        binding.namePD.text= nameEP
        binding.agePD.text= ageEP
        binding.addressPD.text= addressEP
    }
}