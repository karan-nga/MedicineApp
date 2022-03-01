package com.rawtooth.medicineapp.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rawtooth.medicineapp.R
import com.rawtooth.medicineapp.databinding.FragmentUserBinding
import com.rawtooth.medicineapp.fragments.users.user_address
import com.rawtooth.medicineapp.fragments.users.user_coupons
import com.rawtooth.medicineapp.fragments.users.user_order
import com.rawtooth.medicineapp.fragments.users.user_reminder


class user : Fragment() {
lateinit var userBinding:FragmentUserBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        userBinding = FragmentUserBinding.inflate(layoutInflater)

        userBinding.userOrder.setOnClickListener {
            startActivity(Intent(context, user_order::class.java))
        }
        userBinding.userAddress.setOnClickListener {
            startActivity(Intent(context, user_address::class.java))
        }
        userBinding.userCoupons.setOnClickListener {
            startActivity(Intent(context, user_coupons::class.java))
        }
            userBinding.userMedicineReminder.setOnClickListener {
                startActivity(Intent(context, user_reminder::class.java))
            }
            return userBinding.root
        }

    }
