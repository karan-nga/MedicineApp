package com.rawtooth.medicineapp.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rawtooth.anchal.insurance.BuildYourHealthPlan
import com.rawtooth.anchal.insurance.Insurance_Details
import com.rawtooth.medicineapp.R
import com.rawtooth.medicineapp.databinding.FragmentInsuranceeBinding


class Insurancee : Fragment() {

lateinit var binding:FragmentInsuranceeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding= FragmentInsuranceeBinding.inflate(layoutInflater)
        binding.buyNewPlan.setOnClickListener{
            startActivity(Intent(context, Insurance_Details::class.java))
        }
        binding.buyhealthcard.setOnClickListener{
            startActivity(Intent(context, BuildYourHealthPlan::class.java))
        }


        return binding.root }


}