package com.rawtooth.medicineapp.consult

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.rawtooth.medicineapp.R
import com.rawtooth.medicineapp.databinding.FragmentAppientBinding

class BottomSheetDoc:BottomSheetDialogFragment() {
    lateinit var binding: FragmentAppientBinding
    lateinit var adapter:Adapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding= FragmentAppientBinding.inflate(layoutInflater)
        adapter= Adapter(requireContext())
        binding.prevreport2.adapter=adapter
        binding.prevreport2.layoutManager=LinearLayoutManager(context,
            LinearLayoutManager.HORIZONTAL,
            false)
        return inflater.inflate(R.layout.fragment_appient,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}