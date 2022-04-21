package com.abdsoft.med_dose.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.ImageButton
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.abdsoft.med_dose.R
import com.abdsoft.med_dose.db.DatabaseHelper
import com.google.android.material.card.MaterialCardView
import com.google.android.material.checkbox.MaterialCheckBox
import com.google.android.material.textview.MaterialTextView

class HomeAdapter internal constructor(
    private val homeItems: MutableList<HomeItem?>?,
    private val context: Context?
) : RecyclerView.Adapter<HomeAdapter.ViewHolder?>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.medicine_list, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val homeItem = homeItems?.get(position)
        holder.textMedicine?.setText(homeItem?.getMedicineName())
        holder.textDosageSummary?.setText(homeItem?.getDosageSummary())
        holder.checkBox?.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { compoundButton, b ->
            if (b) holder.imageButtonDelete?.setVisibility(
                View.VISIBLE
            ) else holder.imageButtonDelete?.setVisibility(View.GONE)
        })
        holder.imageButtonDelete?.setOnClickListener(View.OnClickListener {
            val databaseHelper = DatabaseHelper(context)
            databaseHelper.deleteMedicine(holder.textMedicine?.getText().toString())
            holder.cardView?.setVisibility(View.GONE)
            Toast.makeText(
                context,
                holder.textMedicine?.getText().toString() + " deleted",
                Toast.LENGTH_LONG
            ).show()
        })
    }

    override fun getItemCount(): Int {
        return homeItems!!.size
    }

     class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        var textMedicine: MaterialTextView?
        var textDosageSummary: MaterialTextView?
        var cardView: MaterialCardView?
        var checkBox: MaterialCheckBox?
        var imageButtonDelete: ImageButton?

        init {
            textDosageSummary = itemView?.findViewById(R.id.dosage_text_view)
            textMedicine = itemView?.findViewById(R.id.medicine_name_text_view)
            cardView = itemView?.findViewById(R.id.card_view_medicine)
            checkBox = itemView?.findViewById(R.id.medicine_checkbox)
            imageButtonDelete = itemView?.findViewById(R.id.medicine_delete_button)
        }
    }
}