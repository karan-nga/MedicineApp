package com.rawtooth.medicineapp

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(val context: Context):RecyclerView.Adapter<RecyclerView.ViewHolder>() {

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
                return CrouselView(view)
            }
            VIEW_TYPE_TWO_CARD_WIDGET -> {
                val view=LayoutInflater.from(parent.context).inflate(R.layout.card_1_layout,parent,false)
                return ViewHolder(view)
            }
            VIEW_TYPE_SINGLE_CARD -> {
                val view=LayoutInflater.from(parent.context).inflate(R.layout.single_card,parent,false)
                return SingleCard(view)
            }
            VIEW_TYPE_N_LARGE -> {
                val view=LayoutInflater.from(parent.context).inflate(R.layout.n_large_widgets_recycler,parent,false)
                return NLarge(view)
            }
            VIEW_TYPE_N_SMALL -> {
                val view=LayoutInflater.from(parent.context).inflate(R.layout.n_small_widgets_recycler,parent,false)
                return NSmall(view)
            }
            VIEW_TYPE_N_MEDIUM -> {
                val view=LayoutInflater.from(parent.context).inflate(R.layout.n_medium_widgets_recycler,parent,false)
                return NMedium(view)
            }
//            VIEW_TYPE_SINGLE_SCREEN -> {
//                val view=LayoutInflater.from(parent.context).inflate(R.layout.single_screen,parent,false)
//                return SingleCard(view)
//            }
        }

        val view=LayoutInflater.from(parent.context).inflate(R.layout.single_screen,parent,false)
        return SingleScreen(view)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is ViewHolder) {
            holder.itemTitle.text="Upload your prescription"
            holder.itemDes.text="Upload your prescription and \nwe will do the rest"
        } else if(holder is SearchViewHolder) {
                holder.itemTitle.text="Search for medicines, lab tests, doctors"
        }
        else if(holder is CrouselView){
            holder.itemTitle.text="FLAT 25% OFF"
            holder.itemDes.text="on medicines"
            holder.timeLimited.text="Limited Offer"
        }
        else if(holder is SingleCard){
            holder.itemTitle.text="Call us to order"
        }
        else if(holder is NLarge) {
            holder.nLagraHorizontalRecycler.layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
            holder.nLagraHorizontalRecycler.adapter = NLagreAdapter(context)

        }
        else if(holder is NSmall){
            holder.nSamllHorizontalRecycler.layoutManager=LinearLayoutManager(
                context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
            holder.nSamllHorizontalRecycler.adapter=NSmallAdapter(context)
        }
            else if(holder is NMedium){
                holder.nMediumHorizontalRecycler.layoutManager=LinearLayoutManager(
                    context,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
            holder.nMediumHorizontalRecycler.adapter=NMediumlAdapter(context)

        }
    }

    override fun getItemCount(): Int {
    return  8
    }

//    class WidgetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        abstract bind()
//    }

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
        val itemTitle:TextView
        init {
            itemTitle=itemView.findViewById(R.id.tv_card1_title_text)
        }
    }

    inner class CrouselView(itemView: View): RecyclerView.ViewHolder(itemView) {
        val itemTitle:TextView
        val itemDes:TextView
        val timeLimited:TextView
        init {
            itemTitle=itemView.findViewById(R.id.tv_card3_title_text1)
            itemDes=itemView.findViewById(R.id.tv_card3_title_text2)
            timeLimited=itemView.findViewById(R.id.tv_card3_title_text3)

        }
    }
    inner class SingleCard(itemView: View): RecyclerView.ViewHolder(itemView) {
        val itemTitle:TextView

        init {
            itemTitle=itemView.findViewById(R.id.single_card_tv1)
        }
    }
    inner class NLarge(itemView: View): RecyclerView.ViewHolder(itemView) {
            val nLagraHorizontalRecycler:RecyclerView

        init {
            nLagraHorizontalRecycler=itemView.findViewById(R.id.n_large_recycler_view)
        }
    }
    inner class NSmall(itemView: View): RecyclerView.ViewHolder(itemView) {
        val nSamllHorizontalRecycler:RecyclerView

        init {
            nSamllHorizontalRecycler=itemView.findViewById(R.id.nSmallrecyclerLayout)
        }
    }
    inner class NMedium(itemView: View): RecyclerView.ViewHolder(itemView) {
        val nMediumHorizontalRecycler:RecyclerView

        init {
            nMediumHorizontalRecycler=itemView.findViewById(R.id.nMediumRecycle)
        }
    }
    inner class SingleScreen(itemView: View): RecyclerView.ViewHolder(itemView) {

    }




}