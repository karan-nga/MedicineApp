package com.rawtooth.medicineapp.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rawtooth.loginresgister.Login
import com.rawtooth.medicineapp.R
import com.rawtooth.medicineapp.databinding.FragmentUserBinding
import com.rawtooth.medicineapp.fragments.users.*


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
        userBinding.userLogout.setOnClickListener{
            startActivity(Intent(context,Login::class.java))
                    }
            userBinding.userMedicineReminder.setOnClickListener {
                startActivity(Intent(context, user_reminder::class.java))
            }
        userBinding.userPrescription.setOnClickListener{
            startActivity(Intent(context,User_Precription::class.java))
        }
            return userBinding.root
        }

    }
