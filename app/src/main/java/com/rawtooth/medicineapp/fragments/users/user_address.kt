package com.rawtooth.medicineapp.fragments.users

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rawtooth.medicineapp.R
import com.rawtooth.medicineapp.databinding.ActivityUserAddressBinding

class user_address : AppCompatActivity() {
    lateinit var binding:ActivityUserAddressBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityUserAddressBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.check1.setOnClickListener{
            binding.check1.isChecked=true
            binding.check2.isChecked=false
            binding.check3.isChecked=false
        }
        binding.check2.setOnClickListener{
            binding.check1.isChecked=false
            binding.check2.isChecked=true
            binding.check3.isChecked=false
        }
        binding.check3.setOnClickListener{
            binding.check1.isChecked=false
            binding.check2.isChecked=false
            binding.check3.isChecked=true
        }
    }


}
