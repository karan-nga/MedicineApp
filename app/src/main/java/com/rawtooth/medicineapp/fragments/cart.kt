package com.rawtooth.medicineapp.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rawtooth.medicineapp.databinding.FragmentCartBinding
import com.rawtooth.medicineapp.fragments.users.User_Precription
import com.rawtooth.medicineapp.fragments.users.user_address
import com.rawtooth.placeorder.PlacedOrder
import com.rawtooth.subscription.MemeberSub

class cart : Fragment() {
    lateinit var binding: FragmentCartBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(layoutInflater)

        binding.orderGoToAddress.setOnClickListener {
            startActivity(Intent(context, user_address::class.java))
        }
        binding.cartAddPrescription.setOnClickListener {
            startActivity(Intent(context, User_Precription::class.java))
        }
        binding.singleScreenV1.setOnClickListener {
            startActivity(Intent(context, MemeberSub::class.java))
        }
        binding.gotoPlaceOrder.setOnClickListener {
            startActivity(Intent(context, PlacedOrder::class.java))
        }
        return binding.root
    }


}