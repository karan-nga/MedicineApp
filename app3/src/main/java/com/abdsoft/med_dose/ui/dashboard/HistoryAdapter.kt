package com.abdsoft.med_dose.ui.dashboard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abdsoft.med_dose.R
import com.google.android.material.textview.MaterialTextView

class HistoryAdapter(
    private val historyItems: MutableList<HistoryItem?>?,
    private val context: Context?
) : RecyclerView.Adapter<HistoryAdapter.ViewHolder?>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.history_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val historyItem = historyItems?.get(position)
        holder.textViewName?.append(historyItem?.getName())
        holder.textViewDate?.append(historyItem?.getDate())
        holder.textViewTimesPerDay?.append(historyItem?.getTimesPerDay().toString())
        holder.textViewDosage?.append(historyItem?.getTotalDosage().toString())
        holder.textViewTimings?.append(historyItem?.getTimings())
    }

    override fun getItemCount(): Int {
        return historyItems!!.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textViewName: MaterialTextView?
        var textViewDate: MaterialTextView?
        var textViewTimesPerDay: MaterialTextView?
        var textViewDosage: MaterialTextView?
        var textViewTimings: MaterialTextView?

        init {
            textViewName = itemView.findViewById(R.id.medicine_name_text_view_history)
            textViewDate = itemView.findViewById(R.id.medicine_date_text_view_history)
            textViewTimesPerDay =
                itemView.findViewById(R.id.medicine_times_per_day_text_view_history)
            textViewDosage = itemView.findViewById(R.id.total_dosage_text_view_history)
            textViewTimings = itemView.findViewById(R.id.medicine_timings_text_view_history)
        }
    }
}