package com.rawtooth.medicineapp.consult

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rawtooth.medicineapp.R

class Adapter : RecyclerView.Adapter<Adapter.ViewHolder>() {

    var textData= arrayOf("Heart","Knee","Covid","Vitamins","Pregnant")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.report_item_meta, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
     holder.reporttitle.text=textData[position]
    }

    override fun getItemCount(): Int {
        return textData.size
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        var reporttitle = itemView.findViewById<TextView>(R.id.report1)


    }

}