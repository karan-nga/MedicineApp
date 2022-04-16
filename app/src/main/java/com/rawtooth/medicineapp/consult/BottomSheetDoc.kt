package com.rawtooth.medicineapp.consult

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.rawtooth.medicineapp.R
import com.rawtooth.medicineapp.databinding.FragmentAppientBinding
import com.rawtooth.medicineapp.databinding.FragmentUserBinding

class BottomSheetDoc:BottomSheetDialogFragment() {
    lateinit var binding: FragmentAppientBinding
    lateinit var adapter:Adapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding= FragmentAppientBinding.inflate(layoutInflater)
        return inflater.inflate(R.layout.fragment_appient,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter= Adapter()
        binding.prevreport2.adapter=adapter
        binding.prevreport2.layoutManager=LinearLayoutManager(context)
    }
}