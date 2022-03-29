package com.rawtooth.anchal.insurance

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.rawtooth.medicineapp.R
import com.rawtooth.medicineapp.databinding.ActivityPrescriptionBinding

class Prescription_activity : AppCompatActivity() {
    lateinit var binding:ActivityPrescriptionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityPrescriptionBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun covidcare(view: View) {
        startActivity(Intent(this,CovidCare::class.java))
    }
}