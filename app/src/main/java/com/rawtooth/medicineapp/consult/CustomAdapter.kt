package com.rawtooth.medicineapp.consult

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rawtooth.medicineapp.R

class CustomAdapter(val users: ArrayList<Model_Details>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):CustomAdapter. ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.report_item_meta, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: CustomAdapter. ViewHolder, position: Int) {
        holder.bindItems(users[position])
    }

    override fun getItemCount(): Int {
        return users.size
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(modelDetails: Model_Details) {
            val  textViewName= itemView.findViewById(R.id.report1) as TextView
            textViewName.text= modelDetails.reporttitle


        }
    }

}
