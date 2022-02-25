package com.rawtooth.medicineapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter:RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    private val titles= arrayOf("Upload your prescription")
    private val des= arrayOf("Upload your prescription and we will do the rest")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.two_card_widget,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.itemTitle.text=titles[position]
        holder.itemDes.text=titles[position]
    }

    override fun getItemCount(): Int {
    return  1
    }
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val itemImg:ImageView
        val itemTitle:TextView
        val itemDes:TextView
        init{
            itemImg=itemView.findViewById(R.id.iv_card1_ic)
            itemTitle=itemView.findViewById(R.id.tv_card1_title_text)
            itemDes=itemView.findViewById(R.id.tv_card1_title_sub_text)
        }

    }
}