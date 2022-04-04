package com.rawtooth.medicineapp.consult

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rawtooth.medicineapp.R

class CustomAdapter(val users: ArrayList<Model_Details>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.ViewHolder {
        TODO("Not yet implemented")
        val v = LayoutInflater.from(parent.context).inflate(R.layout.report_item_meta, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: CustomAdapter.ViewHolder, position: Int) {
        TODO("Not yet implemented")
        holder.bindItems(users[position])

    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
        return users.size
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(user: Model_Details) {
            var reporttitle= itemView.findViewById<TextView>(R.id.report1)
            reporttitle.text=user.reporttitle


        }
    }

}
