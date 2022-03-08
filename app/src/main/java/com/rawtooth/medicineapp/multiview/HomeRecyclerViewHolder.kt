package com.rawtooth.medicineapp.multiview

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.rawtooth.medicineapp.databinding.Crousel3Binding
import com.rawtooth.medicineapp.databinding.SearchViewBinding

sealed class HomeRecyclerViewHolder(binding:ViewBinding) :RecyclerView.ViewHolder(binding.root){
    class SearchViewHolder(private val binding: SearchViewBinding):HomeRecyclerViewHolder(binding){
        fun bind(title: HomeRecyclerViewItem.Title){
            binding.tvCard1TitleText.text= title.title
        }
    }
    class CrouselViewHolder(private val binding: Crousel3Binding):HomeRecyclerViewHolder(binding){
        fun bind(title:HomeRecyclerViewItem.Carsoul){
            binding.tvCard3TitleText1.text
        }
    }
}