package com.rawtooth.medicineapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rawtooth.medicineapp.R
import com.rawtooth.medicineapp.databinding.FragmentInsuranceeBinding


class Insurancee : Fragment() {

lateinit var binding:FragmentInsuranceeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding= FragmentInsuranceeBinding.inflate(layoutInflater)



        return binding.root }


}