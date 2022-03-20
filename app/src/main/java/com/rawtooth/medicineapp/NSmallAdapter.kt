package com.rawtooth.medicineapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NSmallAdapter(val context: Context):RecyclerView.Adapter<NSmallAdapter.NLagraViewHolder>() {
    var nLargeImages = arrayOf<Int>(
        R.drawable.small1,
        R.drawable.small2,
        R.drawable.small3,
        R.drawable.small4,
        R.drawable.small5
    )
    var NLagreText= arrayOf("Covid Care","Skin Care","Home Care","Personal Care","Pet Care")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NLagraViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.n_large_layout,parent,false)
        return NLagraViewHolder(view)
    }

    override fun onBindViewHolder(holder: NLagraViewHolder, position: Int) {
      holder.img.setImageResource(nLargeImages[position])
        holder.text.text=NLagreText[position]
    }

    override fun getItemCount(): Int {
        return  nLargeImages.size
    }
    class NLagraViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var img=itemView.findViewById<ImageView>(R.id.n_large_layout_v2)
        var text=itemView.findViewById<TextView>(R.id.n_large_layout_tv1)
    }
}