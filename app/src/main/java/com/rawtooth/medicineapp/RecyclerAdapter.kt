package com.rawtooth.medicineapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter:RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val VIEW_TYPE_SEARCH : Int = 0;
    private  val VIEW_TYPE_TWO_CARD_CROUSEL : Int = 1
    private val VIEW_TYPE_TWO_CARD_WIDGET : Int = 2;
    private  val VIEW_TYPE_SINGLE_CARD : Int = 3
    private  val VIEW_TYPE_N_LARGE : Int = 4
    private  val VIEW_TYPE_N_SMALL : Int = 5
    private  val VIEW_TYPE_N_MEDIUM : Int = 6
    private  val VIEW_TYPE_SINGLE_SCREEN : Int = 7


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        when(viewType) {
            VIEW_TYPE_SEARCH -> {
                val view=LayoutInflater.from(parent.context).inflate(R.layout.search_view,parent,false)
                return SearchViewHolder(view)
            }
            VIEW_TYPE_TWO_CARD_CROUSEL ->{
                val view=LayoutInflater.from(parent.context).inflate(R.layout.crousel_3,parent,false)
                return SearchViewHolder(view)
            }
            VIEW_TYPE_TWO_CARD_WIDGET -> {
                val view=LayoutInflater.from(parent.context).inflate(R.layout.two_card_widget,parent,false)
                return ViewHolder(view)
            }
            VIEW_TYPE_SINGLE_CARD -> {
                val view=LayoutInflater.from(parent.context).inflate(R.layout.single_card,parent,false)
                return SearchViewHolder(view)
            }
            VIEW_TYPE_N_LARGE -> {
                val view=LayoutInflater.from(parent.context).inflate(R.layout.n_large_layout,parent,false)
                return SearchViewHolder(view)
            }
            VIEW_TYPE_N_SMALL -> {
                val view=LayoutInflater.from(parent.context).inflate(R.layout.n_small_layout,parent,false)
                return SearchViewHolder(view)
            }
            VIEW_TYPE_N_MEDIUM -> {
                val view=LayoutInflater.from(parent.context).inflate(R.layout.n_medium_layout,parent,false)
                return SearchViewHolder(view)
            }
            VIEW_TYPE_SINGLE_SCREEN -> {
                val view=LayoutInflater.from(parent.context).inflate(R.layout.single_screen,parent,false)
                return SearchViewHolder(view)
            }
        }

        val view=LayoutInflater.from(parent.context).inflate(R.layout.two_card_widget,parent,false)
        return ViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
    return  7
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

    inner class SearchViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }
}