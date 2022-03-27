package com.rawtooth.medicineapp.ui.mainfragment2

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.rawtooth.anchal.insurance.Messages
import com.rawtooth.medicineapp.RecyclerAdapter
import com.rawtooth.medicineapp.databinding.HomeFragmentBinding

class HomeFragment : Fragment() {

    lateinit var binding: HomeFragmentBinding




    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: MainFragment2ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = HomeFragmentBinding.inflate(layoutInflater)
        binding.messageActivity.setOnClickListener{
           startActivity(Intent(context,Messages::class.java))
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainFragment2ViewModel::class.java)
        binding.mainRecycler.adapter = RecyclerAdapter(requireContext())

    }


}