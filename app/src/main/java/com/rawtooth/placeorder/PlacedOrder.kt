package com.rawtooth.placeorder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rawtooth.medicineapp.MainActivity2
import com.rawtooth.medicineapp.R
import com.rawtooth.medicineapp.databinding.ActivityPlacedOrderBinding

class PlacedOrder : AppCompatActivity() {
    lateinit var binding:ActivityPlacedOrderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityPlacedOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.end.setOnClickListener{
            val i = Intent(this,    MainActivity2::class.java)

            i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(i)
        }

    }
}