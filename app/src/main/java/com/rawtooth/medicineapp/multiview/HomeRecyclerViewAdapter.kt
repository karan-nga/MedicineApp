package com.rawtooth.medicineapp.multiview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rawtooth.medicineapp.R
import com.rawtooth.medicineapp.databinding.Crousel3Binding
import com.rawtooth.medicineapp.databinding.SearchViewBinding
import com.rawtooth.medicineapp.databinding.SingleCardBinding
import java.lang.IllegalArgumentException
import java.lang.IllegalStateException

class HomeRecyclerViewAdapter():RecyclerView.Adapter<HomeRecyclerViewHolder>() {
    var items= listOf<HomeRecyclerViewItem>()
    set(value) {
        field=value
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeRecyclerViewHolder {
        return when(viewType){
            R.layout.search_view -> HomeRecyclerViewHolder.SearchViewHolder(
                SearchViewBinding.inflate(
                    LayoutInflater.from(parent.context),parent,false)
                )

            R.layout.crousel_3 ->HomeRecyclerViewHolder.CrouselViewHolder(
                Crousel3Binding.inflate(
                    LayoutInflater.from(parent.context),parent,false)
                )
            R.layout.single_card ->HomeRecyclerViewHolder.SingleCardViewHolder(
                SingleCardBinding.inflate(
                    LayoutInflater.from(parent.context),parent,false)
                )


            else -> throw  IllegalArgumentException("Invaild view type")
        }
    }

    override fun onBindViewHolder(holder: HomeRecyclerViewHolder, position: Int) {
       when(holder){
           is HomeRecyclerViewHolder.CrouselViewHolder -> holder.bind(items[position] as HomeRecyclerViewItem.Carsoul)
           is HomeRecyclerViewHolder.SearchViewHolder -> holder.bind(items[position]as HomeRecyclerViewItem.Title)
           is HomeRecyclerViewHolder.SingleCardViewHolder -> holder.bind(items[position] as HomeRecyclerViewItem.SingleCard)
       }
    }

    override fun getItemCount(): Int {
       return  items.size
    }

    override fun getItemViewType(position: Int): Int {
        return when(items[position]){
            is HomeRecyclerViewItem.Carsoul -> R.layout.crousel_3
            is HomeRecyclerViewItem.SingleCard -> R.layout.single_card
            is HomeRecyclerViewItem.Title -> R.layout.search_view
        }
    }
}