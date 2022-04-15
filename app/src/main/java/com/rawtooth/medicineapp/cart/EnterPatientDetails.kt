package com.rawtooth.medicineapp.cart

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.rawtooth.medicineapp.databinding.ActivityEnterPatientDetailsBinding
lateinit var nameEP:String
lateinit var genderEP:String
lateinit var ageEP:String
lateinit var addressEP:String
class EnterPatientDetails : AppCompatActivity() {
    lateinit var binding: ActivityEnterPatientDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEnterPatientDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.patientDetailsBtn.setOnClickListener {
            check()
        }

    }

    private fun check() {
         nameEP = binding.nameEdt.text.toString()
        genderEP = binding.genderEdt.text.toString()
         ageEP = binding.ageEdt.text.toString()
         addressEP = binding.address.text.toString()
        val check: Boolean = vali(nameEP, genderEP, ageEP, addressEP)
        if (check) {
            startActivity(Intent(this, TimeDateSelection::class.java))
        } else {
            Toast.makeText(this, "Enter all fields", Toast.LENGTH_SHORT).show()
        }
    }

    private fun vali(name: String, gender: String, age: String, address: String): Boolean {
        if (name.isEmpty()) {
            binding.nameEdt.requestFocus()
            binding.nameEdt.setError("Field cannot be empty")
            return false
        } else if(gender.isEmpty()) {
            binding.genderEdt.requestFocus()
            binding.genderEdt.setError("Field cannot be empty")
            return false
        }
        else if(age.isEmpty()) {
            binding.ageEdt.requestFocus()
            binding.ageEdt.setError("Field cannot be empty")
            return false
        }
        else if(address.isEmpty()) {
            binding.address.requestFocus()
            binding.address.setError("Field cannot be empty")
            return false
        }

        else {
            return true
        }
    }
}






