package com.rawtooth.medicineapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NMediumlAdapter(val context: Context):RecyclerView.Adapter<NMediumlAdapter.NLagraViewHolder>() {
    var nLargeImages = arrayOf(
        R.drawable.medium1,
        R.drawable.medium1,
        R.drawable.medium1,
        R.drawable.medium1,
        R.drawable.medium1
    )
    var NLagreText= arrayOf("Telam 40/5mg Strip Of 15 Tablets","Telam 40/5mg Strip Of 15 Tablets","Telam 40/5mg Strip Of 15 Tablets","Telam 40/5mg Strip Of 15 Tablets","Telam 40/5mg Strip Of 15 Tablets")
    var nMediumPrice=arrayOf("Rs 182.12","Rs 182.12","Rs 182.12","Rs 182.12","Rs 182.12")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NLagraViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.n_medium_layout,parent,false)
        return NLagraViewHolder(view)
    }

    override fun onBindViewHolder(holder: NLagraViewHolder, position: Int) {
      holder.img.setImageResource(nLargeImages[position])
        holder.text.text=NLagreText[position]
        holder.price.text=nMediumPrice[position]
    }

    override fun getItemCount(): Int {
        return  nLargeImages.size
    }
    class NLagraViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var img=itemView.findViewById<ImageView>(R.id.n_medium_layout_iv1)
        var text=itemView.findViewById<TextView>(R.id.n_medium_layout_tv1)
        var price=itemView.findViewById<TextView>(R.id.n_medium_layout_tv2)
    }
}